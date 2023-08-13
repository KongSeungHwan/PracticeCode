package CodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodingTest17 {
    public static void main(String[] args) {
        String myString = "abstract algebra";
        String answer = Arrays.stream(myString.split(""))
                .map(e-> e.equals("a")? e.toUpperCase():(e.matches("^[B-Z]$"))? e.toLowerCase():e)
                .collect(Collectors.joining());
        System.out.println(answer);////
    }
}
