package com.controller;

import java.util.List;
import java.util.Scanner;

import com.biz.MYTestBiz;
import com.dto.MYTestDto;

public class MYController {
	
	private static Scanner sc = new Scanner(System.in);
	
	// view
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("1. 전체출력\n")
		  .append("2. 선택출력\n")
		  .append("3. 추   가\n")
		  .append("4. 수   정\n")
		  .append("5. 삭   제\n")
		  .append("6. 종   료\n")
		  .append("7. input select : ");
		System.out.println(sb);
		int select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		
		int select = 0;
		MYTestBiz biz = new MYTestBiz();
		
		do {
			
			select = getMenu();
			
			switch (select) {
			case 1:
				//전체 출력
				List<MYTestDto> list = biz.selectList();
				
				for (MYTestDto dto : list) {
					System.out.printf("%3d %10s %10s\n", dto.getMno(), dto.getMname(), dto.getNickname());
				}
				
				break;
			case 2:
				// 선택출력	
				System.out.println("번호를 입력 : ");
				int selectNo = sc.nextInt();
				
				MYTestDto one = biz.selectOne(selectNo);
				System.out.printf("%3d %10s %10s\n",one.getMno(), one.getMname(), one.getNickname());
				
				break;
			case 3:
				// 추가
				System.out.println("추가할 번호 : ");
				int insertNo = sc.nextInt();
				System.out.println("추가할 이름 : ");
				String insertName = sc.next();
				System.out.println("추가할 별명 : ");
				String insertNickname = sc.next();
				
				MYTestDto insertDto = new MYTestDto();
				insertDto.setMno(insertNo);
				insertDto.setMname(insertName);
				insertDto.setNickname(insertNickname);
				
				int insertRes = biz.insert(insertDto);
				
				if (insertRes > 0) {
					System.out.println("추가 성공");
				} else {
					System.out.println("추가 실패");
				}
				
				break;
			case 4:
				// 수정
				System.out.println("수정할 번호 : ");
				int updateNo = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 별명 : ");
				String updateNickname = sc.next();
				
				MYTestDto updateDto = new MYTestDto(updateNo, updateName, updateNickname);
				
				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}
				
				break;
			case 5:
				// 삭제
				System.out.println("삭제할 번호 : ");
				int deleteNo = sc.nextInt();
				
				int deleteRes = biz.delete(deleteNo);
				if (deleteRes > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}

				break;
			case 6:
				// 
				System.out.println("프로그램이 종료되었습니다...");
				break;
			}
			
		} while (select != 6);
	}
	
}
