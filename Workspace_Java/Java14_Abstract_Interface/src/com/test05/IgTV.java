package com.test05;

public class IgTV implements TV {

	public IgTV() {
		System.out.println("ig tv 구매");
	}
	
	private int volume;
	
	@Override
	public int volumeUp() {
		
		volume += 1;
		
		return volume;
	}

	@Override
	public int volumeDown() {
		
		volume -= 1;
		
		if (volume < 0) {
			volume = 0;
		}
		
		return volume;
	}

}
