/*
package gptCodingTest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GptCodingTest04 {
    public static void main(String args[]){
        String apiUrl = "http://localhost:11434/api/chat";
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.printf("Gpt에게 질문하세요! \n");
            System.out.print(">>");
            String userInput = bf.readLine();
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setReadTimeout(300000);
            connection.setConnectTimeout(300000);

            JSONObject jsonInput = new JSONObject();
            jsonInput.put("model", "KongGPT:latest");
            jsonInput.put("max_tokens", 256);
            jsonInput.put("temperature", 0.0);

            JSONArray messages = new JSONArray();
            JSONObject message = new JSONObject();
            message.put("role", "user");
            message.put("content", userInput);
            messages.add(message);

            jsonInput.put("messages", messages);
            jsonInput.put("stream", true);

            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInput.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                boolean chk = false;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                    String res = responseLine.trim().split("content")[1].split("\"")[2];
                    String resReplace = res.replace("\\r", "").replace("\\n", "");
                    if(resReplace.length() != res.length()) {
                        System.out.printf(resReplace);
                        if(!chk) {
                            chk = true;
                            System.out.println();
                        }
                    }else{
                        chk = false;
                        System.out.printf(res);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
