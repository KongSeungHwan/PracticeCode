package CodingTest;

public class CodingTest06 {

	public static void main(String[] args) {
		String answer="aAb1B2cC34oOp".replaceAll("^[\\W]$","a");
		System.out.println(answer);
	}

}
