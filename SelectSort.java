/*
 * ѡ������
 * ÿһ�ΰ����е�������һ�鲢�ҳ�������С�ķŵ���ǰ��
 * ������û���ظ���
 * ����{9,4,2,6,7,3,10,33,88,1,17}
 */
public class SelectSort {
	int min=0;
	int tap=0;
public void selectSort(int[] arry){
	for(int i=0;i<arry.length;i++){
		 min=arry[i];//ÿһ��Ԫ�ؽ��бȽ� 
		for(int j=i;j<arry.length;j++){//ÿһ����ʣ�µĵ���������Ƚ�
			if(arry[j]<min){  //ÿһ��iԪ����ʣ�µ�Ԫ��һһ�Ա�
				min=arry[j];  //����Сֵ ��ֵ�� min
				tap=arry[i];  
				arry[i]=min;
				arry[j]=tap;  //����Сֵ�뵱ǰiԪ�ؽ��н���
			}
		}
	}
	for(int num:arry){
		System.out.println("  "+num);
	}
}
public static void main(String [] args){
	SelectSort s=new SelectSort();
	s.selectSort(new int[]{9,4,2,6,7,3,10,33,88,1,17});
}
}
