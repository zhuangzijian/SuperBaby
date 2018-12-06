package LeetCode;

public class test {
      public void aaa(){
         String s="abcd";
         String[] a=new String[s.length()];
         for(int i=0;i<s.length()-1;i++){
             a[i]= s.substring(i);
         }
     }

    public static void main(String[] args) {
          test aaaa=new test();
            aaaa.aaa();
        System.out.println();
    }
}
