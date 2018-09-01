package ���ű�����;

import java.util.Scanner;

public class Huanghou {
     static int n,count=0;
     static int map[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		Put(0,2);                    //�ӵ�һ�п�ʼ���е�һ�з��ð׻ʺ�2��ʾ��3��ʾ��
		System.out.println(count);   //���з���Ѱ����󣬷�������
		
	}
	public static void Put(int t,int s) //���ûʺ�ĺ���
	{
		if(t==n) {
			if(s==2)Put(0,3);
			//����׻ʺ���óɹ�������кڻʺ�ķ���  
            else count++;                  //���÷����е���һ�֣�������������ֵ��һ  
            return ;                       //��ǰ������ù��̽��������г���Ļ���  
        }    
        for(int i=0;i<n;i++)               //��ÿһ�е�ֵ������в���  
        {               
            if(map[t][i]!=1)continue;      //��ǰλ���Ƿ�Ϊ1���ж�  
            if(Check(t,i,s)){map[t][i]=s;} //�Ƿ�������ĿҪ���жϣ����㸳ֵ  
            else continue;                 //�����㣬ͬһ�е���һ��λ��  
            Put(t+1,s);                    //��һ�лʺ�ķ���  
            map[t][i]=1;                   //���ݷ��Ĺؼ�        
        }    
        return ;                           //������Ӧ�Ļ���  
    }    
    public static boolean Check(int t,int i,int s)   //������ĿҪ����жϺ���  
    {    
        for(int q=t-1;q>=0;q--)                      //��ǰλ���Ϸ��Ƿ��������ͬ�ʺ�ķ��� �������µĻ�û�Ų����    
        {    
            if(map[q][i]==s)return false;    
        }           
        for(int q=t-1,w=i-1;q>=0&&w>=0;q--,w--)      //�����Խ��� �������µĻ�û�Ų����    
        {    
            if(map[q][w]==s)return false;    
        }    
        for(int q=t-1,w=i+1;q>=0&&w<=n-1;q--,w++)    //����ҶԽ��� �������µĻ�û�Ų����    
        {    
            if(map[q][w]==s)return false;    
        }    
        return true;                                 //����������£�����Խ��е�ǰ�ʺ�ķ���  
    }    
}    

