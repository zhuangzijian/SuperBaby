package 计蒜客;

import java.util.Scanner;

public class 计和合 {
	public static String F(String n) {
		String a = "";
		int m = 0;
		for (int i = 0; i < n.length(); i = i + m) {
			m = 1;
			for (int j = i + 1; j < n.length(); j++) {
				if (n.charAt(i) == n.charAt(j)) {
					m++;
				} else
					break;
			}
			String s = String.valueOf(m);
				char p = n.charAt(i);
				for(int f=0;f<s.length();f++) {
					char c=s.charAt(f);
					a+=c;
				}
				a +=p;
			

		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String l = "1";
		for (int i = 1; i < k; i++) {
			l = F(l);

		}
		String h=l;
		System.out.println(h);

	}

}
