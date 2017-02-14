package datastructure.ListNode;

import org.junit.Test;

import java.util.*;

/**
 * Created by alan on 17/2/14.
 */
public class a {


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
        for(int i=0;i<listNodes.size()-1;i++){
            ListNode node1=listNodes.get(i);
            ListNode node2=listNodes.get(i+1);
            node1.next=node2;
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
        ListNode node=list.get(1);
        System.out.println(node.next.value);
    }


}
