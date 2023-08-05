package CodingTest;

import java.util.Arrays;

public class CodingTest11 {
    public static void main(String[] args) {
        String alphabet="axbxcxdx";
        String[] answer = Arrays.stream(alphabet.split("x")).filter(e->!e.equals("")).sorted().toArray(String[]::new);
        for (String a:answer
             ) {
            System.out.println(a);

        }
    }
}
