package LeetCode;

public class DelectListNode {
/*
首先先判断他一共多长的连表
 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a=new ListNode(0);
        a.next=head;
        ListNode first = head;
        int Zlength=0;
        int NodeLength=0;
        while (true){
            if (first.next!=null){
                first=first.next;
               NodeLength++;

            }else break;
        }
        Zlength=NodeLength-n;
        head=a;
        for (int i = 0; i <=Zlength ; i++) {
         head=head.next;
        }
        if(n==0&&n==1){
            head.next=null;
        }else{
            head.next=head.next.next;
        }
        return a.next;
    }

}
