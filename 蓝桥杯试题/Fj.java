package ¿∂«≈±≠ ‘Ã‚;

import java.util.Scanner;

public class Fj {
	static int n;
	static String a[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      String[] a=new String[n];
      a[0]="A";
      for(int i=1;i<n;i++) {
    	  char f=(char) (65+i);
    	  a[i]=a[i-1]+f+a[i-1];
      }
      System.out.println(a[n-1]);
	}

}
