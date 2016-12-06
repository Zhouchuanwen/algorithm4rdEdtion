/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *  这个直接归并排序思想解决就好
 *
 * Created by alan on 16/12/6.
 */
public class MergeTwoSortedList {

    public MergeTwoSortedList(){}

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur=new ListNode(0);
        ListNode prev=cur;

        while (l1!=null && l2!=null){
            if(l1.val>l2.val){
                prev.next=l2;
                l2=l2.next;
            }else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev=prev.next;
        }
        if(l2==null){
            prev.next=l1;
        }else{
            prev.next=l2;
        }
        return cur.next;
    }


    public void foreach(ListNode l){
        System.out.print("ListNode=> ");
        while (l!=null){
            System.out.print(l.val+" ");
            l=l.next;
        }
        System.out.println();
    }


}
