package CodingTest;

public class CodingTest28 {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4};
        int queries[][] = {{0, 1},{1, 2},{2, 3}};
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            for (int i = start; i <= end; i++) {
                arr[i] += 1;
            }
        }
        System.out.println(arr);
    }
}
