package CodingTest;

import java.util.Arrays;

public class CodingTest36 {
    public static void main(String args[]) {
        int[] arr ={0, 1, 2, 3, 4};
        int[][] queries = {{0, 3},{1, 2},{1, 4}};
        int[] newArr = Arrays.copyOf(arr,arr.length);
        int temp = 0 ;
        for(int[] t: queries){
            temp = newArr[t[0]];
            newArr[t[0]] = newArr[t[1]];
            newArr[t[1]] = temp;
        }
        Arrays.stream(newArr).forEach(System.out::println);



    }
}
