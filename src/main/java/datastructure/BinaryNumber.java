package datastructure;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by alan on 16/11/29.
 */
public class BinaryNumber {

    public Stack<Integer> fetchBinaryNum(int x){
        Stack<Integer> stack=new Stack<>();
        while (x>0){
            stack.push(x%2);
            x=x/2;
        }
        return stack;
    }


    @Test
    public void testFetchBinaryNum(){
        BinaryNumber binaryNumber=new BinaryNumber();
        Stack<Integer> test=binaryNumber.fetchBinaryNum(21212);
        while (test.size()!=0){
            System.out.print(test.pop());
        }
    }

}
