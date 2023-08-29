package CodingTest;

import java.util.stream.IntStream;

public class CodingTest19 {

    public static void main(String[] args) {
        int n[] = {2,4,7,3,7,5,4};
        IntStream.rangeClosed(0,n.length-1).map(e->n[e]).forEach(System.out::println);
    }
}
