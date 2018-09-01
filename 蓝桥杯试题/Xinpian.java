package 蓝桥杯试题;

import java.util.Scanner;

public class Xinpian {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int [][]a=new int[n][n];
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			a[i][j]=sc.nextInt();//输入进去的二维数组
		}
	}
	for(int i=0;i<n;i++) {
		int c=0;  //存放所有测试芯片是好的的个数
		int d=0;  //存放所有测试芯片是坏的的个数
		for(int j=0;j<n;j++) {
		  if(j!=i&&a[j][i]==1) {//判断这次的芯片测试的好坏
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
