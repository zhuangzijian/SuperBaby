package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Zuidazizhen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	int b=sc.nextInt();
	int[] a=new int[b];
	int[] c=new int[b*(b-1)+1];
	int f=0;
	int max=0;
	for(int i=0;i<b;i++) {
		a[i]=sc.nextInt();
	}
	for(int i=0;i<b-1;i++) {
		int m=a[i];
		for(int k=i+1;k<b;k++) {
			m+=a[k];
			c[f]=m;
			f++;
			
		}
	}
	c[f]=a[b-1];
	for(int i=0;i<=f;i++) {
		if(c[i]>max) {
			max=c[i];
		}
	}
	
   System.out.println(max);	
	}

}
