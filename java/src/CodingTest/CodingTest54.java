package CodingTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodingTest54 {

    //각 요소 배열의 평균 순위 먹이기
    //중복 처리 ex) 1,2,3,3,5  1,2,3,3,3,6
    //이런식으로 처리
    public static void main(String[] args) {
        int[] arr = {100, 100, 75, 75, 10, 20, 30, 60};
        int[] ranks = getRanks(arr);
        System.out.println(Arrays.toString(ranks));
    }

    public static int[] getRanks(int[] arr) {
        int n = arr.length;

        // 원래 인덱스를 보존한 채로 값을 정렬하고, 순위를 부여한다.
        Map<Integer, Integer> valueToRank = IntStream.range(0, n)
                .boxed()
                .sorted((i, j) -> Integer.compare(arr[j], arr[i]))
                .collect(Collectors.toMap(
                        i -> arr[i], // 키는 배열의 값
                        i -> 0,     // 초기 값 (모든 값을 0으로 초기화)
                        (a, b) -> a, // 중복 키 병합 시, 기존 값을 유지
                        LinkedHashMap::new // 순서를 유지한 LinkedHashMap 사용
                ));

        // 순위 매기기
        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : valueToRank.entrySet()) {
            entry.setValue(rank);
            rank++;
        }

        // 원래 배열에 대한 순위를 구한다.
        return IntStream.of(arr)
                .map(valueToRank::get)
                .toArray();
    }
}
