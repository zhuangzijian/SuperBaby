package 蓝桥杯试题;

import java.util.Scanner;

public class 特殊回文字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc=new  Scanner(System.in);
     int[] m=new int[10000];
     int a=0;
     int n=sc.nextInt();
     for(int i=0;i<10;i++) {
    	 for(int k=0;k<10;k++) {
    		 for(int j=1;j<10;j++) {
    			 if(n==2*(i+k+j)) {
    				m[a]=j*100000+k*10000+i*1000+i*100+k*10+j;
    				a++;
    			 }
    			 if(n==i+2*(j+k)) {
    				 m[a]=j*10000+k*1000+i*100+k*10+j;
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
