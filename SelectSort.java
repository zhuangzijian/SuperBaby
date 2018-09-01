/*
 * 选择法排序
 * 每一次把所有的数遍历一遍并找出其中最小的放到最前面
 * 数组中没有重复的
 * 遍历{9,4,2,6,7,3,10,33,88,1,17}
 */
public class SelectSort {
	int min=0;
	int tap=0;
public void selectSort(int[] arry){
	for(int i=0;i<arry.length;i++){
		 min=arry[i];//每一个元素进行比较 
		for(int j=i;j<arry.length;j++){//每一个和剩下的的数组遍历比较
			if(arry[j]<min){  //每一个i元素与剩下的元素一一对比
				min=arry[j];  //把最小值 赋值给 min
				tap=arry[i];  
				arry[i]=min;
				arry[j]=tap;  //把最小值与当前i元素进行交换
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
