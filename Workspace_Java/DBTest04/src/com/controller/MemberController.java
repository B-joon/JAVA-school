package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dao.MemberDaoImpl;
import com.dto.MemberDto;

import oracle.net.aso.l;

public class MemberController {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select = 0;
		System.out.println();
		StringBuffer sb = new StringBuffer();
		sb.append("**********\n")
		  .append("*1.전체출력*\n")
		  .append("*2.선택출력*\n")
		  .append("*3.추   가*\n")
		  .append("*4.수   정*\n")
		  .append("*5.삭   제*\n")
		  .append("*6.종   료*\n")
		  .append("**********\n")
		  .append("input select : \n");
		System.out.println(sb);
		select = sc.nextInt();
		
		return select;
		
	}
	
	public static void main(String[] args) {
		
		int select = 0;
		MemberBiz biz = new MemberBizImpl();
		
		while (select != 6) {
			select = getMenu();
			
			switch (select) {
			case 1:
				// 전체 출력
				List<MemberDto> list = biz.selectList();
				

				for (MemberDto Dto : list) {
					System.out.println(Dto);
				}
				
				break;
			case 2:
				// 선택 출력
				System.out.println("번호를 입력 : ");
				int selectNo = sc.nextInt();
				
				MemberDto selectOneDto = biz.selectOne(selectNo);
				System.out.println(selectOneDto);
				
				break;
			case 3:
				// 추가
				System.out.println("추가할 번호 : ");
				int insertNo = sc.nextInt();
				System.out.println("추가할 이름 : ");
				String insertName = sc.next();
				System.out.println("추가할 나이 : ");
				int insertAge = sc.nextInt();
				System.out.println("추가할 성별 : ");
				String insertGender = sc.next();
				System.out.println("추가할 지역 : ");
				String insertLocation = sc.next();
				System.out.println("추가할 직업 : ");
				String insertJob = sc.next();
				System.out.println("추가할 번호 : ");
				String insertTel = sc.next();
				System.out.println("추가할 이메일 : ");
				String insertEmail = sc.next();
				
				MemberDto insertDto = new MemberDto(insertNo, insertName, insertAge, 
						insertGender, insertLocation, insertJob, insertTel, insertEmail);
				
				int insertRes = biz.insert(insertDto);
				
				if (insertRes > 0) {
					System.out.println("추가 완료");
				} else {
					System.out.println("추가 실패");
				}
				
				break;
			case 4:
				System.out.println("수정할 번호 : ");
				int updateNo = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 나이 : ");
				int updateAge = sc.nextInt();
				System.out.println("수정할 성별 : ");
				String updateGender = sc.next();
				System.out.println("수정할 지역 : ");
				String updateLocation = sc.next();
				System.out.println("수정할 직업 : ");
				String updateJob = sc.next();
				System.out.println("수정할 번호 : ");
				String updateTel = sc.next();
				System.out.println("수정할 이메일 : ");
				String updateEmail = sc.next();
				
				MemberDto updateDto = new MemberDto(updateNo, updateName, updateAge,
						updateGender, updateLocation, updateJob, updateTel, updateEmail);
				
				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}
				
				// 수정
				break;
			case 5:
				// 삭제
				System.out.println("삭제할 번호 : ");
				int deleteNo = sc.nextInt();
				
				int deleteRes = biz.delete(deleteNo);
				if (deleteRes > 0) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 6:
				System.out.println("종료 되었습니다.");
				break;
			}
		}
		
	}
}
