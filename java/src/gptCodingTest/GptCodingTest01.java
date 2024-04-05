package gptCodingTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GptCodingTest01 {
    public static void main(String args[]){
        /*FizzBuzz 문제: 1부터 100까지의 숫자 중 3의 배수는 "Fizz", 5의 배수는 "Buzz", 3과 5의 공배수는 "FizzBuzz"를 출력하는 프로그램을 작성하세요.*/
        IntStream.rangeClosed(1,100).forEach(e->{
            if((e%3==0)&&(e%5==0)){
                System.out.println("FizzBuzz");
            } else if (e%5==0) {
                System.out.println("Buzz");
            }else if(e%3==0){
                System.out.println("Fizz");
            }else {
                System.out.println("3 또는 5의 배수가 아닙니다.");
            }
        });
        int rnNumber = new Random().nextInt(100);
        System.out.printf("원본 숫자 %d \n",rnNumber);
        System.out.printf("역순 숫자 %s \n",Arrays.stream(String.valueOf(rnNumber).split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining()));

        List<Integer> list = new Random().ints(10,1,100).boxed().collect(Collectors.toList());
        //1~100 중에 10개 요소로 갖는 list 생성
        System.out.printf(" 리스트 요소: ");
        list.stream().forEach(e-> System.out.printf("%d ",e));
        System.out.println();
        System.out.printf("최댓값: %d \n",list.stream().max(Comparator.naturalOrder()).get());
        //최댓값 가져오기

    }
}
