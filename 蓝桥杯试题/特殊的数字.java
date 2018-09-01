package 蓝桥杯试题;

import java.util.Scanner;

public class 特殊的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m=new int[1111111];
		int a=0;
		for(int i=1;i<10;i++) {
			for(int k=0;k<10;k++) {
				for(int j=0;j<10;j++) {
					if(i*100+k*10+j==i*i*i+k*k*k+j*j*j) {
						m[a]=i*100+k*10+j;
						a++;
					}
				}
			}
		}
		
		  for(int i=0;i<=a;i++) {
		    	for(int k=i+1;k<=a;k++) {
		    		int l=0;
		    		if(m[i]>m[k]) {
		    			l=m[i];
		    			m[i]=m[k];
		    			m[k]=l;
		    		}
		    	}
		  }
		for(int i=1;i<=a;i++) {
			System.out.println(m[i]);
		}
	}

}
