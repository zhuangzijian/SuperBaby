package LeetCode;

public class TowNode {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode firstNode = listNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        while (l1 != null) {
            listNode.next = l1;
            l1 = l1.next;
            listNode = listNode.next;
        }
        while (l2 != null) {
            listNode.next = l2;
            l2 = l2.next;
            listNode = listNode.next;
        }
        return firstNode.next;
    }
/*
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;

 */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        ListNode l11 = new ListNode(3);
       // ListNode l12 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(7);
        ListNode l22 = new ListNode(4);
       l1.next = l11;
       // l11.next = l12;
        l2.next = l21;
       // l21.next = l22;
        TowNode a = new TowNode();
       ListNode r= a.mergeTwoLists(l1, l2);
        while (r.next!=null){
            System.out.print(r.val);
            r=r.next;
        }
        System.out.println(r.val);
    }
}
