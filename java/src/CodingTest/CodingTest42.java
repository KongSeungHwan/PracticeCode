package CodingTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CodingTest42 {
    public static void main(String args[]){
        //int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {58, 172, 746, 89};
        int flag = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
        System.out.println(flag);

        IntStream.concat(Arrays.stream(arr),IntStream.generate(()->0).limit(
                flag!=arr.length ?((int)Math.pow(2,flag))-arr.length:0
                ))
                .forEach(System.out::println);
    //.toArray();
    }
}
