package 蓝桥杯试题;

import java.util.Scanner;

public class 日期 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String[] b=new String[3];
		 b=a.split("/");
		 int c=Integer.parseInt(b[0]);
		 int d=Integer.parseInt(b[1]);
		 int f=Integer.parseInt(b[2]);
		if(c>60) {
			
		}
	   if(c>59) {
			
		}
		
	}

}
