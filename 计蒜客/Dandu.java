package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Dandu {
	public static void main(String[] args) {
	int n=0;
	Scanner sc = new Scanner(System.in);
	int b = sc.nextInt();
	int[] m=new int[b];
	for(int i=0;i<m.length;i++) {
		m[i]=sc.nextInt();
	}
	for(int i=0;i<m.length;i++) {
		   int a = 0;
		for(int k=0;k<m.length;k++) {
			if(m[i]==m[k]) {
				a++;
			}
		}
		if(a==1) {
			n=i;
		}
	}
	System.out.println(m[n]);
}
}
