package aiPrac;

import py4j.GatewayServer;
import py4j.Py4JException;
import py4j.Py4JNetworkException;
import py4j.PythonClientEntryPoint;

public class GptNeoTextGenerator {
    private GatewayServer gatewayServer; // GatewayServer 객체를 멤버 변수로 선언합니다.

    public static void main(String[] args) {
        GptNeoTextGenerator gptNeoTextGenerator = new GptNeoTextGenerator(); // GptNeoTextGenerator 객체 생성
        gptNeoTextGenerator.startServer(); // 서버 시작 메소드 호출
    }

    // 서버 시작 메소드
    public void startServer() {
        try {
            // Java GatewayServer 시작
            gatewayServer = new GatewayServer(this);
            gatewayServer.start();
            System.out.println("Java Gateway Server Started");
        } catch (Py4JNetworkException e) {
            e.printStackTrace();
            System.out.println("Failed to start Java Gateway Server: " + e.getMessage());
        }
    }

    public String getGptResponse(String userInput) {
        try {
            // Python 함수를 호출하여 사용자 입력을 전달하고 답변을 반환
            PythonClientEntryPoint pythonEntryPoint = (PythonClientEntryPoint) gatewayServer.getPythonServerEntryPoint(new Class[] {PythonClientEntryPoint.class});
            Object response = pythonEntryPoint.getPythonClient().call("generateGptResponse", userInput);
            return response.toString();
        } catch (Py4JException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
