package Prac2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//수업시간때 냈던 문제들 백업(답 x)
public class StreamR {

	public static void main(String[] args) {
		StreamR run = new StreamR();
		System.out.println(run.question1());
		System.out.println(run.question2());
		System.out.println(run.question3());
		run.question4().stream().forEach(s-> Arrays.stream(s).forEach(p->System.out.printf("%d ",p)));
		
	}
	private static final String[] STRARR= {"Pie","pi","P","cake"};
	//두 개의 주사위를 구려서 나온 눈의 합이 6인 경우를 모두 출력
		public List<Integer[]> question4() {
			return IntStream.rangeClosed(1,6)
					.boxed()
					.flatMap(s-> IntStream.rangeClosed(1, 6)
							.boxed()
							.map(p-> new Integer[] {s,p}))
					.filter(s->s[0]+s[1]==6)
					.collect(Collectors.toList());
		}
		//int->Integer 기본형->래퍼클래스 .boxed()
		//임의의 로또 번호(1-45)(6자리,중복불가)를 정렬하여 출력
		public String question3() {
			
			return new Random().ints(1,45) //Integer 값이라 연산x 고로boxed 붙여줘야함
					.boxed()
					.limit(6)
					.distinct()
					.sorted()
					.map(n-> (n<10)? "0"+n : n+"")
					.collect(Collectors.joining(" "));
		}//추가로 10보다 작은 수는 앞에 0을 붙임
		//문자열 배열의 문자열 중에서 가장 긴 것의 길이를 출력
		public int question2() {
			return Arrays.stream(STRARR)
					.mapToInt(s-> s.length())
					.max().getAsInt();
		}
		//문자열 배열의 모든 문자열의 길이를 더한 결과를 출력
		//.mapToInt(  ) 해당 배열의 내부의 결과값을 Integer타입을 바꾼 스트림으로 반환
		public int question1() {
			return Arrays.stream(STRARR)
					.mapToInt(s-> s.length()).sum();
		}
		}
		

