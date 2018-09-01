package À¶ÇÅ±­ÊÔÌâ;

import java.util.Scanner;

public class ×ÖÄ¸Í¼ĞÎ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		char[] m=new char[26];
		for(int i=0;i<26;i++) {
			m[i]=(char) (65+i);
		}
		for(int i=0;i<a;i++) {
			int h=0;
			for(int k=0;k<b;k++) {
				if(i-k>0) {
				System.out.print(m[i-k]);
				}else {
					System.out.print(m[h]);
					h++;
				}
			}
			System.out.println();
		}
	}

}
