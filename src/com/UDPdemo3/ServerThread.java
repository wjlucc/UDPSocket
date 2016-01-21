package com.UDPdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ������߳�Ҫ��ʲô���᣿ �ȴ����տͻ��˵��ż����յ��󣬽��д����ٻظ���
 * 
 * @author WJLUCK
 *
 */
public class ServerThread extends Thread {

	// ʼ����Ϊ��Ͳ��ֻ��һ��
	private DatagramSocket datagramSocket = null;

	// �ż�ʵ�壬ÿ�����̶��ᴴ��һ��
	private DatagramPacket datagramPacket = null;
	// ���͹��̵��ż����ݡ�
	private byte[] info = new byte[1024];

	// ÿ�����̻߳�ʹ��ԭ������Ͳ���ż�һ���š�
	public ServerThread(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
		this.datagramPacket = new DatagramPacket(this.info, this.info.length);
	}

	@Override
	public void run() {
		try {

			// ����״̬���ȴ�������Ϣ��
			this.datagramSocket.receive(this.datagramPacket);

			// �����յ�����Ϣ��
			String data = new String(this.info, 0, this.datagramPacket.getLength());
			System.out.println("�ͻ��˷��͵���Ϣ�ǣ�" + data);

			// ������Ӧ��
			// �Ȼ�ÿͻ��˵�ַ���˿ڣ���Ϣ���������֡���ַ�Ͷ˿ڶ��ڱ������棬���ż������С�
			info = "��ӭ��½��".getBytes();
			InetAddress address = this.datagramPacket.getAddress();
			int port = this.datagramPacket.getPort();

			// װ���ż���
			this.datagramPacket = new DatagramPacket(info, info.length, address, port);

			// ���з���
			this.datagramSocket.send(this.datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
