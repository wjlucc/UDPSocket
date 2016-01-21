package com.UDPdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		
		//1.����һ��DatagramSocket��ָ���˿ںţ���ͨ�����Ķ�ͷ��
		DatagramSocket datagramSocket = new DatagramSocket(8880);
		
		//2.����һ��DatagramPacket ���ݱ������ڽ��տͻ��˷��͵����ݡ�
		byte[] info = new byte[1024];	//���ݱ��е������Ǳ������ֽ������еġ�
		DatagramPacket datagramPacket = new DatagramPacket(info, info.length);//���յ������ݴ���info�����С�
		
		System.out.println("-----���������Ѿ�����-----");
		//3.�ȴ����տͻ��˷��͵����ݱ��ģ�ֱ���յ����ġ�
		datagramSocket.receive(datagramPacket);	//�˷����ڽ��յ�����֮ǰ��һֱ��������״̬��
		
		//4.��ȡ���յ�����Ϣ
		String data = new String(info,0,info.length);
		System.out.println("�յ���Ϣ��"+data);
//		System.out.println("�յ���Ϣ��"+Arrays.toString(info));
	}
}
