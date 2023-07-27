package Prac2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//수업시간때 냈던 문제들 백업(답 x)
public class StreamRun2 {

	public static void main(String[] args) {
		System.out.println(question1());

	}
	private final static List<String> SPELLS=
			Arrays.asList("TOMAS","a","hELLO","b","korea"
					,"x","nutella","apple","banana");

	//list에 저장된 단어에 첫번째 문자가 각각 몇개있는지 
	//Map<String,Integer>로 반환 예)("X",1),("a",1)...
	static Map<String,Integer> question1(){
		return SPELLS.stream()
				.map(s-> s.substring(0,1))
				.collect(Collectors.toMap(s->s,s->1,(o,n) -> ++o));
	}
	
	//list에 저장된 단어들 중에서 단어의 길이가 2이상인 경우에
		//모든 단어를 대문자로 변환하여 구분자를 스페이스로 하는 문자열로 반환
		static String question2(){
			return SPELLS.stream()
					.map(s-> (s.length()>=2)? s.toUpperCase():s)
					.collect(Collectors.joining(" "));
		}
}

