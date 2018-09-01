package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     
	            Scanner scanner = new Scanner(System.in);  
	            int n = scanner.nextInt();  
	            String[] sts = new String[n+1];  
	            for(int i=0;i<n;i++){  
	                sts[i] = scanner.next();  
	            }  
	            scanner.close();  
	            for(int i=0;i<n;i++){  
	                String strBinary = toBinary(sts[i]);  
	                int len_strBin = strBinary.length();  
	                if(len_strBin%3==1) strBinary = "00" + strBinary;  
	                if(len_strBin%3==2) strBinary = "0" + strBinary;  
	                String strOctal = toOctal(strBinary);  
	                System.out.println(strOctal);  
	            }  
	      
	        }  
	      
	        private static String toOctal(String strBinary) {  
	            int len = strBinary.length();  
	            int k;  
	            StringBuffer stb = new StringBuffer();  
	            if(strBinary.substring(0, 3).equals("000")) k=3;  
	            else k=0;  
	            for(int i=k;i<len-2;i+=3){  
	                String string = strBinary.substring(i,i+3);  
	                if(string.equals("000")) stb.append("0");  
	                else if(string.equals("001")) stb.append("1");  
	                else if(string.equals("010")) stb.append("2");  
	                else if(string.equals("011")) stb.append("3");  
	                else if(string.equals("100")) stb.append("4");  
	                else if(string.equals("101")) stb.append("5");  
	                else if(string.equals("110")) stb.append("6");  
	                else if(string.equals("111")) stb.append("7");  
	                /*switch (Integer.valueOf(strBinary.substring(i, i+3))) { 
	                case 000: stb.append("0"); break; 
	                case 001: stb.append("1"); break; 
	                case 010: stb.append("2"); break; 
	                case 011: stb.append("3"); break; 
	                case 100: stb.append("4"); break; 
	                case 101: stb.append("5"); break; 
	                case 110: stb.append("6"); break; 
	                case 111: stb.append("7"); break; 
	     
	                default: 
	                    break; 
	                }*/  
	            }  
	              
	              
	            return stb.toString();  
	        }  
	      
	        private static String toBinary(String strHex) {  
	            int len_str = strHex.length();  
	            StringBuffer stb = new StringBuffer();  
	            for(int i=0;i<len_str;i++){  
	                switch (strHex.charAt(i)) {  
	                case '0': stb.append("0000"); break;  
	                case '1': stb.append("0001"); break;  
	                case '2': stb.append("0010");break;  
	                case '3': stb.append("0011"); break;  
	                case '4': stb.append("0100"); break;  
	                case '5': stb.append("0101"); break;  
	                case '6': stb.append("0110"); break;  
	                case '7': stb.append("0111"); break;  
	                case '8': stb.append("1000"); break;  
	                case '9': stb.append("1001"); break;  
	                case 'A': stb.append("1010"); break;  
	                case 'B': stb.append("1011"); break;  
	                case 'C': stb.append("1100"); break;  
	                case 'D': stb.append("1101"); break;  
	                case 'E': stb.append("1110"); break;  
	                case 'F': stb.append("1111"); break;  
	                default: break;  
	                }  
	            }  
	              
	            return stb.toString();  
	        }  
	    }  


