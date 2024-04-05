package CodingTest;

import java.util.stream.IntStream;

public class CodingTest47 {
    public static void main(String args[]){
       int num_list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
       int slicer[]= {1, 5, 2};
       int answer[];
       int n = 1;
       if(n==1){
           System.out.println(IntStream.rangeClosed(0,slicer[1]-1).boxed().map(e->num_list[e]));
       }else if(n==2){
           System.out.println();
       }else if(n==3){
           System.out.println();
       }else if(n==4){
           System.out.println();
       }else{
           answer=new int[]{};
       }
    }
}
