package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Chongfu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int b=sc.nextInt();
		int[] a=new int[b];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		int m =0;
	for(int i=0;i<b-1;i++) {
		if(a[i]!=a[i+1]) {
			m++;
		}
	}
	System.out.println(m+1);
		
	}

}
