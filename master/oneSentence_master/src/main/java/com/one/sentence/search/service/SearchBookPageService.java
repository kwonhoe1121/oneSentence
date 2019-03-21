package com.one.sentence.search.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

import com.one.sentence.search.model.TestModel;

@Service
public class SearchBookPageService {

	private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemLookUp.aspx?";

	// http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=[TTBKey]&itemIdType=ISBN&ItemId=[도서의ISBN]&output=xml&Version=20131101&OptResult=ebookList,usedList,reviewList
	public static String GetUrl(String searchWord) throws Exception {
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("ttbkey", "ttbshin_oi1259001");
		hm.put("itemIdType", "ISBN");
		hm.put("ItemId", URLEncoder.encode(searchWord, "UTF-8"));
		hm.put("output", "xml");
		hm.put("Version", "20131101");
		hm.put("OptResult", "ebookList,usedList,reviewList");

		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}

		return BASE_URL + sb.toString();
	}

	public List<TestModel> getTestModel(String searchWord) throws Exception {
		String url = GetUrl(searchWord);
		SearchServiceHandlerone3 api = new SearchServiceHandlerone3();
		api.parseXml(url);
		for (TestModel item : api.Items) {
			 System.out.println("item.itemPage = "+item.itemPage+" item.toc = "+ item.toc);
		}

		return api.Items;
	}
}

class SearchServiceHandlerone3 extends DefaultHandler {
	public List<TestModel> Items;
	private TestModel currentItem;
	private boolean inItemElement = false;
	private String tempValue;


	public SearchServiceHandlerone3() {
		Items = new ArrayList<TestModel>();
	}

	public void startElement(String namespace, String localName, String qName, Attributes atts) {
		if (localName.equals("item")) {
			currentItem = new TestModel();
			inItemElement = true;
		} else if (localName.equals("toc")) {
			tempValue = "";
		} else if (localName.equals("itemPage")) {
			tempValue = "";
		} 
	}

	// 1234
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempValue = tempValue + new String(ch, start, length);
		System.out.println(ch);

	}

	public void endElement(String namespaceURI, String localName, String qName) {
		if (inItemElement) {
			if (localName.equals("item")) {
				Items.add(currentItem);
				currentItem = null;
				inItemElement = false;
			} else if (localName.equals("toc")) {
				currentItem.toc = tempValue;
			} else if (localName.equals("itemPage")) {
				currentItem.itemPage = tempValue;
			} 

		}
	}

	public void parseXml(String xmlUrl) throws Exception {
		System.out.println();
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		ParserAdapter pa = new ParserAdapter(sp.getParser());
		pa.setContentHandler(this);
		pa.parse(xmlUrl);
	}
}