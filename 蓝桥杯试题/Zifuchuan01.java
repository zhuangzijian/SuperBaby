package ¿∂«≈±≠ ‘Ã‚;

public class Zifuchuan01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
     for(int i=0;i<32;i++) {
    	 int[] a= {0,0,0,0};
    	 int b=i;
    	 for(int m=0;m<4;m++) {
    		 a[m]=b%2;
    		 b=b/2;
    	 }
    	 System.out.println(a[3]+""+a[2]+""+a[1]+""+a[0]);
     }
	}

}
