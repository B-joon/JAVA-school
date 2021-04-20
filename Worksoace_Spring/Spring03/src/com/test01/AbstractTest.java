package com.test01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {
	// 상속 받은 곳에서 반드시 오버라이드 해야한다.
	public abstract String dayInfo();
	
	public static AbstractTest getInstance() {
		
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch (day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		
		return null;
	}
}
