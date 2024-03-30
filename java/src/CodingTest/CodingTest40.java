package CodingTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodingTest40 {
    public static void main(String args[]){
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String letter =".... . .-.. .-.. ---";
        System.out.println(Arrays.stream(letter.split(" ")).map(e-> List.of(morse).indexOf(e))
                .map(s->String.valueOf((char)(97+s))).collect(Collectors.joining()));
    }
}
