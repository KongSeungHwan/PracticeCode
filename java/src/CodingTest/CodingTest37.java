package CodingTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CodingTest37 {
    public static void main(String args[]) {
        int[] num_list ={1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 3;
        int[][] newArr = IntStream.rangeClosed(0, (num_list.length / n) - 1)
                .mapToObj(e -> Arrays.copyOfRange(num_list, n * e, n * (e + 1)))
                .toArray(int[][]::new);

        Arrays.stream(newArr).forEach(e -> {
            Arrays.stream(e).forEach(f -> System.out.printf("%d ", f));
            System.out.println();
        });

    }
}
