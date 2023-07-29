package CodingTest;

import java.util.Arrays;

public class CodingTest08 {
    public static void main(String[] args) {
        String binomial = "43 + 12";
        int answer = 0;
        int[] term
                = Arrays.stream(binomial
                .replace(" ","")
                .split("[+\\-*]"))
                .mapToInt(Integer::parseInt)
                .toArray(); // 항 추출
        String op= binomial.replaceAll("[0-9\\s]","");//연산자 추출
        answer=cal(term[0],term[1],op);
    }
    static int cal(int term1,int term2,String op){
        switch(op){
            case "+": return term1+term2;
            case "-": return term1-term2;
            default: return term1*term2;
        }
    }
}
