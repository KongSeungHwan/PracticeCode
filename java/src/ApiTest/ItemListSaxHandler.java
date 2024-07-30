package ApiTest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemListSaxHandler extends DefaultHandler {
    List<Map<String,String>> itemList = new ArrayList<>();
    private String data;
    private Map<String,String> current= new HashMap<>();

    private int totalCount = 0;
    public List<Map<String,String>> getItemList() {
        return itemList;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")) {
            current= new HashMap<>();
        }
        data = "";
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data += new String(ch, start, length);
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!qName.matches("items|body")){
            if(!qName.equals("item")){
                if(qName.matches("totalCount")){
                    totalCount = Integer.parseInt(data);
                }else current.put(qName,data);
            }
            else itemList.add(current);
        }
    }
    public int getTotalCount() {
        return totalCount;
    }
}
