package 蓝桥杯试题;

public class 凑算式 {
	/*
	 * 
	 * 凑算式
	 * 
	 * 
	 * 
	 * （如果显示有问题，可以参见【图1.jpg】）
	 * 
	 * 
	 * 这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
	 * 
	 * 比如： 6+8/3+952/714 就是一种解法， 5+3/1+972/486 是另一种解法。
	 * 
	 * 这个算式一共有多少种解法？
	 * 
	 * 注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
	 * 
	 */
	public static void main(String[] args) {
		//每个数分为一个for
		int n=0;
		double a,b,c=0;
		for(int A=1;A<=9;A++) {
			a=A;
			for(int B=1;B<=9;B++) {
				for(int C=1;C<=9;C++) {
					b=B*1.00/C;//这是关键的容易出错的一步，因为如果b是int类型，会出现5/4=1而不是1.25会导致后面出错  
					for(int D=1;D<=9;D++) {
						for(int E=1;E<=9;E++) {
							for(int F=1;F<=9;F++) {
								for(int G=1;G<=9;G++) {
									for(int H=1;H<=9;H++) {
										for(int I=1;I<=9;I++) {
											c=(D*100+E*10+F)*1.00/(G*100+H*10+I);
											int[] k=new int[10];//用于检验是否重复运用
											k[A]++;k[B]++;k[C]++;k[D]++;k[E]++;k[F]++;k[G]++;k[H]++;k[I]++;
											for(int i=1;i<10;i++) {
												if(k[i]!=1)break;  //判断是否重复
												if(i==9&&a+b+c==10) n++; //判断是否循环完并且是否等于10
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(n);
		
	}
}
