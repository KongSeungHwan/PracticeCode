package CodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodingTest13 {
    public static void main(String[] args) {
        int age = 23;
        String answer = String.valueOf(age);
        answer= Arrays.stream(answer.split("")).map(e-> (char)(Integer.parseInt(e)+97)).map(String::valueOf).collect(Collectors.joining(""));
        System.out.println(answer);//아스키코드 활용
    }
    }
