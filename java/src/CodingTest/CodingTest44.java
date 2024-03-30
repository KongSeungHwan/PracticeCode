package CodingTest;

import java.util.Arrays;

public class CodingTest44 {
    public static void main(String args[]){
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 1},{0, 3, 2},{0, 3, 3}};
        int[] copy=Arrays.copyOf(arr,arr.length);
        for(int i= 0;i<queries.length;i++){
            if(i%queries[i][2]==0){
                for (int j=queries[i][0];j<=queries[i][1];j++){
                    copy[j]++;
                }
            }
        }
        Arrays.stream(copy).forEach(System.out::println);
    }
}
