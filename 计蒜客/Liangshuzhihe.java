package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Liangshuzhihe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int b=0;
		int a=0;
		int[] number=new int[n];
		for(int i=0;i<n;i++) {
			number[i]=sc.nextInt();
		}
		int terget=sc.nextInt();
		for(int i=0;i<n-1;i++) {
			for(int k=i+1;k<n;k++) {
				if(number[i]+number[k]==terget) {
					a=i+1;
					b=k+1;
					System.out.println(a+" "+b);
				}
			}
		}
		
	}

}
