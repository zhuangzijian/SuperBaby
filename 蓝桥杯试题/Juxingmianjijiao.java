package ���ű�����;

import java.util.Scanner;

public class Juxingmianjijiao {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double[] x=new double[4];
		double[] y=new double[4];
		double[] m=new double[4];
		int f=0;
		for(int i=0;i<4;i++) {
			x[i]=sc.nextDouble();
			y[i]=sc.nextDouble();
		}
		m[0]=Math.min(Math.max(x[0], x[1]), Math.max(x[2], x[3]));//�ص���������ϽǵĽ���x
		m[1]=Math.max(Math.min(x[0], x[1]), Math.min(x[2], x[3]));//�ص������ ���½ǵĽ���x
		m[2]=Math.min(Math.max(y[0], y[1]), Math.max(y[2], y[3]));//�ص���������ϽǵĽ��� ��y
		m[3]=Math.max(Math.min(y[0], y[1]), Math.min(y[2], y[3]));//�ص���������½ǵ� ���� ��y
		//�ж��Ƿ� Ϊ����
		if(m[0]-m[1]<0||m[2]-m[3]<0) {
			System.out.println("0.00");
		}else {
			System.out.printf("%.2f\n",(m[0]-m[1])*(m[2]-m[3]));
		}
		
	}

}
