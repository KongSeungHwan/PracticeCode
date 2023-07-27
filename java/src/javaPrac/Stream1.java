package Prac2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Person{
	String name;
	String[] hobby;
	String say;
	Person(String a,String[] b,String c){
		name =a;
		hobby=b;
		say=c;
	}
}

public class Stream1 {

	public static void main(String[] args) {
		String a="이름, 취미, 소개\r\n"
				+ "김프로, 축구:농구:야구, 구기종목 좋아요\r\n"
				+ "정프로, 개발:당구:축구, 개발하는데 뛰긴 싫어\r\n"
				+ "앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아\r\n"
				+ "죠르디, 스포츠댄스:개발, 개발하는 죠르디 좋아\r\n"
				+ "박프로, 골프:야구, 운동이 좋아요\r\n"
				+ "정프로, 개발:축구:농구, 개발도 좋고 운동도 좋아";
		//이름 리스트, 취미 리스트, 소개 리스트로 나누자!
		
		List<Person> list = new ArrayList<>(Arrays.asList(a.split("\r\n")))
				.stream()
				.skip(1)
				.map(s-> new Person(s.split(",")[0],s.split(",")[1].replaceAll(" ","").split(":"),s.split(",")[2].replaceAll(" ","")))
				.collect(Collectors.toList());
				list.stream().forEach(s->System.out.printf("이름:%s      취미:%s      말:%s \n",
				s.name,Arrays.stream(s.hobby).collect(Collectors.joining(" ")),s.say)); //디버깅 잘 되었나 확인!
				
				List<String> nameList = list.stream().map(s->s.name).collect(Collectors.toList());//이름 리스트
				
				System.out.printf("정씨 몇명? %d명!\n",nameList.stream().filter(s->s.startsWith("정")).count());//정씨 몇명? 2명!
				
				List<String> hobbyList=list.stream().map(s->s.hobby).collect(Collectors.toList())
				.stream()
				.flatMap(s->Arrays.stream(s).sorted()).collect(Collectors.toList());//취미 리스트
				
				Map<String,Integer> hobmap = hobbyList.stream().collect(Collectors.toMap(h->h,h->1,(o,n)->++o));//취미 별로 몇명인가 조사! 
				
				Iterator<Entry<String,Integer>> it = hobmap.entrySet().iterator();
				while(it.hasNext()){
					Entry<String,Integer> en = it.next();
					System.out.printf("%s:%s\n",en.getKey(),en.getValue());
				}
				
				List<String> sayList = list.stream().map(s->s.say).collect(Collectors.toList());//하고 싶은 말 리스트

	}

}
