package LeetCode;

public class Tw0_sum_lianbiao {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head= new ListNode(0);//存放加和后的数组
        ListNode l3=head;
        int J =0; //存放进位数
        while (l1!=null||l2!=null) {
            int i =0;  //存放总和
            int x=(l1!=null)?l1.val:0;//判断是否为空
            int y=(l2!=null)?l2.val:0;
            i=x+y;
            int sum =J+i;  //总和
            J=sum/10;
            l3.next= new ListNode(sum%10); //从头节点开始 下一个就是第一个节点
            l3=l3.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(J>0){
            l3.next=new ListNode(J);
        }

        return head.next;
    }

    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        ListNode l1new = new ListNode(4);//
        l1.next=l1new;

        ListNode l11new = new ListNode(3);
        l1new.next=l11new;

        ListNode l2=new ListNode(5);
        ListNode l2n = new ListNode(6);//
        l2.next=l2n;

        ListNode l22n = new ListNode(4);
        l2n.next=l22n;

        ListNode l3=null;
        Tw0_sum_lianbiao	a	=new Tw0_sum_lianbiao();
        l3=a.addTwoNumbers(l1, l2);
        while(l3!=null){
            l3 = l3.next;

            System.out.println(l3.val);
        }
    }
}
