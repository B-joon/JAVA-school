package com.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestSever {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket(8888);
		System.out.println("서버입니다.");
		
		byte[] buff = new byte[1024];
		
		DatagramPacket reciveP = new DatagramPacket(buff, buff.length);
		
		ds.receive(reciveP);
		
		System.out.println(new String(reciveP.getData()));
		
		ds.close();
		ds.disconnect();
		
	}
	
}
