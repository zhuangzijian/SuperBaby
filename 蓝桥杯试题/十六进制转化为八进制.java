package 蓝桥杯试题;

import java.util.Scanner;

public class 十六进制转化为八进制 {


	public static void main(String[] args) {
	     Scanner sc=new Scanner(System.in);
	     int a=sc.nextInt();
	     String[] m=new String[a+1];
	     for(int i=0;i<a;i++) {
	    	 m[i]=sc.nextLine();
	     }
	     for(int i=0;i<a;i++) {
	    	 String tow=F(m[i]);
	    	 if(tow.length()%3==1) {tow = "00"+tow;};
	    	 if(tow.length()%3==2) {tow = "0"+tow;}
	    	 String one=G(tow);
	    	 System.out.println(one);
	    	 
	     }
	     
	}
	
	public static String G(String tow){
		int k ;
		StringBuffer mb=new StringBuffer();
		 if(tow.substring(0, 3).equals("000")) k=3;else k=0;  
		for(int i=k;i<tow.length()-2;i+=3) {
			String string=tow.substring(i,i+3);
			if(string.equals("000")) {mb.append("0");}else 
				if(string.equals("001")) {mb.append("1");}else 
					if(string.equals("010")) {mb.append("2");}else 
						if(string.equals("011")) {mb.append("3");}else 
							if(string.equals("100")) {mb.append("4");}else
								if(string.equals("101")) {mb.append("5");}else 
									if(string.equals("110")) {mb.append("6");}else
										if(string.equals("111")) {mb.append("7");}
			
		}
		return mb.toString();
		
	}
	public static String F(String m) {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<m.length();i++) {
			switch (m.charAt(i)) {
			case '0':    sb.append("0000");     break;
			case '1':    sb.append("0001");     break;
			case '2':    sb.append("0010");     break;
			case '3':    sb.append("0011");     break;
			case '4':    sb.append("0100");     break;
			case '5':    sb.append("0101");     break;
			case '6':    sb.append("0110");     break;
			case '7':    sb.append("0111");     break;
			case '8':    sb.append("1000");     break;
			case '9':    sb.append("1001");     break;
			case 'A':    sb.append("1010");     break;
			case 'B':    sb.append("1011");     break;
			case 'C':    sb.append("1100");     break;
			case 'D':    sb.append("1101");     break;
			case 'E':    sb.append("1110");     break;
			case 'F':    sb.append("1111");     break;

			default:break;
			}
		}
		
		return sb.toString();
	}
}
