package ���ű�����;

import java.util.Scanner;

public class Juzhenchengfa {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int n=sc.nextInt();
		int[][] m=new int[a][a];
		int[][] f=new int[a][a];//Ϊ�˱��� ��������ʱ���õ�
		//���뵽��ά������ȥ
		for(int i=0;i<a;i++) {
			for(int k=0;k<a;k++) {
				f[i][k]=m[i][k]=sc.nextInt();
			}
		}
		//�ж��ݵĴ�����������ʱ�Խ����ϵ����� Ϊһ
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
			//1����ʱԭ�����
		}else if(n==1) {
			for(int i=0;i<a;i++) {
				for(int k=0;k<a;k++) {
					System.out.print(m[i][k]+" ");
					}
				System.out.println();
				}
		}else {
			//�����ݼ���ѭ��
		for(int i=1;i<n;i++) {
			//��������������ı� ��ʼ ��������������
			int[][] tmp = new int[a][a];
			for(int	 k=0;k<a;k++) {
				for(int l=0;l<a;l++) {
					int e=0;//�����ۼӴ�����
					for(int t=0;t<a;t++) {
						e+=m[k][t]*f[t][l];
					}
					tmp[k][l]=e;//��ֵ��tmp������
				}
			}
			f=tmp;//ѭ����ϸ��ı�������Ա����´�������ʱ�����۳�
		}
	//��ӡ���
		for(int i=0;i<a;i++) {
			for(int k=0;k<a;k++) {
				System.out.print(f[i][k]+" ");
			}
			System.out.println();
		}
		}
	}

}
