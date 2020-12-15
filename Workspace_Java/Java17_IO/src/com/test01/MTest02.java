package com.test01;

import java.io.File;

public class MTest02 {

	public static void main(String[] args) {
		
		File fi = new File("c:\\");
//		prnList01(fi);
		prnList02(fi);
	}
	
	public static void prnList01(File fi) {
		
		for (String list : fi.list()) {
			System.out.println(list);
		}
	}
	
	public static void prnList02(File fi) {
		// 파일과 디렉토리를 구분해서 출력하자.
		// file : swapfile.sys
		// dir : Program Files
		// ...
		// 폴더의 갯수 : 0
		// 폴더의 갯수 : 0
		
//		File[] file = fi.listFiles();
//		
//		int fiCount = 0;
//		int dirCount = 0;
//		
//		for (File files : file) {
//			
//			if (files.isFile()) {
//				System.out.print("file");
//				fiCount++;
//			} else if (files.isDirectory()) {
//				System.out.print("dir ");
//				dirCount++;
//			}
//			System.out.println(" : " + files.getName());
//		}
//		
//		System.out.println("폴더의 갯수 : " + dirCount);
//		System.out.println("파일의 갯수 : " + fiCount);
		
		int fileCount = 0;
		int dirCount = 0;
		
		for (File f : fi.listFiles()) {
			if (f.isDirectory()) {
				System.out.println("dir  : " + f.getName());
				dirCount++;
				
			} else if (f.isFile()) {
				System.out.println("file : " + f.getName());
				fileCount++;
			}
		}
		System.out.println("file의 갯수 : " + fileCount);
		System.out.println("dir 의 갯수 : " + dirCount);
	}
	
}
