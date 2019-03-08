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


class SearchServiceHandler extends DefaultHandler {
	public List<SearchModel> Items;
	private SearchModel currentItem;
	private boolean inItemElement = false;
	private String tempValue;

	public SearchServiceHandler( ){
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
		}
		else if (localName.equals("publisher")) {
			tempValue = "";
		}
		else if (localName.equals("author")) {
			tempValue = "";
		}
		else if (localName.equals("isbn")) {
			tempValue = "";
		}
		else if (localName.equals("categoryName")) {
			tempValue = "";
		}
		
		
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		tempValue = tempValue + new String(ch,start,length);
	}

	public void endElement(String namespaceURI, String localName,String qName) {
		if(inItemElement){
			if (localName.equals("item")) {
				Items.add(currentItem);
				currentItem = null;
				inItemElement = false;
			} else if (localName.equals("cover")) {
				currentItem.cover = tempValue;
			} else if (localName.equals("title")) {
				currentItem.title = tempValue;
			}
			else if (localName.equals("publisher")) {
				currentItem.publisher = tempValue;
			}
			else if (localName.equals("author")) {
				currentItem.author = tempValue;
			}
			else if (localName.equals("isbn")) {
				currentItem.isbn = tempValue;
			}
			else if (localName.equals("categoryName")) {
				currentItem.categoryName = tempValue;
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

public class SearchAladdinService {
	private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemSearch.aspx?";

	public static String GetUrl(String searchWord) throws Exception {
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("ttbkey", "ttbshin_oi1259001");
		hm.put("Query", URLEncoder.encode(searchWord, "UTF-8"));
		hm.put("Sort", "Accuracy");
		hm.put("QueryType", "Keyword");
		hm.put("MaxResults", "10");
		hm.put("start", "1");
		hm.put("SearchTarget", "Book");
		hm.put("output", "xml");

		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val  = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}

		return BASE_URL + sb.toString();
	}

	public static void main(String[] args) throws Exception {
		String url = GetUrl(args[0]);
		SearchServiceHandler api = new SearchServiceHandler();
		api.parseXml(url);
		for(SearchModel item : api.Items){
			System.out.println(item.cover + " : " + item.title + item.publisher + item.author + item.isbn + item.categoryName);
		}
	}
}