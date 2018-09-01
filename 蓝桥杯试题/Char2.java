package ¿∂«≈±≠ ‘Ã‚;

import java.util.Scanner;

public class Char2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String c = sc.next();
		switch (c) {
		case "+":System.out.println(a+b);

			break;
		case "-":System.out.println(a-b);

			break;
		case "*":System.out.println(a*b);

			break;
		case "/":System.out.println(a/b);

			break;

		default:System.out.println(a%b);
			break;
		}
	}

}
