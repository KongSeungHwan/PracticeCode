package ApiTest;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ApiTest2 {
    public static void main(String args[]){
        String url = "https://apigateway.kisti.re.kr/openapicall.do";

        try {
            StringBuilder builder = configUrl(url,100,"BI","코로나","ARTI");
            ItemListSaxHandler itemListSaxHandler = saxParser(responseXml(builder),List.of("CN","Publisher","Title","Author","ContentURL","Keyword"));
            IntStream.rangeClosed(0,itemListSaxHandler.getItemList().size()-1).boxed().forEach(idx->{
                Map<String,String> item = itemListSaxHandler.getItemList().get(idx);
                System.out.println("-----------------");
                item.keySet().forEach(k->{
                    System.out.print("\t "+k+":"+item.get(k)+"\n");
                    System.out.println();
                });
                System.out.println("-----------------");
            });
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }


    }
    public static StringBuilder configUrl(String url,int pageNum,String keyword,String searchWord,String target) throws UnsupportedEncodingException {
        String clientId ="504508ce88507ad97a89d7ec4868b1713f7bf67d8ad69eed2b659d87c51863d4";
        String token = "f2c317cd81181ff892eec8bc664a3cb2603a06dca06be60ae2d100f825cb88ab";
        StringBuilder urlBuilder = new StringBuilder(url); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("client_id","UTF-8") + "="+URLEncoder.encode(clientId)); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("token","UTF-8") + "=" + URLEncoder.encode(token));
        urlBuilder.append("&"+URLEncoder.encode("version","UTF-8")+"="+"1.0");
        urlBuilder.append("&"+URLEncoder.encode("action","UTF-8")+"="+"search");
        urlBuilder.append("&"+URLEncoder.encode("target","UTF-8")+"="+target);
        urlBuilder.append("&"+URLEncoder.encode("searchQuery","UTF-8")+"="+URLEncoder.encode("{\""+keyword+"\":\""+searchWord+"\"}","UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("curPage","UTF-8")+"="+pageNum);
        urlBuilder.append("&"+URLEncoder.encode("rowCount","UTF-8")+"="+100);
        System.out.println();
        return urlBuilder;
    }
    public static String responseXml(StringBuilder apiUrl) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL(apiUrl.toString());
        System.out.println(apiUrl.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        //System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }
    public static ItemListSaxHandler saxParser(String xml, List<String> tokenList) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        ItemListSaxHandler handler = new ItemListSaxHandler(tokenList);
        saxParser.parse( new ByteArrayInputStream(xml.getBytes()),handler);
        return handler;
    }
}
