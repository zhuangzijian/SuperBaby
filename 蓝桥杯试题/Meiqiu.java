package ���ű�����;

import java.util.Scanner;

public class Meiqiu {
     /*
      * 
ú����Ŀ

��һ��ú�򣬶ѳ�������׶�Ρ����壺
��һ���1����
�ڶ���3�������г������Σ���
������6�������г������Σ���
���Ĳ�10�������г������Σ���
....
���һ����100�㣬���ж��ٸ�ú��

�����ʾú������Ŀ�����֡�
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�

      */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] a=new int[100];
		 a[0]=1;
		for(int i=1;i<100;i++) {
			a[i]+=a[i-1]+i+1;
			
		}
		System.out.println(a[99]);
	
	}

}
