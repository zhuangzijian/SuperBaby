package ���ű�����;

import java.math.BigDecimal;
import java.util.Scanner;

public class �߾��ȼӷ�2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal  aBigDecimal;
		BigDecimal  bBigDecimal;
		BigDecimal  cBigDecimal;
		Scanner sc=new Scanner(System.in);
		aBigDecimal=sc.nextBigDecimal();
		bBigDecimal=sc.nextBigDecimal();
		cBigDecimal=aBigDecimal.add(bBigDecimal);
		System.out.println(cBigDecimal);
	}

}
