package ���ű�����;

import java.util.Scanner;

public class Xinpian {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int [][]a=new int[n][n];
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			a[i][j]=sc.nextInt();//�����ȥ�Ķ�ά����
		}
	}
	for(int i=0;i<n;i++) {
		int c=0;  //������в���оƬ�Ǻõĵĸ���
		int d=0;  //������в���оƬ�ǻ��ĵĸ���
		for(int j=0;j<n;j++) {
		  if(j!=i&&a[j][i]==1) {//�ж���ε�оƬ���Եĺû�
			  c++;
		  }
		  if(a[j][i]==0) {
			  d++;
		  }
		}
		if(c>=d) {
			System.out.print(i+1+" ");
		}
	}
}
}
