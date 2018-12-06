package LeetCode;

public class TwoChangeNode {
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return head;
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode left=preHead;
        ListNode mid=head;
        if(head.next==null)//如果只有一个节点，直接返回这个节点
            return head;
        ListNode right=head.next;
        while(mid!=null&&mid.next!=null){
            mid.next=right.next;
            right.next=mid;
            left.next=right;

            left=mid;
            mid=left.next;
            if(mid!=null)
                right=mid.next;
        }
        return preHead.next;
    }

   /* private void changeNode(ListNode nowListNode) {
        if (nowListNode.next==null) return ;
        ListNode term=null;
        ListNode aa=null;
        term=nowListNode;
        aa=nowListNode.next;
        nowListNode.val=aa.val;
        nowListNode.next=aa.next;
        nowListNode.next.val=term.val;
        nowListNode.next.next=term.next;
        changeNode(nowListNode.next);
    }*/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;
        TwoChangeNode a=new TwoChangeNode();
        a.swapPairs(l1);
    }
}
