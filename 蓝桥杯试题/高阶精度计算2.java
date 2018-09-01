package 蓝桥杯试题;

import java.math.BigDecimal;
import java.util.Scanner;

public class 高阶精度计算2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal  aB=new BigDecimal(1);
		BigDecimal  cBigDecimal = null;
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		for(int i=1;i<=m;i++) {
			BigDecimal  bB=new BigDecimal(i);
			cBigDecimal =cBigDecimal.multiply(bB) ;
		}
		  
		System.out.println(cBigDecimal);
	}

}
