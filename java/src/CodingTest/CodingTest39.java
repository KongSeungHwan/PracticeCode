package CodingTest;

import java.util.Comparator;
import java.util.stream.IntStream;

public class CodingTest39 {
    public static void main(String args[]){
        String myString = "AbCdEFG";
        String pat = "dEF";
        System.out.println(IntStream.rangeClosed(pat.length()-1,myString.length()-1)
                .boxed().map(e->(myString.substring(e-pat.length()+1,e+1)).equals(pat)?myString.substring(0,e+1):"")
                .max(Comparator.comparingInt(String::length))
                .get());

    }
}
