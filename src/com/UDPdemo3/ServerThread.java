package com.UDPdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 这个多线程要干什么事尼？ 等待接收客户端的信件，收到后，进行处理再回复。
 * 
 * @author WJLUCK
 *
 */
public class ServerThread extends Thread {

	// 始终作为邮筒，只有一个
	private DatagramSocket datagramSocket = null;

	// 信件实体，每个进程都会创建一个
	private DatagramPacket datagramPacket = null;
	// 传送过程的信件内容。
	private byte[] info = new byte[1024];

	// 每次新线程会使用原来的邮筒。信件一封信。
	public ServerThread(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
		this.datagramPacket = new DatagramPacket(this.info, this.info.length);
	}

	@Override
	public void run() {
		try {

			// 阻塞状态，等待接收消息。
			this.datagramSocket.receive(this.datagramPacket);

			// 处理收到的消息。
			String data = new String(this.info, 0, this.datagramPacket.getLength());
			System.out.println("客户端发送的消息是：" + data);

			// 进行响应。
			// 先获得客户端地址，端口，信息内容三部分。地址和端口都在报文上面，即信件上面有。
			info = "欢迎登陆！".getBytes();
			InetAddress address = this.datagramPacket.getAddress();
			int port = this.datagramPacket.getPort();

			// 装好信件。
			this.datagramPacket = new DatagramPacket(info, info.length, address, port);

			// 进行发送
			this.datagramSocket.send(this.datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
