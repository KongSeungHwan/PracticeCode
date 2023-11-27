package CodingTest;

public class CodingTest27 {
    public static void main(String[] args) {
        String number = "78720646226947352489";
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }

        int remainder = sum % 9;
        System.out.println(remainder);
    }
}
