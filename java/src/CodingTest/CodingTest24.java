package CodingTest;

public class CodingTest24 {
    public static void main(String[] args) {
        int answer = 0;
        int[] arr = {0, 0, 0, 1};
        int idx = 4;
        for (int i = 0; i < arr.length; i++) {
            if (i >= idx && arr[i] == 1) {
                answer = i;
                break;
            } else {
                answer = -1;
            }
        }
        System.out.println(answer);
    }
}
