package CodingTest;

import java.util.Arrays;

public class CodingTest04 {
public static void main(String[] args) {
	int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	double average= Arrays.stream(numbers).average().getAsDouble();
	System.out.println(average);
}
}
