package CodingTest;

import java.util.ArrayList;
import java.util.List;

public class CodingTest23 {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> sequence = new ArrayList<>();
        sequence.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            sequence.add(n);
        }

        int[] answer = new int[sequence.size()];
        for (int i = 0; i < sequence.size(); i++) {
            answer[i] = sequence.get(i);
        }
    }
}
