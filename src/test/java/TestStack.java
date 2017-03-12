import org.junit.Test;
import puzzles.poj.TwoStack;

/**
 * Created by alan on 17/3/12.
 */
public class TestStack {

    @Test
    public void test(){
        TwoStack twoStack=new TwoStack();
        twoStack.enqueue(1);
        twoStack.enqueue(2);
        twoStack.enqueue(3);
        twoStack.enqueue(4);
        twoStack.enqueue(5);

        Integer b= (Integer) twoStack.dequeue(3);
        System.out.println(b);

        Integer a= (Integer) twoStack.dequeue(6);
        System.out.println(a);

        Integer c= (Integer) twoStack.dequeue(5);
        System.out.println(c);
    }

}
