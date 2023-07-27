package CodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodingTest05 {
	public static void main(String[] args) {
		final String s = "hello";
		System.out.println(Arrays.stream(s.split("")).map(t->
        ((s.length()-s.replace(t,"").length()==1)?t:""))
        .collect(Collectors.joining()));
	}
}
