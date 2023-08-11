package CodingTest;

import java.util.Arrays;

public class CodingTest14 {
    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};
        int[] answer = Arrays.stream(num_list).sorted().skip(5).toArray();
        Arrays.stream(answer).forEach(System.out::println);
    }
}
