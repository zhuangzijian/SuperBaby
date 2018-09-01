package com.pd.word;

public class TestString {
   public static void main(String[] args) {
	String aa="${proName}";
	String[] s=aa.split("\\|");
	for(int i=0;i<s.length;i++){
		System.out.println(removeKH(s[i]));
	}
	byte[] b=new byte[1024];
	testins(b);
}
   public static  String removeKH(String s){
	   s=s.replace("${", "").replace("}", "");
	   return s;
   }
   
   public static void testins(Object o){
	   if(o instanceof byte[]){
		   System.out.println("byte[]");
	   }
   }
}
