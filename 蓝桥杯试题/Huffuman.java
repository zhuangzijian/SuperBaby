package ���ű�����;

import java.util.Arrays;
import java.util.Scanner;

public class Huffuman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		//�ж�����ĳ���
		if(a.length==1) {
			System.out.println(a[0]);
		}else  if(a.length==2){
			System.out.println(a[0]+a[1]);
		}
		else {
			int m=0;
		for(int i=0;i<n-2;i++) {
			//�����鳤�ȴ��ڶ�ʱ��������Ȼ�����С�Ľ��м���Ȼ�������ǰ��λ��������ĺ� �������һλ ������M�������мӺ͵����������������� Ȩ
		if(a.length>2) {
			Arrays.sort(a);
		a[0]=a[0]+a[1];
		m+=a[0];
		a[1]=a[a.length-1];
		a=Arrays.copyOf(a, a.length-1);
		}else break;
	}
		Arrays.sort(a);
		m+=a[1]+a[0];
		System.out.println(m);
		}
		
		}

}
