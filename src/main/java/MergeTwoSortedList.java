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

    //优先队列PriorityQueue解此法比较优雅，但是原题意思是在mergeTwo上发散，我首先想到的就是递归,如果随意用优先队列，那上面也可以这样解啊.
    //优先队列PriorityQueue：适合元素比较多,结果数量比较少的情况.


    //答案有一个机智的分治解法:https://discuss.leetcode.com/topic/3008/a-solution-use-divide-and-conquer-algorithm-in-java
    // 如果参数是List.....,使用subList不断地一分为二递归，然后使用上面的mergeTwo
    // => 我的是最后两个往前逐步合并...
    // 说白了一个是多线程思想，一个是单线程思想，多线程可能快些...但是代价肯定比我高,subList效率也要考虑进去啊!

    public ListNode mergekLists(ListNode[] listNodes) {
        int i=listNodes.length;
        while (i>1){
            listNodes[i-2]=mergeTwoLists(listNodes[i-2],listNodes[i-1]);
            i--;
        }
        return listNodes[0];
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
