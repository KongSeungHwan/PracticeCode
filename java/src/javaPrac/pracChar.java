package Prac;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class pracChar {
	public static void main(String[] args) throws NumberFormatException {
		System.out.println(Stream.generate(()->"a").limit(18).collect(Collectors.toList()));
	}
	
}
