package CodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodingTest51 {
    public static void main(String args[]){
        String[] bab =  {"aya", "ye", "woo", "ma"};
        String[] babbling ={"aya", "yee", "u", "maa"};

       /* IntStream.rangeClosed(0,babbling.length-1)
                .mapToObj(e->Arrays.stream(babbling[e].split("aya||ye||woo||ma")).toArray())
                .toList().forEach(q-> System.out.println(Arrays.stream(q).collect(Collectors.joining(" "))));*/


    }
}
