package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Shanchongfu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc=new Scanner(System.in);
     int  n=sc.nextInt();
     int[] c=new  int[n];
     int a=0;
     int b=0;
     int m=0;
     for(int  i=0;i<c.length;i++) {
    	 c[i]=sc.nextInt();
     }
     for(int i=0;i<c.length;i=i+m) {
    	  
    	 for(int k=i;k<c.length;k++) {
    		 if(c[i]==c[k]) {
    			 a++;
    		 }
    	 }
    	if(a<1) {
    		m++;
    	}
    	if(a>=1) {
    	  m=m+a;	
    	}
    	if(a>2) {
    		b=b+a-2;
    	}
    	a=0;
    	i=0;
     }
     System.out.println(c.length-b);
	}

}
