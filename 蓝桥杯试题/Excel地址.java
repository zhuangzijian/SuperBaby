package ¿∂«≈±≠ ‘Ã‚;

import java.util.Scanner;

public class Excelµÿ÷∑ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			char[] zz=new char[] {'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
			char[] daan=new char[100];
			int a=sc.nextInt();
			int n=0;
			while(true) {
				if(a<1) {
					break;
				}
				int i=0;
				i=a%26;
				a=a/26;
				daan[n]=zz[i];
				n++;
				if(daan[n-1]=='Z') {
					a=a-1;
				}
			}
			int f=0;
			int s=100;
			while(s>0) {
		if(daan[f]>=65&&daan[f]<=90) {
				f++;
			}
				s--;
			}
			for(int i=f-1;i>=0;i--) {
				System.out.print(daan[i]);
			}
	}

}
