package aiPrac;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TensorFlowExample {
    public static void main(String[] args) {
        // 입력 데이터 생성 (정수)
        int inputNumber = 5;

        // TensorFlow 그래프 생성
        try (Graph graph = new Graph()) {
            // 모델 파일 로드
            byte[] model = Files.readAllBytes(Paths.get("./pb/saved_model.pb"));
            graph.importGraphDef(model);

            // TensorFlow 세션 생성
            try (Session session = new Session(graph)) {
                // 입력 데이터를 Tensor로 변환
                try (Tensor<Integer> inputTensor = (Tensor<Integer>) Tensor.create(new int[]{inputNumber})) {
                    // 모델에 입력 데이터 전달하여 예측 수행
                    Tensor<?> outputTensor = session.runner()
                            .feed("input_placeholder_name", inputTensor)
                            .fetch("output_placeholder_name")
                            .run()
                            .get(0);

                    // 예측 결과 출력
                    int[] outputData = new int[1];
                    outputTensor.copyTo(outputData);
                    System.out.println("Squared value: " + outputData[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
