package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Hanshudinglu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		int f=0;
		int[] b=new int[] {1,0,0,0,0,0,1,0,2,1};
		int[] m=new int[a.length()];
		for(int i=0;i<a.length();i++) {
            char v=a.charAt(i);
            m[i]=Character.getNumericValue(v);
               f+=b[m[i]];
		}
		System.out.println(f);
	}

}
