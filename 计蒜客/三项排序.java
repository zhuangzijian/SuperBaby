package 计蒜客;

import java.util.Scanner;

public class 三项排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * 将题目的数据分为3 个部分 1.应该为1的部分 A 2.应该为2的部分 B 3.应该为3的部分 C
		 * 
		 * 例1：2 2 1 3 3 3 2 3 1 例2：3 2 1 3 3 3 2 2 1 1.部分A先不管 设x为部分B中3的个数 y为部分C中2的个数
		 * 2.交换max(x,y)次，则部分B中和部分C中的2和3都归位置， 3.用部分A中不是1的数字 即2或3 分别和部分B和部分C交换
		 * 4.设z为部分A中不是1的个数 故最少交换次数为 z+max(x,y)
		 */
		int n = sc.nextInt();
		int[] num = new int[n + 1];
		int[] len = new int[4];
		int exchange1 = 0;
		int exchange2 = 0;
		int exchange3 = 0;
		for (int i = 1; i <= n; i++) {
			num[i] = sc.nextInt();
			len[num[i]]++;
		}
		for (int i = 1; i <= len[1]; i++) {
			if (num[i] != 1) {
				exchange1++;
			}
		}
		for (int i = len[1] + 1; i <= len[1] + len[2]; i++) {
			if (num[i] == 3) {
				exchange2++;
			}
		}
		for (int i = len[1] + len[2] + 1; i <= n; i++) {
			if (num[i] == 2) {
				exchange3++;
			}
		}
		int sum = exchange1 + Math.max(exchange3, exchange2);
		System.out.println(sum);
	}
}
