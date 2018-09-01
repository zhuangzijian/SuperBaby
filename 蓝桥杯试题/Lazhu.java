package 蓝桥杯试题;

public class Lazhu {
	/*
	 * 生日蜡烛
	 * 
	 * 某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
	 * 
	 * 现在算起来，他一共吹熄了236根蜡烛。
	 * 
	 * 请问，他从多少岁开始过生日party的？
	 * 
	 * 请填写他开始过生日party的年龄数。 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		// 模仿一到一百岁
		for (int i = 1; i < 100; i++) {
			// n是当年需要吹的蜡烛的数 k是需要吹的总数
			int n = i, k = i;
			boolean f=false;
			while (true) {
				//判断是否能等于236蜡烛
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
