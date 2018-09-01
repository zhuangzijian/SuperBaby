package 蓝桥杯试题;

import java.util.Scanner;

public class 高精度加法 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a;
		String b;
		int[] k=new int[101];//和   数组
		a=sc.nextLine();//存被加数
		b=sc.nextLine();//存加数
		int[] c=new int[100];
		int[] d=new int[100];
		//倒存被加数并分割到数组中
		for(int i=0;i<a.length();i++) {
			c[a.length()-1-i]=Integer.parseInt(a.substring(i,i+1));
		}
		//倒存加数并分割到数组中
		for(int i=0;i<b.length();i++) {
			d[b.length()-1-i]=Integer.parseInt(b.substring(i,i+1));
		}
		//两数相加
	   for(int i=0;i<100;i++) {
		   k[i]=c[i]+d[i];
	   }
	   //相加进位
	   for(int i=0;i<100;i++) {
		   if(k[i]>=10) {
			   k[i+1]+=k[i]/10;
			   k[i]=k[i]%10;
		   }
	   }
	   int f=0;
	   for(int i=100;i>=0;i--) {
		   if(k[i]>0) {
			   f=i;
			   break;
		   }
		  
	   }
	   for(int t=f;t>=0;t--) {
		   System.out.print(k[t]);
	   }
	}

}
