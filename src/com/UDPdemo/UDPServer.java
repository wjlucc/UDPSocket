package com.UDPdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		
		//1.创建一个DatagramSocket，指定端口号，是通信链的端头。
		DatagramSocket datagramSocket = new DatagramSocket(8880);
		
		//2.创建一个DatagramPacket 数据报，用于接收客户端发送的数据。
		byte[] info = new byte[1024];	//数据报中的数据是保存在字节数组中的。
		DatagramPacket datagramPacket = new DatagramPacket(info, info.length);//将收到的数据存在info数组中。
		
		System.out.println("-----服务器端已经启动-----");
		//3.等待接收客户端发送的数据报文，直到收到报文。
		datagramSocket.receive(datagramPacket);	//此方法在接收到数据之前会一直处于阻塞状态。
		
		//4.读取接收到的消息
		String data = new String(info,0,info.length);
		System.out.println("收到消息："+data);
//		System.out.println("收到消息："+Arrays.toString(info));
	}
}
