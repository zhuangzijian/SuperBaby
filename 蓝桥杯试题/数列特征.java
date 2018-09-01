package 蓝桥杯试题;

import java.util.Arrays;
import java.util.Scanner;

public class 数列特征 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int[] b=new int[a];
		for(int i=0;i<a;i++) {
			b[i]=sc.nextInt();
		}
		Arrays.sort(b);
		System.out.println(b[a-1]);
		System.out.println(b[0]);
		
		int m=0;
		for(int i=0;i<a;i++) {
			m+=b[i];
		}
		System.out.println(m);
	}
}
