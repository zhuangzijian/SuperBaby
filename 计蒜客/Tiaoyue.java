package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Tiaoyue {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);	
			int m=input.nextInt();
			int[] a=new int[m];
			for(int i=0;i<a.length;i++) {
				a[i]=input.nextInt();
			}
			int n=0;
			int h=0;
			while(true) {
				h=a[n];
				n=n+h;
				if(h==0) {
					System.out.println("false");
					break;
				}
				if(n>a.length-1) {
					System.out.println("false");
					break;
				}
				if(n==a.length-1) {
					System.out.println("true");
					break;
				}
			}
}
}
