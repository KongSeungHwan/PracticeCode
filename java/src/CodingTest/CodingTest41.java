package CodingTest;

public class CodingTest41 {
    public static void main(String args[]){
        int n = 7;
        int i = 1;
        int count = 0;
        while(i<=n){
            i*=(++count);
        }
        System.out.println(count-1);
    }
}
