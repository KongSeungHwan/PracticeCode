package gptCodingTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GptCodingTest03 {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        Arrays.stream(reverseArray(arr)).forEach(System.out::println);
    }
    public static int[] reverseArray(int[] originalArray){

        return IntStream.rangeClosed(0,originalArray.length-1)
                .boxed()
                .mapToInt(e-> originalArray[originalArray.length-1-e])
                .toArray();
    }
}
