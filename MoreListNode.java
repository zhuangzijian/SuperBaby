package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MoreListNode {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length<=0)return null;
        ListNode head=null;
        //比较出最小值一个初始值
        int minval=Integer.MAX_VALUE;
        //记录最大值时i的值
        int mini=0;
        //多指针进行排序
        int left=0;
        int right=lists.length-1;
        int mid=0;
    /*    while (left<=right){
            if (lists[left]==null&&lists[right]==null)continue;
            if (lists[left]!=null&&minval>lists[left].val){
                minval=lists[left].val;
                mini=left;
            }
            if (lists[right]!=null&&minval>lists[right].val){
                minval=lists[right].val;
                mini=right;
            }
            left++;
            right--;
        }*/

    /*    for (int i = 0; i <lists.length ; i++) {
            if (lists[i]==null)continue;
            if (lists[i].val<minval){
                minval=lists[i].val;
                mini=i;
            }
        }*/
        if(minval==Integer.MAX_VALUE){
            return null;
        }else {
            head = lists[mini];
            if ( lists[mini].next==null){
                lists[mini]=null;
            }else {
                lists[mini] = lists[mini].next;
            }
            head.next = mergeKLists(lists);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(3);
         ListNode l12 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;
        l2.next = l21;
         l21.next = l22;
         ListNode[] r={l1,l2};
        MoreListNode a=new MoreListNode();
        a.mergeKLists(r);
    }
}
