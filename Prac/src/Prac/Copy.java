package Prac;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class Copy {
	//입력 받은 값을 입력하여 txt파일로 생성하기
	public static void main(String[] args) {
		try(BufferedInputStream bi = new BufferedInputStream(new FileInputStream(new File("src/file/Copy/a.txt")));
				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File("src/file/Copy/a.txt")));	
				){
			int i;
			while((i=bi.read())!=-1) bo.write(i);
		} catch (FileNotFoundException e) {
			System.out.println("파일 없다 인마");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("뭐라는겨 다시 해");
			e.printStackTrace();
		}
	}
}
//복사할 시 작성하는 코드
