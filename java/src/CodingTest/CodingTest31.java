package CodingTest;

public class CodingTest31 {
    public static void main(String[] args) {
        int[] array = {3, 10, 28};
        int n = 20;
        int answer = 0;
        int diff = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            diff = Math.abs(n - array[i]);
            if (diff < min) {
                min = diff;
                answer = array[i];

            } else if (diff == min && array[i] < answer) {
                answer = array[i];
            }
        }

        System.out.println(answer);
    }
}
