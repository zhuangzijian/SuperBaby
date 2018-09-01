package 蓝桥杯试题;

import java.util.Scanner;

public class 高阶精度计算 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

				// TODO Auto-generated method stub
		      Scanner sc=new Scanner(System.in);
		      int n=sc.nextInt();
		      int[] m=new int[10000];
		           m[0]=1;
		       
		      for(int i=1;i<=n;i++){
		    	    int a=0;
		    	    int c=0;
		    	  while(a<10000){
		    		  m[a]=m[a]*i;
		    		  a++;
		    		 
		    	  }
		    	  while(c<10000){
		    		  if(m[c]>10){
		      			m[c+1]+=m[c]/10;
		      			m[c]=m[c]%10;
		      		  }
		    		  c++;
		    	  }
		    	  
		      }
		      for(int i=9999;i>=0;i--){
		    	  
		    	 if(m[i]!=0) {
		    		 int f=i; 
		    	      for(int k=f;k>=0;k--) {
				    	  System.out.print(m[k]);
				      }
		    	      break;
		    	 }
		      }
			
			}

	}


