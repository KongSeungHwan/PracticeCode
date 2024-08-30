package CodingTest;

import java.util.stream.IntStream;

public class CodingTest53 {
    public static void main(String args[]){
        String str ="abc1Addfggg4556b";
        int n = 6;
        IntStream.rangeClosed(0,(str.length()/n)).boxed().map(e-> ( ((e+1)*n)<(str.length()) )?str.substring(e*n,(e+1)*n):str.substring(e*n)).toArray(String[]::new);
    }
    public String[] solution(String my_str, int n) {
        return IntStream.rangeClosed(0, my_str.length()/n).boxed()
                .map(i-> ((i+1)*n <my_str.length()) ? my_str.substring(i*n+1,(i+1)*n)
                        : my_str.substring(i*n+1)
                ).toArray(String[]::new);
    }
}
