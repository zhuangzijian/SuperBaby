package ¼ÆËâ¿Í;

import java.util.Scanner;

public class Na {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ci=0;
		String[] shuchu=new String[9];
		Scanner input=new Scanner(System.in);
		while(true) {
			int a=input.nextInt();
			if(a==-1) {
				break;
			}
			int max=0;
			int min=0;
			int[] c=new int[a];
			int[] k=new int[a];
			int[] g=new int[a];
			String[] name=new String[a];
			int[] tiji=new int[a];
			for(int i=0;i<a;i++) {
				c[i]=input.nextInt();
				k[i]=input.nextInt();
				g[i]=input.nextInt();
				name[i]=input.next();
				tiji[i]=c[i]*k[i]*g[i];
			}
			int t=0;
			int l=0;
			min=tiji[0];
			for(int i=0;i<a;i++) {
				if(tiji[i]>max) {
					max=tiji[i];
					t=i;
				}
				if(tiji[i]<min) {
					min=tiji[i];
					l=i;
				}
			}
			shuchu[ci]=name[t]+" took clay from "+name[l];
			ci++;
		}
		for(int i=0;i<ci;i++) {
			System.out.println(shuchu[i]);
		}
	}

}

