import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 16/11/18.
 */
public class palindromicTest {

    @Test
    public void isPalindromicTest(){
        palindromicSequence palindromic=new palindromicSequence();
        List<Integer> input=new ArrayList<>();
        input.add(11);
        input.add(21);
        input.add(11);
        boolean flag=palindromic.isPalindromic(input);
        System.out.println(flag);
    }
}
