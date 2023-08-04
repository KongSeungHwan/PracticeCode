package CodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodingTest10 {
    public static void main(String[] args) {
        String before = "hello";
        String after = "olleh";
        //문자열 역순인지 아닌지 판별하는 로직
        int answer = Arrays.stream(before.split("")).sorted().collect(Collectors.joining()).equals(Arrays.stream(after.split("")).sorted().collect(Collectors.joining()))?1:0;
        System.out.println(answer);
    }
}
