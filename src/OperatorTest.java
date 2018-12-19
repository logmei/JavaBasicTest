package com.mayijinfu.test;

public class OperatorTest {

	public static void main(String[] args){
		OperatorTest test=new OperatorTest();
		//ʮ������ת2������
		System.out.println(test.toBinary(16));
		//2������תʮ������  java�е��ֽ���Ϊ8λ ��λ����Ϊ0000 1000
		System.out.println(Integer.parseInt("1000",2));
		//λ�������� ^ 
		//8תΪ��������0000 1000 ��11��������0000 1011 �Ӹ�λ��ʼ�Ƚ���ͬΪ0 ��ͬΪ1
		//��8^11Ϊ0000 0011 ����Ϊ3
		System.out.println(test.toBinaryString(8)+";"+test.toBinaryString(11));
		System.out.println("8^11="+test.toBinaryString(8^11));
		//λ�������& 8&11=��0000 1000��
		System.out.println("8&11="+test.toBinaryString(8&11));
		//λ�������| 8|11=(0000 1011)
		System.out.println("8|11="+test.toBinaryString(8|11));
		
		//λ������� ~ ~8 =(1111 0111)
		System.out.println("~8="+test.toBinaryString(~8));
		
		/**��λ�����**/
		//<<���������  8<<2  1000   0010 0000
		System.out.println("8<<1 is "+test.toBinaryString(8<<1));
		System.out.println("8<<2 is "+test.toBinaryString(8<<2));
		System.out.println("8<<3 is "+test.toBinaryString(8<<3));
		
		//>>���������8>>2 1000 0010
		System.out.println("8>>1 is "+test.toBinaryString(8>>1));
		System.out.println("8>>2 is "+test.toBinaryString(8>>2));
		System.out.println("8>>3 is "+test.toBinaryString(8>>3));
		
		//>>>�޷�������
		System.out.println("(8) is "+test.toBinaryString(8));
		System.out.println("(8)>>>4 is "+test.toBinaryString((8)>>>4));
	}
	public String toBinary(int num){
		String str="";
		while(num!=0){
			str=num%2+str;
			num=num/2;
		}
		return str;
	}
	
	
	public String toBinaryString(int num){
		return num+" binary "+Integer.toBinaryString(num)+";";
	}
}
