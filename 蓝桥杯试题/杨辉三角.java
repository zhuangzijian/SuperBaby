package ���ű�����;

import java.util.Scanner;

public class ������� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int k=0;k<=i;k++) {
				  if(k==0||k==i) {
					  m[i][k]=1;
				  }else {
					  m[i][k]=m[i-1][k-1]+m[i-1][k];
				  }
				  System.out.print(m[i][k]+" ");
			}
			System.out.println();
		}
         
	}

}
