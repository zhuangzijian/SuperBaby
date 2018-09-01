package ¿∂«≈±≠ ‘Ã‚;

import java.util.Scanner;

public class Shijianzhuanhuan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int h=0;
		int m=0;
		int s=0;
		h=t/60/60;
		m=t/60-h*60;
		s=t%60%60;
		System.out.println(h+":"+m+":"+s);
	}

}
