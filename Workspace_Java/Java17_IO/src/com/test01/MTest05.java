package com.test01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MTest05 {

	public static void main(String[] args) {
		
		File fi = new File("b.txt");
		
		MyOutput(fi);
		MyInput(fi);
	}

	private static void MyInput(File fi) {
		
		// try with resources
		// try (알아서 close()를 해준다.)
		try (FileReader fr = new FileReader(fi)) {
			int ch;
			
			while ((ch = fr.read()) != -1) {
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void MyOutput(File fi) {
		// 기본적인 try는 파일을 열면 직접 닫아줘야한다.
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fi, true);
			fw.write("다시 연습니다.");
			fw.append("abc\n");
		} catch (IOException e) {
			e.printStackTrace();
		// close할꺼면 finally에서 하자
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
