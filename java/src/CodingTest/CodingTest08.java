package CodingTest;

import java.util.Arrays;

public class CodingTest08 {
    public static void main(String[] args) {
        String binomial = "43 + 12";
        int[] term
                = Arrays.stream(binomial
                .replace(" ","")
                .split("[+\\-*/]"))
                .mapToInt(Integer::parseInt)
                .toArray(); // 항 추출
        String op= binomial.replaceAll("[0-9\\s]","");//연산자 추출
        System.out.println(term[0]);
        System.out.println(term[1]);
        System.out.println(op);


    }
}
