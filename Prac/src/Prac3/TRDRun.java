package Prac3;

public class TRDRun extends Thread{
	int s;
	public TRDRun(int seq) {
		s=seq;
	}
	
	
	public void run() {
		System.out.println(s+"thread Run!");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			System.out.println(s+"thread End!");
		}
	}

	public static void main(String[] args){
		for (int j = 0; j < 10; j++) {
			TRDRun t = new TRDRun(j);
			t.start();
		}
		System.out.println("main method End!");//그냥 일반메소드 
		//호출보다 훨씬 출력속도가 빠른 것을 알 수 있다.(일부러 딜레이 준것.sleep 메소드)
	}
}