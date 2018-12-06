package LeetCode;

public class Stringdouble {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer juge=new StringBuffer() ;
        StringBuffer jugeResult=new StringBuffer();
        if (strs.length<=0)return "";
        String a=strs[0];
        int m=0;
        for (int i = 0; i <strs.length ; i++) {
           if(strs[i].length()<a.length()){
               a=strs[i];
               m=i;
           }
        }
        for (int i = 0; i <a.length(); i++) {
            juge.append(a.charAt(i));
            if (!juges(m,juge.length(),juge.toString(),strs))break;
            else jugeResult.append(a.substring(i,i+1));
        }

        return jugeResult.toString();
    }
    public boolean juges(int s,int n,String a,String[] b){
        boolean m=true;
        for (int i = 0; i <b.length ; i++) {
            if (i==s)continue;
            if(b[i].substring(0,n).equals(a)){
                m=m&&true;
            }else m=m&&false;
        }
        return m;
    }

    public static void main(String[] args) {
        Stringdouble a=new Stringdouble();
        String[] b= {"flower","flow","flight"};

        System.out.println(a.longestCommonPrefix(b));
    }
}
