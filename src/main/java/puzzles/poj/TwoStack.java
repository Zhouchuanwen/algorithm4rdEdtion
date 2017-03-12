package puzzles.poj;

import java.util.Stack;

/**
 *
 * use two stacks to implements a queue.
 * Created by alan on 17/3/12.
 */
public class TwoStack {

    private static Stack<Object> justIn=new Stack<>();

    private static Stack<Object> justOut=new Stack<>();

    /**
     * 一个栈负责入栈，一个栈负责出栈, 简单理解版
     */
    public void enqueue(Object in){
        while (!justOut.isEmpty()){
            justIn.push(justOut.pop());
        }
        justIn.push(in);
    }

    public Object dequeue(Object out){
        while(!justIn.isEmpty()){
            justOut.push(justIn.pop());
        }
        while (!justOut.peek().equals(out) && justOut.size()>1){
            justIn.push(justOut.pop());
        }
        if(!justOut.peek().equals(out)){
            return null;
        }
        return justOut.peek();
    }


    /**
     * 另外的思路是: 入栈的时候没有必要清空justIn,每次出栈直接在两个栈中同时寻找出栈元素
     */
}
