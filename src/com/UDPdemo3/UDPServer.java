package com.UDPdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {

		// 1.����һ��DatagramSocket��ָ���˿ںţ���ͨ�����Ķ�ͷ������Ƕ��߳�Ψһ����Ͳ��
		DatagramSocket datagramSocket = new DatagramSocket(8880);
		System.out.println("-----���������Ѿ�����-----");
		while (true) {
			ServerThread serverThread = new ServerThread(datagramSocket);
			serverThread.run();
		}
	}
}
