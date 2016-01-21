package test;

import java.util.Arrays;


/**
 * 比较字节数组和字符串的相互转换。
 * @author WJLUCK
 *
 */
public class Example {
	
	public static void main(String[] args) {
		String data1 = "你好，欢迎登陆！";
		byte[] data2 = data1.getBytes();
		String data3 = new String(data2,0,data2.length);
		
		System.out.println(data1);
		System.out.println(Arrays.toString(data2));
		System.out.println(data3);
		
	}
}
