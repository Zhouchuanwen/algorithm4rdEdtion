package puzzles.String;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 *
 * http://javarevisited.blogspot.jp/2014/03/3-ways-to-find-first-non-repeated-character-String-programming-problem.html
 *
 * Created by alan on 17/1/17.
 */
public class NonRepeatCharacter {


    @Test
    public void test(){
        String test="morning";
        System.out.println(printFirstNonRepeat(test));
    }

    private char printFirstNonRepeat(String word) {
        char[] origin=word.toCharArray();

        LinkedHashMap<Character,Integer> table=new LinkedHashMap<>();
        for (Character character:origin){
           table.put(character,table.containsKey(character)?table.get(character)+1:1);
        }

        for (Character c:table.keySet()){
            if (table.get(c)==1)
                return c;
        }
        throw new RuntimeException("Not found char in string.");
    }


}
