package 蓝桥杯试题;

import java.util.Scanner;

/*
 * 问题描述

　　给定当前的时间，请用英文的读法将它读出来。
　　时间用时h和分m表示，在英文的读法中，读一个时间的方法是：
　　如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。
　　如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。
　　时和分的读法使用的是英文数字的读法，其中0~20读作：
　　0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight, 9:nine, 10:ten, 11:eleven, 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen, 19:nineteen, 20:twenty。
　　30读作thirty，40读作forty，50读作fifty。
　　对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“thirty one”。
　　按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero fifteen”。
输入格式
　　输入包含两个非负整数h和m，表示时间的时和分。非零的数字前没有前导0。h小于24，m小于60。
输出格式
　　输出时间时刻的英文。
样例输入
0 15
样例输出
zero fifteen

 */
public class Baoshizhushou {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] i = new int[2];
		i[0] = sc.nextInt();
		i[1] = sc.nextInt();
		String[] s = new String[60];
		s[0] = "zero";
		s[1] = "one";
		s[2] = "tow";
		s[3] = "three";
		s[4] = "four";
		s[5] = "five";
		s[6] = "six";
		s[7] = "seven";
		s[8] = "eight";
		s[9] = "nine";
		s[10] = "ten";
		s[11] = "eleven";
		s[12] = "twelve";
		s[13] = "thirteen";
		s[14] = "fourteen";
		s[15] = "fifteen";
		s[16] = "sixteen";
		s[17] = "seventeen";
		s[18] = "eighteen";
		s[19] = "nineteen";
		s[20] = "twenty";
		s[30] = "thirty";
		s[40] = "forty";
		s[50] = "fifty";
		if (i[1] == 0) {
			if (i[0] <= 20 || i[0] == 30 || i[0] == 40 || i[0] == 50) {
				System.out.println(s[i[0]] + "o'clock");
			} else {
				System.out.println(s[i[0] / 10 * 10] + "" + s[i[0] % 10] + "o'clock");
			}
		}
		if (i[0] <= 20 || i[0] == 30 || i[0] == 40 || i[0] == 50) {
			if (i[1] <= 20 || i[1] == 30 || i[1] == 40 || i[1] == 50) {
				System.out.println(s[i[0]] + " " + s[i[1]]);
			} else {
				System.out.println(s[i[0]] + " " + s[i[1] / 10 * 10] + "" + s[i[1] % 10]);
			}
		} else {
			if (i[1] <= 20 || i[1] == 30 || i[1] == 40 || i[1] == 50) {
				System.out.println(s[i[0] / 10 * 10] + "" + s[i[0] % 10] + " " + s[i[1]]);
			} else {

				System.out.println(s[i[0] / 10 * 10] + "" + s[i[0] % 10] + " " + s[i[1] / 10 * 10] + "" + s[i[1] % 10]);
			}
		}
	}

}
