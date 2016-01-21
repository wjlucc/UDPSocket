package com.UDPdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPClient {

	public static void main(String[] args) throws IOException {

		// 1.���巢�͵�������Ϣ���������ĵ�ַ���˿ںţ����ݡ�
		InetAddress address = InetAddress.getByName("localhost"); // ���ڱ�ʾ�������ĵ�ַ��
		int port = 8880; // ָ���˿ںţ��ͷ���������ͬ��
		byte[] info = "�û�����admin�����룺1234".getBytes(); // �ַ�����Ҫ�ķ��������Խ�һ���ַ���ת�����ֽ����顣

		// 2.����Ҫ���͵���Ϣ�����ݱ� DatagramPacket������Ҫ���͵�������Ϣ����������ѡ�õ��ǰ����ĸ������Ĺ��췽����
		// �����յ��ı���ʱ����Ҫ��ַ�Ͷ˿ڲ��������Ƿ��ͱ�����Ҫ������������
		DatagramPacket datagramPacket = new DatagramPacket(info, info.length, address, port);

		// 3.����DatagramSocket������ʵ�����ݵķ��͡������������ﹹ�췽������Ҫ������ --- �Ǹ���Ͳ������Ҫ������
		DatagramSocket datagramSocket = new DatagramSocket();

		// DatagramSocketӦ��ֻ���൱��һ����Ͳ�����ã�����Ҫָ�����Ǹ�λ�ô��͡�
		// ��DatagramPacket���ż������������Ҫ���͵����������Ϣ��������ַ���˿ںţ����������֡���ַ�����ż�����ġ�

		// 4.��������
		datagramSocket.send(datagramPacket);

		// ���ӽ��շ���������Ϣ

		// 1.�������ڽ��յ���Ͳ DatagramSocket���Ѿ���������
		// 2.�����ȴ����յı���
		byte[] data = new byte[1024];
		DatagramPacket datagramPacket2 = new DatagramPacket(data, data.length);

		// 3.������Ϣ
		datagramSocket.receive(datagramPacket2);

		// 4.�������յ�����Ϣ
		String data2 = new String(data, 0, data.length);
		System.out.println(data2);
	}
}