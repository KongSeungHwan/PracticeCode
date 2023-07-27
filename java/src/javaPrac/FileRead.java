package Prac;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("src/Prac/dir/file.txt"));){
			for(int i;(i=br.read())!=-1;)System.out.print((char)i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
