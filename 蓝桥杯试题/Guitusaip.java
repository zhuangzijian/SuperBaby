package ���ű�����;

import java.util.Scanner;
/*
 * ����˵����������и��ָ��������Ӻ��ڹ꣬�����о����֣����е����Ӻ��ڹ궼��һ����ͬ���ص㡪��ϲ�����ܡ�
    ���������ϸ������䶼�����ڷ������ڹ�����ӵı�����С���Դ˺ܸ���Ȥ�����Ǿ����о���ͬ���Ӻ��ڹ�����ܡ�
    �����֣�������Ȼ�ܱ��ڹ�죬��������������֪��ë���������������裬���������ڹ�ı����У�һ����һ����������ӷ���
    �Լ�����t�׻����ϣ����Ǿͻ�ͣ������Ϣs�롣���ڲ�ͬ�����ӣ�t��s����ֵ�ǲ�ͬ�ģ��������е��ڹ�ȴ��һ�¡�������
    �����յ����ֹͣ��
����Ȼ����Щ�����൱������ȫ�̹ۿ���ķѴ���ʱ�䣬��С������ֻҪ��ÿ��������ʼ���¼�����Ӻ��ڹ�����ݡ������ӵ��ٶ�v1
����ʾÿ����������v1�ף����ڹ���ٶ�v2���Լ����Ӷ�Ӧ��t��sֵ���Լ������ĳ���l��������Ԥ��������Ľ����
  ����С������������ͨ���ֹ������Ʋ�������Ľ�����������ҵ����㡪���廪��ѧ�����ϵ�ĸ߲����������������
   ����дһ�����򣬶��������һ������������v1��v2��t��s��l��Ԥ��ó������Ľ����
�����ʽ
��������ֻ��һ�У������ÿո���������������v1��v2��t��s��l������(v1,v2<=100;t<=300;s<=10;l<=10000��Ϊv1,v2�Ĺ�����)
�����ʽ
��������������У���һ����������������һ����д��ĸ��T����R����D�����ֱ��ʾ�ڹ��ʤ�����ӻ�ʤ����������ͬʱ�����յ㡣
�����ڶ������һ������������ʾ��ʤ�ߣ�����˫��ͬʱ�������յ����ķѵ�ʱ�䣨��������
��������
10 5 5 2 20
�������
D
4
��������
10 5 5 1 20
�������
R
3
��������
10 5 5 3 20
�������
T
4

 */
public class Guitusaip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int v1=sc.nextInt();//�����ٶ�
		int v2=sc.nextInt();//�ڹ��ٶ�
		int t=sc.nextInt();//������Զ��Ϣ
		int s=sc.nextInt();//ʤ���ߵ�ʱ��
		int l=sc.nextInt();//�ܵ�����
		int l1=0;			//�����ߵĳ���
		int l2=0;			//�ڹ��ߵĳ��� 
		int time=0;         //�ڼ���
		int s1=0;           //������Ϣʣ�µ�ʱ��
		while(true) {//����ʱ������ ÿһ���״̬
			time++;		//����ʱ��
			if(s1>0) {  //�ж������Ƿ���Ϣ
				l2+=v2;
				s1--;
			}else {
				l1+=v1;
				l2+=v2;
				if(l1-l2>=t) {
					s1=s;
				}
			}
			if(l1==l) {//�ж��Ƿ񵽴�
				if(l1==l2) {
					System.out.println("D");
					System.out.println(time);
				}else {
					System.out.println("R");
					System.out.println(time);
				}
				break;
			}
			if(l2==l) {
				if(l1==l2){
					System.out.println("D");
					System.out.println(time);
				}else {
					System.out.println("T");
					System.out.println(time);
				}
				break;
			}
		}
		
	}
	/*private static void run(int time, int v1, int v2, int t, int s, int l, int x1, int x2,int left) {  
	    //�����time���״̬  
	    if(left>0) {  
	        //��time����������Ϣ��x1�����ӣ�x2����  
	        x2 += v2;  
	        //��һ�����ĵ�  
	        left--;  
	    }else {  
	        //��time������û����Ϣ��x1���ӣ�x2����  
	        x1+=v1;  
	        x2+=v2;  
	        //���������Ƿ���Ҫ��Ϣ  
	        if(x1-x2>=t) {  
	            left = s;  
	        }  
	    }  
	      
	    if(x1 == l) {  
	        if(x1 == x2) {  
	            System.out.println("D");  
	        }else {  
	            System.out.println("R");  
	        }  
	        System.out.println(time);  
	        return;  
	    }  
	      
	    if(x2 == l) {  
	        if(x1 == x2) {  
	            System.out.println("D");  
	        }else {  
	            System.out.println("T");  
	        }  
	        System.out.println(time);  
	        return;  
	    }  
	      
	    run(time+1, v1, v2, t, s, l, x1, x2, left);  
	}  */

}
