package 蓝桥杯试题;

public class 回文数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     int[] m=new int[10000];
	     int a=0;
	     for(int i=1;i<10;i++) {
	    	 for(int k=0;k<10;k++) {
	    				 m[a]=i*1000+k*100+k*10+i;
	    				 a++;
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


