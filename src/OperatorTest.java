package com.mayijinfu.test;

public class OperatorTest {

	public static void main(String[] args){
		OperatorTest test=new OperatorTest();
		//十进制数转2进制数
		System.out.println(test.toBinary(16));
		//2进制数转十进制数  java中的字节码为8位 高位补齐为0000 1000
		System.out.println(Integer.parseInt("1000",2));
		//位异或运算符 ^ 
		//8转为二进制数0000 1000 ；11二进制数0000 1011 从高位开始比较相同为0 不同为1
		//则8^11为0000 0011 所以为3
		System.out.println(test.toBinaryString(8)+";"+test.toBinaryString(11));
		System.out.println("8^11="+test.toBinaryString(8^11));
		//位与运算符& 8&11=（0000 1000）
		System.out.println("8&11="+test.toBinaryString(8&11));
		//位或运算符| 8|11=(0000 1011)
		System.out.println("8|11="+test.toBinaryString(8|11));
		
		//位非运算符 ~ ~8 =(1111 0111)
		System.out.println("~8="+test.toBinaryString(~8));
		
		/**移位运算符**/
		//<<左移运算符  8<<2  1000   0010 0000
		System.out.println("8<<1 is "+test.toBinaryString(8<<1));
		System.out.println("8<<2 is "+test.toBinaryString(8<<2));
		System.out.println("8<<3 is "+test.toBinaryString(8<<3));
		
		//>>右移运算符8>>2 1000 0010
		System.out.println("8>>1 is "+test.toBinaryString(8>>1));
		System.out.println("8>>2 is "+test.toBinaryString(8>>2));
		System.out.println("8>>3 is "+test.toBinaryString(8>>3));
		
		//>>>无符号右移
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
