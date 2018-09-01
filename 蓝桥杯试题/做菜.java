package À¶ÇÅ±­ÊÔÌâ;

import java.util.Scanner;

public class ×ö²Ë {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] a=new int[4];
		int[] b=new int[5];
		for(int i=0;i<4;i++) {
			a[i]=sc.nextInt();
		}
		while(true) {
			if(a[0]>=2&&a[1]>=1&&a[3]>=2) {
				a[0]-=2;
				a[1]-=1;
				a[3]-=2;
				b[0]+=1;
			}else break;
		}
		while(true) {
			if(a[0]>=1&&a[1]>=1&&a[2]>=1&&a[3]>=1) {
				a[0]-=1;
				a[1]-=1;
				a[2]-=1;
				a[3]-=1;
				b[1]+=1;
			}else break;
		}
		while(true) {
			if(a[2]>=2&&a[3]>=1) {
				a[2]-=2;
				a[3]-=1;
				b[2]+=1;
			}else break;
		}
		while(true) {
			if(a[1]>=3) {
				a[1]-=3;
				b[3]+=1;
			}else break;
		}
		while(true) {
			if(a[0]>=1&&a[3]>=1) {
				a[0]-=1;
				a[3]-=1;
				b[4]+=1;
			}else break;
		}
		for(int i=0;i<5;i++) {
			System.out.println(b[i]);
		}
	}

}
