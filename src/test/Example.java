package test;

import java.util.Arrays;


/**
 * �Ƚ��ֽ�������ַ������໥ת����
 * @author WJLUCK
 *
 */
public class Example {
	
	public static void main(String[] args) {
		String data1 = "��ã���ӭ��½��";
		byte[] data2 = data1.getBytes();
		String data3 = new String(data2,0,data2.length);
		
		System.out.println(data1);
		System.out.println(Arrays.toString(data2));
		System.out.println(data3);
		
	}
}
