package javaPrac;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SplitPrac {

    public static void main(String args[]){
        String key = "v5+sD5rtmOP7v2mqji0NTCSUmEaiVuVzXqriXDtFliZzoH10RRFuCeFKCEefbVp/o+QcBui6/zG2GGQj6Oupfw==";
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
            responseXml(urlMap.get(1),key);
            responseXml(urlMap.get(2),key);
            responseXml(urlMap.get(3),key);
            responseXml(urlMap.get(4),key);
            responseXml(urlMap.get(5),key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void responseXml(String apiUrl,String key) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(apiUrl); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+URLEncoder.encode(key)); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호 (미입력시 1)*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지당 개수 (미입력시 10)*/
        URL url = new URL(urlBuilder.toString());
        System.out.println(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        System.out.println(sb.toString());
    }
}
