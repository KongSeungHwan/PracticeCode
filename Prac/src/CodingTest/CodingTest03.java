package CodingTest;

public class CodingTest03 {

	public static void main(String[] args) {
		int answer = 0;
		int n=10;
        for(int i=n;i>1;i--){
            if(i%2==0)answer+=i;
        }
       System.out.println(answer);

	}

}
