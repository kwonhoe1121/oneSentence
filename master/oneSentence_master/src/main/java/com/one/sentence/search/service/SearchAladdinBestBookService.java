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

import com.one.sentence.search.model.SearchModel;

@Service
public class SearchAladdinBestBookService {

	private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemSearch.aspx?";

	public static String GetUrl(String searchWord) throws Exception {
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("ttbkey", "ttbshin_oi1259001");
		hm.put("Query", URLEncoder.encode(searchWord, "UTF-8"));
		hm.put("Sort", "SalesPoint");
		hm.put("QueryType", "Keyword");
		hm.put("MaxResults", "100");
		hm.put("start", "1");
		hm.put("SearchTarget", "Book");
		hm.put("output", "xml");

		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}

		return BASE_URL + sb.toString();
	}

	public List<SearchModel> getSearchModel(String searchWord) throws Exception {
		String url = GetUrl(searchWord);
		SearchServiceHandlertwo api = new SearchServiceHandlertwo();
		api.parseXml(url);

		return api.Items;
	}
}

class SearchServiceHandlertwo extends DefaultHandler {
	public List<SearchModel> Items;
	private SearchModel currentItem;
	private boolean inItemElement = false;
	private String tempValue;

	public SearchServiceHandlertwo() {
		Items = new ArrayList<SearchModel>();
	}

	public void startElement(String namespace, String localName, String qName, Attributes atts) {
		if (localName.equals("item")) {
			currentItem = new SearchModel();
			inItemElement = true;
		} else if (localName.equals("cover")) {
			tempValue = "";
		} else if (localName.equals("title")) {
			tempValue = "";
		} else if (localName.equals("publisher")) {
			tempValue = "";
		} else if (localName.equals("author")) {
			tempValue = "";
		} else if (localName.equals("isbn")) {
			tempValue = "";
		} else if (localName.equals("categoryName")) {
			tempValue = "";
		} else if (localName.equals("pubDate")) {
			tempValue = "";
		}

	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempValue = tempValue + new String(ch, start, length);
	}

	public void endElement(String namespaceURI, String localName, String qName) {
		if (inItemElement) {
			if (localName.equals("item")) {
				Items.add(currentItem);
				currentItem = null;
				inItemElement = false;
			} else if (localName.equals("cover")) {
				currentItem.cover = tempValue;
			} else if (localName.equals("title")) {
				currentItem.title = tempValue;
			} else if (localName.equals("publisher")) {
				currentItem.publisher = tempValue;
			} else if (localName.equals("author")) {
				currentItem.author = tempValue;
			} else if (localName.equals("isbn")) {
				currentItem.isbn = tempValue;
			} else if (localName.equals("categoryName")) {
				currentItem.categoryName = tempValue;
			} else if (localName.equals("pubDate")) {
				currentItem.pubDate = tempValue;
			}

		}
	}

	public void parseXml(String xmlUrl) throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		ParserAdapter pa = new ParserAdapter(sp.getParser());
		pa.setContentHandler(this);
		pa.parse(xmlUrl);
	}
}
