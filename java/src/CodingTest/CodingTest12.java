package CodingTest;

import java.util.Arrays;

public class CodingTest12 {
    public static void main(String[] args) {
        String my_string = "hi12392";
        int[] answer = Arrays.stream(my_string.split("")).filter(e-> e.matches("\\d")).mapToInt(Integer::parseInt).sorted().toArray();

        for (int el:
             answer) {
            System.out.println(el);
        }
    }
}
