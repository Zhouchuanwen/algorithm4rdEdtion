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
