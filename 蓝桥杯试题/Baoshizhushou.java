package ���ű�����;

import java.util.Scanner;

/*
 * ��������

����������ǰ��ʱ�䣬����Ӣ�ĵĶ���������������
����ʱ����ʱh�ͷ�m��ʾ����Ӣ�ĵĶ����У���һ��ʱ��ķ����ǣ�
�������mΪ0����ʱ��������Ȼ����ϡ�o'clock������3:00������three o'clock����
�������m��Ϊ0����ʱ��������Ȼ�󽫷ֶ���������5:30������five thirty����
����ʱ�ͷֵĶ���ʹ�õ���Ӣ�����ֵĶ���������0~20������
����0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight, 9:nine, 10:ten, 11:eleven, 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen, 19:nineteen, 20:twenty��
����30����thirty��40����forty��50����fifty��
�������ڴ���20С��60�����֣����ȶ���ʮ������Ȼ���ټ��ϸ�λ������31���ȶ�30�ټ�1�Ķ�����������thirty one����
����������Ĺ���21:54������twenty one fifty four����9:07������nine seven����0:15������zero fifteen����
�����ʽ
����������������Ǹ�����h��m����ʾʱ���ʱ�ͷ֡����������ǰû��ǰ��0��hС��24��mС��60��
�����ʽ
�������ʱ��ʱ�̵�Ӣ�ġ�
��������
0 15
�������
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
