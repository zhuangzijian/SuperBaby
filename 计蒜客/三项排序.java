package �����;

import java.util.Scanner;

public class �������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * ����Ŀ�����ݷ�Ϊ3 ������ 1.Ӧ��Ϊ1�Ĳ��� A 2.Ӧ��Ϊ2�Ĳ��� B 3.Ӧ��Ϊ3�Ĳ��� C
		 * 
		 * ��1��2 2 1 3 3 3 2 3 1 ��2��3 2 1 3 3 3 2 2 1 1.����A�Ȳ��� ��xΪ����B��3�ĸ��� yΪ����C��2�ĸ���
		 * 2.����max(x,y)�Σ��򲿷�B�кͲ���C�е�2��3����λ�ã� 3.�ò���A�в���1������ ��2��3 �ֱ�Ͳ���B�Ͳ���C����
		 * 4.��zΪ����A�в���1�ĸ��� �����ٽ�������Ϊ z+max(x,y)
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
