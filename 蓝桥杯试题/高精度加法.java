package ���ű�����;

import java.util.Scanner;

public class �߾��ȼӷ� {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a;
		String b;
		int[] k=new int[101];//��   ����
		a=sc.nextLine();//�汻����
		b=sc.nextLine();//�����
		int[] c=new int[100];
		int[] d=new int[100];
		//���汻�������ָ������
		for(int i=0;i<a.length();i++) {
			c[a.length()-1-i]=Integer.parseInt(a.substring(i,i+1));
		}
		//����������ָ������
		for(int i=0;i<b.length();i++) {
			d[b.length()-1-i]=Integer.parseInt(b.substring(i,i+1));
		}
		//�������
	   for(int i=0;i<100;i++) {
		   k[i]=c[i]+d[i];
	   }
	   //��ӽ�λ
	   for(int i=0;i<100;i++) {
		   if(k[i]>=10) {
			   k[i+1]+=k[i]/10;
			   k[i]=k[i]%10;
		   }
	   }
	   int f=0;
	   for(int i=100;i>=0;i--) {
		   if(k[i]>0) {
			   f=i;
			   break;
		   }
		  
	   }
	   for(int t=f;t>=0;t--) {
		   System.out.print(k[t]);
	   }
	}

}
