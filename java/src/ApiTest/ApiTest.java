package ApiTest;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTest {

    public static void main(String args[]){
        Map<Integer,String> urlMap = new HashMap<>();
        urlMap.put(1,"http://211.188.64.69/OpenAPI/service/tech/techall");
        //한국산업기술진흥원_기술은행 기술정보 DB 서비스
        urlMap.put(2,"http://211.188.64.69/OpenAPI/service/tech/techallplus");
        // 한국산업기술진흥원_기술시장정보 및 부가정보 DB 서비스
        urlMap.put(3,"http://211.188.64.69/OpenAPI/service/tech/needtech");
        //한국산업기술진흥원_기술은행 수요기술 조회 서비스
        urlMap.put(4,"http://211.188.64.69/OpenAPI/service/tech/techpatent");
        //한국산업기술진흥원_기술은행 등록기술 특허 조회 서비스
        urlMap.put(5,"http://211.188.64.69/OpenAPI/service/tech/patentall");
        //한국산업기술진흥원_기술은행 기부/나눔 기술정보 DB 서비스
        try {
            StringBuilder builder = configUrl(urlMap.get(1));
            builder.append("&" + URLEncoder.encode("stechNum","UTF-8") + "=" + URLEncoder.encode("S2014004454", "UTF-8"));
            ItemListSaxHandler handler = saxParser(responseXml(new StringBuilder(builder.toString())));
            List<Map<String,String>> list = handler.getItemList();
            System.out.println("1.한국산업기술진흥원_기술은행 기술정보 DB 서비스");
            System.out.println("총 "+handler.getTotalCount()+" 항목");
            if(list.isEmpty()) System.out.println("\t결과 없음");
            for(int idx = 0; idx< list.size();idx++){
                System.out.printf("\t기술명: %s \n",list.get(idx).get("techName"));
                System.out.printf("\t기업명: %s \n",list.get(idx).get("orgName"));
                System.out.printf("\t기술번호: %s \n",list.get(idx).get("stechNum"));
                System.out.printf("\t특허번호: %s \n",list.get(idx).get("patentAplcNo"));
                builder = configUrl(urlMap.get(2));
                builder.append("&" + URLEncoder.encode("sltchNo","UTF-8") + "=" + URLEncoder.encode(list.get(idx).get("stechNum"), "UTF-8"));
                builder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8"));
                handler = saxParser(responseXml(new StringBuilder(builder.toString())));
                List<Map<String,String>> result = handler.getItemList();
                System.out.println("\t2-1.한국산업기술진흥원_기술은행 기술정보 DB 서비스 조회(1의 기술 코드로 검색)");
                if(result.isEmpty()) System.out.println("\t결과 없음 \n");
                for(int idx1=0;idx1< result.size();idx1++){
                    System.out.printf("\t\t판매기술번호: %s \n",result.get(idx1).get("sltchNo"));
                    System.out.printf("\t\t판매기술명: %s \n",result.get(idx1).get("sltchNm"));
                    System.out.printf("\t\t기업명: %s \n",result.get(idx1).get("entrprNm"));
                    System.out.println();
                }
                builder = configUrl(urlMap.get(2));
                builder.append("&" + URLEncoder.encode("entrprNm","UTF-8") + "=" + URLEncoder.encode(list.get(idx).get("orgName"), "UTF-8"));
                builder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8"));
                handler = saxParser(responseXml(new StringBuilder(builder.toString())));
                result = handler.getItemList();
                System.out.println("\t2-2.한국산업기술진흥원_기술은행 기술정보 DB 서비스 조회(1의 기업명으로 검색)");
                if(result.isEmpty()) System.out.println("\t결과 없음 \n");
                for(int idx1=0;idx1< result.size();idx1++){
                    System.out.printf("\t\t판매기술번호: %s \n",result.get(idx1).get("sltchNo"));
                    System.out.printf("\t\t판매기술명: %s \n",result.get(idx1).get("sltchNm"));
                    System.out.printf("\t\t기업명: %s \n",result.get(idx1).get("entrprNm"));
                    System.out.println();
                }
                builder = configUrl(urlMap.get(2));
                builder.append("&" + URLEncoder.encode("sltchNm","UTF-8") + "=" + URLEncoder.encode(list.get(idx).get("techName"), "UTF-8"));
                builder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8"));
                handler = saxParser(responseXml(new StringBuilder(builder.toString())));
                result = handler.getItemList();
                System.out.println("\t2-3.한국산업기술진흥원_기술은행 기술정보 DB 서비스 조회(1의 기술명으로 검색)");
                if(result.isEmpty()) System.out.println("\t결과 없음 \n");
                for(int idx1=0;idx1< result.size();idx1++){
                    System.out.printf("\t\t판매기술번호: %s \n",result.get(idx1).get("sltchNo"));
                    System.out.printf("\t\t판매기술명: %s \n",result.get(idx1).get("sltchNm"));
                    System.out.printf("\t\t기업명: %s \n",result.get(idx1).get("entrprNm"));
                    System.out.println();
                }

                builder = configUrl(urlMap.get(3));
                builder.append("&" + URLEncoder.encode("dmdtchNm","UTF-8") + "=" + URLEncoder.encode(list.get(idx).get("techName"), "UTF-8"));
                builder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8"));
                System.out.println("\t3.한국산업기술진흥원_기술은행 수요기술 조회 서비스(1의 기술명으로 검색)");
                handler = saxParser(responseXml(new StringBuilder(builder.toString())));
                result = handler.getItemList();
                if(result.isEmpty()) System.out.println("\t결과 없음 \n");
                for(int idx1=0;idx1< result.size();idx1++){
                    System.out.printf("\t\t판매기술번호: %s \n",result.get(idx1).get("dmdtchNo"));
                    System.out.printf("\t\t판매기술명: %s \n",result.get(idx1).get("dmdtchNm"));
                    System.out.println();
                }
                builder = configUrl(urlMap.get(4));
                builder.append("&" + URLEncoder.encode("sltchNo","UTF-8") + "=" + URLEncoder.encode(list.get(idx).get("stechNum"), "UTF-8"));
                builder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8"));
                System.out.println("\t4.한국산업기술진흥원_기술은행 등록기술 특허 조회 서비스(1의 기술코드로 검색)");
                handler = saxParser(responseXml(new StringBuilder(builder.toString())));
                result = handler.getItemList();
                if(result.isEmpty()) System.out.println("\t결과 없음 \n");
                for(int idx1=0;idx1< result.size();idx1++){
                    System.out.printf("\t\t특허출원번호: %s \n",result.get(idx1).get("patentAplcNo"));
                    System.out.printf("\t\t기술번호: %s \n",result.get(idx1).get("sltchNo"));
                    System.out.printf("\t\t출원인: %s \n",result.get(idx1).get("applnmNm"));
                    System.out.println();
                    builder = configUrl(urlMap.get(5));
                    if(result.get(idx1).get("patentAplcNo") == null) continue;
                    builder.append("&" + URLEncoder.encode("patNo","UTF-8") + "=" + URLEncoder.encode(result.get(idx1).get("patentAplcNo"), "UTF-8"));
                    builder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8"));
                    System.out.println("\t5.한국산업기술진흥원_기술은행 기부/나눔 기술정보 DB 서비스(4의 특허출원번호로 검색)");
                    handler = saxParser(responseXml(new StringBuilder(builder.toString())));
                    List<Map<String,String>> result1 = handler.getItemList();
                    if(result1.isEmpty()) System.out.println("\t결과 없음 \n");
                    for(int idx2=0;idx2< result1.size();idx2++){
                        System.out.printf("\t\t제목: %s \n",result1.get(idx2).get("patAlias"));
                        System.out.printf("\t\t특허번호: %s \n",result1.get(idx2).get("patNo"));
                        System.out.println();
                    }
                }
            };



        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }


    }
    public static StringBuilder configUrl(String url) throws UnsupportedEncodingException {
        String key = "v5+sD5rtmOP7v2mqji0NTCSUmEaiVuVzXqriXDtFliZzoH10RRFuCeFKCEefbVp/o+QcBui6/zG2GGQj6Oupfw==";
        StringBuilder urlBuilder = new StringBuilder(url); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+URLEncoder.encode(key)); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호 (미입력시 1)*/
        return urlBuilder;
    }
    public static String responseXml(StringBuilder apiUrl) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL(apiUrl.toString());
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
    public static ItemListSaxHandler saxParser(String xml) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        ItemListSaxHandler handler = new ItemListSaxHandler();
        saxParser.parse( new ByteArrayInputStream(xml.getBytes()),handler);
        return handler;
    }
}
