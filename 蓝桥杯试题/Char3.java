package ���ű�����;

import java.util.Scanner;

/*
 * ��д����ʵ�֡�������ʯͷ��������Ϸ���������Ϸ�У�������ͬʱ˵������������ʯͷ���򡰲�����ѹ����һ����Ϊʤ�ߡ������ǣ�������ʤ����ʯͷ������ʯͷ��ʤ������������
 * ��������ʤ����������Ҫ��ѡ��ṹ��ʹ��ö�����ͣ���������Ҳʹ��ö�����ͱ�ʾ��

�������룺����������ΧΪ{0,1,2}���ÿո������0��ʾʯͷ��1��ʾ����2��ʾ���������������ֱ��ʾ��������˵����Ʒ��
������������ǰ��Ӯ�����1���������Ӯ�����-1�������ƽ�֣����0��

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
