package CodingTest;

public class CodingTest25 {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            boolean a = false;
            boolean b = false;

            int result = i % 10;
            if (result == 3 || result == 6 || result == 9) {
                a = true;
            }

            result = i /10;
            if (result == 3 || result == 6 || result == 9) {
                b = true;
            }
            if (a && b == true) { // true값이 두 번 나왔을 때, 짝짝.
                System.out.print("짝짝 ");
            } else if (a || b == true) { // true가 한 번만 나왔을 때, 짝.
                System.out.print("짝 ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
