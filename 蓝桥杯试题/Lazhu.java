package ���ű�����;

public class Lazhu {
	/*
	 * ��������
	 * 
	 * ĳ����ĳ�꿪ʼÿ�궼�ٰ�һ������party������ÿ�ζ�Ҫ��Ϩ��������ͬ����������
	 * 
	 * ��������������һ����Ϩ��236������
	 * 
	 * ���ʣ����Ӷ����꿪ʼ������party�ģ�
	 * 
	 * ����д����ʼ������party���������� ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		// ģ��һ��һ����
		for (int i = 1; i < 100; i++) {
			// n�ǵ�����Ҫ����������� k����Ҫ��������
			int n = i, k = i;
			boolean f=false;
			while (true) {
				//�ж��Ƿ��ܵ���236����
			    if(k==236) {
			    	System.out.println(i);
			    	f= true;
			    	break;
			    }
			    if(k>236) break;
			    n++;
			    k +=n;
			}
			if(f) {
				break;
			}
		}
	}

}
