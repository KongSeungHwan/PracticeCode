package CodingTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CodingTest45 {
    public static void main(String args[]){
        System.out.println(solution(100));
        System.out.println(solution(-100));
        //스트림 연산 쓰지 않고 뒤집기
    }
    public static int solution(int n){
        int numReverse = 0;
        boolean isMinus = false;

        if(n<0){
            isMinus = true;
            n*=-1;
        }

        while(n>0){
            int r = n % 10;
            n/=10;
            numReverse = numReverse * 10 + r;
        }
        return (isMinus)? numReverse * -1 : numReverse;
    }
}
