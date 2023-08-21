package CodingTest;

import java.util.Arrays;

public class CodingTest18 {
    public static void main(String[] args) {
        int n= 1234;
        int answer =  Arrays.stream(String.valueOf(n).split("")).mapToInt(e->Integer.parseInt(e)).sum();
        System.out.println(answer);
    }
}
