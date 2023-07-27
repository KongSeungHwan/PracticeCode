package CodingTest;

public class CodingTest01 {

	public static void main(String[] args) {
		int answer = 0;
		int i=1,j=13,k=1;
		for(int a=i;a<=j;a++){
			String d=a+"";
            answer+=d.length()-d.replace(k+"","").length();
		}
		System.out.println(answer);
	}

}
