package Prac;

import java.io.*;

public class CreateFile {

	public static void main(String[] args) {
		try(BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
				){
			System.out.println("생성할 폴더이름:");
			String directory = n.readLine();
			System.out.println("생성할 파일이름:");
			String file = n.readLine()+".txt";//그냥 임의로 함 txt확장자 파일로
			if(!new File("src/"+directory).exists()) new File("src/Prac/"+directory).mkdir();
			if(!new File("src/"+directory+"/"+file).exists()) new File("src/Prac/"+directory+"/"+file).createNewFile();
			BufferedWriter bw= new BufferedWriter(new FileWriter("src/Prac/"+directory+"/"+file));
			System.out.println("파일에 입력할 내용을 입력하시오!");
			String line="";
			while((line=n.readLine())!="") {
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e){
			System.out.println("파일이나 경로를 찾을 수 없습니다.");
		}
		catch(IOException e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
		}//빈 값으로 밖에 못하나 조건..?
	}

}
