package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Jiayi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int b =sc.nextInt();
    int[] a=new int[b];
    int v=0;
    int[] c=new int[b+1];
    for(int i=0;i<a.length;i++) {
    	a[i]=sc.nextInt();
    }
    a[b-1]+=1;
   for(int i=b-1;i>0;i--) {
	   if(a[i]==10) {
		   a[i]=0;
		   a[i-1]+=1;
	   }
   }
   if(a[0]==10) {
	   c[0]=1;
	   c[1]=0;
	   v++;
	   if(b+1>2) {
	   for(int k=a.length-1;k>=2;k--) {
		  c[k]=a[k];
	   }
	   }
   }
   if(v==0) {
for(int i=0;i<b;i++) {
	System.out.print(a[i]+" ");
}
}else {
	for(int i=0;i<=b;i++) {
		System.out.print(c[i]+" ");
	}
}
	}

}
