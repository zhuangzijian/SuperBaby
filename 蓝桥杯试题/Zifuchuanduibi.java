package 蓝桥杯试题;

import java.util.Scanner;

public class Zifuchuanduibi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String a2=sc.nextLine();
		int[] m=new int[10]; //通途存字符的acs码；
		int[] m2=new int[10];
		int b=0;
		//判断字符串长度是否相等
		if(a.length()!=a2.length()) {
			System.out.println("1");
		}else {
		//对字符串进行切割
		for(int i=0;i<a.length();i++) {
			m[i]=a.charAt(i);
			m2[i]=a2.charAt(i);
		}
		int[] k=new int[10];
		//对比字符串
		for(int i=0;i<a.length();i++) {
			if(m[i]==m2[i]) {
				k[i]=2;
			}
			if(m[i]+32==m2[i]||m[i]==m2[i]+32) {
				k[i]=3;
			}
			if(m[i]!=m2[i]&&m[i]+32!=m2[i]&&m[i]!=m2[i]+32) {
				b=4;
				System.out.println("4");
				break;
			}
		}
		if(k.length!=a.length()&&b==0) {
			int o=0;
			for(int i=0;i<a.length();i++) {
				if(k[i]==3) {
					o=1;
				}
				
			}
			if(o==1) {
				System.out.println("3");
			}else {
				System.out.println("2");
			}
		
		}
		}
	}

}
