package 蓝桥杯试题;

import java.util.Scanner;

public class Juzhenchengfa {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int n=sc.nextInt();
		int[][] m=new int[a][a];
		int[][] f=new int[a][a];//为了保留 结果多次幂时会用到
		//存入到二维数组中去
		for(int i=0;i<a;i++) {
			for(int k=0;k<a;k++) {
				f[i][k]=m[i][k]=sc.nextInt();
			}
		}
		//判断幂的次数当等于零时对角线上的数字 为一
		if(n==0) {
			for(int i=0;i<a;i++) {
				for(int k=0;k<a;k++) {
					if(i==k) {
						System.out.print(1+" ");
					}else {
						System.out.print(0+" ");
					}
				}
				System.out.println();
			}
			//1次幂时原样输出
		}else if(n==1) {
			for(int i=0;i<a;i++) {
				for(int k=0;k<a;k++) {
					System.out.print(m[i][k]+" ");
					}
				System.out.println();
				}
		}else {
			//几次幂几次循环
		for(int i=1;i<n;i++) {
			//保留运算结果不会改变 开始 建立的两个数组
			int[][] tmp = new int[a][a];
			for(int	 k=0;k<a;k++) {
				for(int l=0;l<a;l++) {
					int e=0;//用于累加储存结果
					for(int t=0;t<a;t++) {
						e+=m[k][t]*f[t][l];
					}
					tmp[k][l]=e;//赋值到tmp数组中
				}
			}
			f=tmp;//循环完毕更改保留结果以便于下次幂运算时进行累乘
		}
	//打印结果
		for(int i=0;i<a;i++) {
			for(int k=0;k<a;k++) {
				System.out.print(f[i][k]+" ");
			}
			System.out.println();
		}
		}
	}

}
