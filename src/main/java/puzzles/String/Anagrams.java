package puzzles.String;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 判断两个词是否互异(组成成分相同,结构不一样)
 *
 * http://javarevisited.blogspot.jp/2013/03/Anagram-how-to-check-if-two-string-are-anagrams-example-tutorial.html
 *
 * Created by alan on 17/1/17.
 */
public class Anagrams {

    private static boolean isAnagrams(String from,String to){
        if(from.length()!=to.length()){
            return false;
        }
        char[] a=from.toCharArray();
        char[] b=to.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }


    @Test
    public void test(){
        String from="Army";
        String to="Mary";
        System.out.println("result:"+isAnagrams(from,to));
    }

}
