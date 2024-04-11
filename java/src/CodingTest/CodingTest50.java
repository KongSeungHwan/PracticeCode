package CodingTest;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

public class CodingTest50 {
    Map<String,Integer> map;
    public static void main(String args[]){
       String[] numArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
       String numbers = "onetwothreefourfivesixseveneightnine";
        for(int i = 0; i<numArr.length;i++)numbers=numbers.replace(numArr[i],i+"");
    }
}
