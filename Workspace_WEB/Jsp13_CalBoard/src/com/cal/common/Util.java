package com.cal.common;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CalDto;

public class Util {
	
	private String todate;
	
	public String getTodates() {
		return todate;
	}
	
	public void setTodates(String mdate) {
		String temp = mdate.substring(0, 4) + "-"
				+ mdate.substring(4, 6) + "-"
				+ mdate.substring(6, 8) + " "
				+ mdate.substring(8, 10) + ":"
				+ mdate.substring(10) + ":00";
		// 문자열의 yyyy, MM, dd, HH, mm을 찾아서 각 위치에 맞게 값을 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		Timestamp tm = Timestamp.valueOf(temp);
		todate = sdf.format(tm);
		
	}

	// 토요일, 일요일, 평일 색상
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if ((dayOfWeek - 1 + date)%7 == 0) {
			color = "blue";
		} else if ((dayOfWeek - 1 + date)%7 == 1) {
			color = "red";
		} else {
			color = "black";
		}
		return color;
	}
	
	//일정의 한자리수 -> 두자리수 변환
	public static String isTwo(String msg) {
		
		return (msg.length()<2)?"0"+msg : msg;
	}
	// 일정 제목을 긴 경우, 귓부분을 ...으로
	public static String getCalView(int i, List<CalDto> list) {
		String d = isTwo(i+"");
		String res = "";
		for (CalDto dto : list) {
			if (dto.getMdate().substring(6, 8).equals(d)) {
				res += "<p>"
						+ ((dto.getTitle().length() > 6)? dto.getTitle().substring(0, 6) + "..." : dto.getTitle())
						+ "</p>";
			}
		}
		return res;
	}
}