package 蓝桥杯试题;

import java.util.Scanner;

/*
 * 编写程序实现“剪刀，石头，布”游戏。在这个游戏中，两个人同时说“剪刀”，“石头”或“布”，压过另一方的为胜者。规则是：“布”胜过“石头”，“石头”胜过“剪刀”，
 * “剪刀”胜过“布”。要求：选择结构中使用枚举类型，结果的输出也使用枚举类型表示。

　　输入：两个数，范围为{0,1,2}，用空格隔开。0表示石头，1表示布，2表示剪刀。这两个数分别表示两个人所说的物品。
　　输出：如果前者赢，输出1。如果后者赢，输出-1。如果是平局，输出0。

 */
public class Char3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			int a =sc.nextInt();
			int b =sc.nextInt();
			switch (a-b) {
			case 0:System.out.println(0);
				
				break;
			case -1:System.out.println(-1);
				break;
			case -2:System.out.println(1);
			 	break;
			case 1:System.out.println(1);
				break;
			case 2:System.out.println(-1);
				break;
			default:
				break;
			}
	}

}
