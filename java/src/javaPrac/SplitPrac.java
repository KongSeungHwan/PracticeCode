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
        Map<Integer,Map<String,String>> reqMap = new HashMap<>();
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
            response(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void response(String key) throws IOException {


        StringBuilder urlBuilder = new StringBuilder("http://211.188.64.69/OpenAPI/service/tech/techall"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+URLEncoder.encode(key)); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("stechNum","UTF-8") + "=" + URLEncoder.encode("S2014004454", "UTF-8")); /*기술번호*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호 (미입력시 1)*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1,000", "UTF-8")); /*페이지당 개수 (미입력시 10)*/
        urlBuilder.append("&" + URLEncoder.encode("techName","UTF-8") + "=" + URLEncoder.encode("카페인산에스테르 함유 항균 골 시멘트 조성물 및 이의 제조방법", "UTF-8")); /*기술명*/
        urlBuilder.append("&" + URLEncoder.encode("summary","UTF-8") + "=" + URLEncoder.encode("<기술개요 및 특징> 종래의 골시멘트 조성물은 뼈의 결손부의 보전제,", "UTF-8")); /*기술내용*/
        urlBuilder.append("&" + URLEncoder.encode("appFld","UTF-8") + "=" + URLEncoder.encode("의료용 골시멘트", "UTF-8")); /*기술응용분야*/
        urlBuilder.append("&" + URLEncoder.encode("orgName","UTF-8") + "=" + URLEncoder.encode("리온아이피엘", "UTF-8")); /*기관명*/
        urlBuilder.append("&" + URLEncoder.encode("tcateCode","UTF-8") + "=" + URLEncoder.encode("J", "UTF-8")); /*기술 분야별 분류 코드*/
        urlBuilder.append("&" + URLEncoder.encode("orgType","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*기관 유형별 분류 코드*/
        urlBuilder.append("&" + URLEncoder.encode("staRegDate","UTF-8") + "=" + URLEncoder.encode("2014-01-01", "UTF-8")); /*판매기술 시작일*/
        urlBuilder.append("&" + URLEncoder.encode("endRegDate","UTF-8") + "=" + URLEncoder.encode("2024-10-01", "UTF-8")); /*판매기술 종료일*/
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
