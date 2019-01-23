package com.logmei.content.test;

public class OperatorTest {

	public static void main(String[] args){
		OperatorTest test=new OperatorTest();
		System.out.println("int 8 的高位0的个数"+test.numberOfLeadingZero(8));
		System.out.format("int 8 二进制数显示为%s\n",test.getFullOfBinary(8));

		//2进制数转十进制数  java中的字节码为8位 高位补齐为0000 1000
		System.out.format("二进制数1000 ，转十进制数为%d\n",Integer.parseInt("1000",2));
		//位异或运算符 ^
		//8转为二进制数0000 1000 ；11二进制数0000 1011 从高位开始比较相同为0 不同为1
		//则8^11为0000 0011 所以为3
		System.out.format("8的二进制数为：%s;16的二进制数为：%s",test.getFullOfBinary(8),test.getFullOfBinary(11));
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

	/**
	 * 获得完整的显示二进制数
	 * @param num
	 * @return
	 */
	public String getFullOfBinary(int num){
		return stringOfLeadingZero(num)+toBinary(num);
	}
	/**
	 * 求num的二进制数，除2取余数，
	 * 例：8%2=0|8/2=4 ;4%2=0|4/2=2;2%2=0|2/2=1;1%2=1|1/2=0
	 * 结果为1000
	 * @param num
	 * @return
	 */
	public String toBinary(int num){
		String str="";
		int n=1;
		while(num!=0){
			str=num%2+str;
			n++;
			if(n%4==0)str+=" ";
			num=num/2;
		}
		return str;
	}

	/**
	 * 高位连续0的位数
	 * 8：0000 0000 0000 0000 0000 0000 0000 1000
	 * @param num
	 * @return
	 */
	public int numberOfLeadingZero(int num){
      if(num==0)return 32;
      int n=0;
      int mask=0x80000000;
      int j=num&mask;
      while(j==0){
      	n++;
      	num<<=1;
      	j=num&mask;
	  }
      return n;
	}

	/**
	 * 取高位连续的0
	 * @param num
	 * @return
	 */
	public String stringOfLeadingZero(int num){
		if(num==0) return "0000 0000 0000 0000 0000 0000 0000 0000";
		String result="";
		int mask=0x80000000;
		int j=num&mask;
		int n=0;
		while(j==0){
			result+="0";
			n++;
			if(n%4==0)result+=" ";
			num<<=1;
			j=num&mask;
		}
		return result;
	}


	/**
	 * 系统默认方法
	 * @param num
	 * @return
	 */
	public String toBinaryString(int num){
		return num+" binary "+Integer.toBinaryString(num)+";";
	}
}
