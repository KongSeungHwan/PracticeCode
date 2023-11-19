package CodingTest;

public class CodingTest22 {
    public static void main(String[] args) {
        int[][] arr = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
        int n = arr.length;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    //return 0; 부분
                }
            }
        }
    }
}
