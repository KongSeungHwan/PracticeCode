package CodingTest;

public class CodingTest09 {
    public static void main(String[] args) {
        int i=1;
        int j=13;
        int k=1;
        int answer = 0;
        for(int a=i;a<=j;a++){
            String d=a+"";
            answer+=d.length()-d.replace(k+"","").length();
        }
        System.out.println(answer);
    }
}
