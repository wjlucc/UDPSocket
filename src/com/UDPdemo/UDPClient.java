package com.UDPdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPClient {

	public static void main(String[] args) throws IOException {

		// 1.定义发送的数据信息。服务器的地址，端口号，数据。
		InetAddress address = InetAddress.getByName("localhost"); // 用于表示服务器的地址。
		int port = 8880; // 指定端口号，和服务器端相同。
		byte[] info = "用户名：admin；密码：1234".getBytes(); // 字符串重要的方法，可以将一个字符串转换成字节数组。

		// 2.创建要发送的信息的数据报 DatagramPacket，包含要发送的数据信息。。？这里选用的是包含四个参数的构造方法？
		DatagramPacket datagramPacket = new DatagramPacket(info, info.length, address, port);

		// 3.创建DatagramSocket，用来实现数据的发送。。。？？这里构造方法不需要参数？
		DatagramSocket datagramSocket = new DatagramSocket();
		
		//DatagramSocket应该只是相当于一个邮筒的作用，不需要指定向那个位置传送。
		//而DatagramPacket是信件，上面包括了要传送的所有相关信息。包括地址，端口号，数据三部分。地址是在信件上面的。
		
		// 4.发送数据
		datagramSocket.send(datagramPacket);

	}
}
