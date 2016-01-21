package com.UDPdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {

		// 1.创建一个DatagramSocket，指定端口号，是通信链的端头。这个是多线程唯一的邮筒。
		DatagramSocket datagramSocket = new DatagramSocket(8880);
		System.out.println("-----服务器端已经启动-----");
		while (true) {
			ServerThread serverThread = new ServerThread(datagramSocket);
			serverThread.run();
		}
	}
}
