package gptCodingTest;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GptCodingTest04 {
    public static void main(String args[]){
        String str = "A man, a plan, a canal, Panama";
        String phrase = str.replaceAll("^[\\W]$","").toLowerCase();
        System.out.println(phrase);
    }
    public static boolean isPalindrome(String input){
        String phrase = input.replaceAll("^[\\W]$","");
        return IntStream.rangeClosed(0,input.length()-1).boxed().sorted(Collections.reverseOrder()).map(e->input.split("")[e]).collect(Collectors.joining())==input;
    }
}
