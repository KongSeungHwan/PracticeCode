package CodingTest;

import java.math.BigInteger;
import java.util.stream.Stream;

public class CodingTest52 {
    public static void main(String[] args) {
        System.out.println(solution(5,3));
        //5개 중 3개 뽑을 확률 맞냐?
    }
    public static BigInteger solution(int balls, int share){
        return factorial(balls).divide(factorial(share).multiply(factorial(balls-share)));
    }
    public static BigInteger factorial(int x){
        return Stream.iterate(BigInteger.ONE, n->n.add(BigInteger.ONE)).limit(x).reduce(BigInteger::multiply).orElse(BigInteger.ONE);
    }
}
