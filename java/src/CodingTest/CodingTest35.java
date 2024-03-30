package CodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CodingTest35 {
    public static void main(String args[]) {
        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};
        List<Integer> X = new ArrayList<>();

        IntStream.range(0, flag.length)
                .forEach(i -> {
                    if (flag[i]) {
                        int value = arr[i];
                        IntStream.range(0, value * 2)
                                .forEach(j -> X.add(value));
                    } else {
                        int count = arr[i];
                        int size = X.size();
                        IntStream.range(0, count)
                                .forEach(j -> X.remove(size - 1 - j));
                    }
                });
        X.forEach(System.out::println);

    }
}
