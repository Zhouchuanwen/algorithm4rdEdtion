package datastructure.ListNode;

import org.junit.Test;

import java.util.*;

/**
 * Created by alan on 17/2/14.
 */
public class Node {


    /**
     * 单链表
     */
    class ListNode{

        Object value;

        ListNode next;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        ListNode(){}

        ListNode(Object value){
            this.value=value;
        }
    }


    //批量设置节点
    public static void batchNext(List<ListNode> listNodes){
        for(int i=0;i<listNodes.size();i++){
            ListNode node1=listNodes.get(i);
            if(i+1<listNodes.size()){
                ListNode node2=listNodes.get(i+1);
                node1.next=node2;
            }else {
                node1.next=null;
            }
        }
    }


    //链表翻转迭代版本
    public ListNode reverseIter(ListNode head){
        ListNode newHead=null;
        while (head!=null){
            //保留下一个节点
            ListNode next=head.next;
            //下一个节点设置为newHead
            head.next=newHead;
            //head变为下一个节点
            newHead=head;
            //下一个节点变为head
            head=next;
        }
        return newHead;
    }

    public ListNode reverse(ListNode head){
        return reverseInt(head,null);
    }

    //链表翻转递归版本
    public ListNode reverseInt(ListNode head,ListNode newHead){
        if(head==null)
            return newHead;

        ListNode next=head.next;
        head.next=newHead;
        return reverseInt(next,head);
    }


    //判断两个链表是否相交



    //两个链表是否有相同元素



    //判断链表元素是否为回文



    //https://leetcode.com/problems/remove-linked-list-elements/?tab=Description
    //删除链表中指定元素
    public ListNode removeElements(ListNode head,Integer val){
        if(head==null) return null;
        head.next=removeElements(head.next,val);
        return head.value==val?head.next:head;
    }




    @Test
    public void test(){
        List<ListNode> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            ListNode node=new ListNode(i);
            list.add(node);
        }
        batchNext(list);
        for (ListNode nodes:list){
            System.out.println("current:"+nodes.value+" next:"+nodes.next);
        }
    }


}
