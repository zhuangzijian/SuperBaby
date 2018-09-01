  package 蓝桥杯试题;

import java.util.Scanner;

public class 查找整数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] m=new int[n];
		for(int i=0;i<m.length;i++) {
			m[i]=sc.nextInt();
		}
		int b=sc.nextInt();
		int a =1;
		int c=0;
		
		for(int i=0;i<m.length;i++) {
			if(m[i]==b) {
				
				System.out.println(a);
				c++;
				break;
			}
			a++;
		}
		if(c==0) {
			System.out.println(-1);
		}
	}
		

}
