package 蓝桥杯试题;

import java.util.Arrays;
import java.util.Scanner;

public class Huffuman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		//判断数组的长度
		if(a.length==1) {
			System.out.println(a[0]);
		}else  if(a.length==2){
			System.out.println(a[0]+a[1]);
		}
		else {
			int m=0;
		for(int i=0;i<n-2;i++) {
			//当数组长度大于二时进行排序然后把最小的进行计算然后把数组前两位换成新算的和 ，和最后一位 ，并用M加入所有加和的数最后算出构成数的 权
		if(a.length>2) {
			Arrays.sort(a);
		a[0]=a[0]+a[1];
		m+=a[0];
		a[1]=a[a.length-1];
		a=Arrays.copyOf(a, a.length-1);
		}else break;
	}
		Arrays.sort(a);
		m+=a[1]+a[0];
		System.out.println(m);
		}
		
		}

}
