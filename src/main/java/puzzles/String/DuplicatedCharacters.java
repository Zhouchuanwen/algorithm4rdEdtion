package puzzles.String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.java67.com/2014/03/how-to-find-duplicate-characters-in-String-Java-program.html
 *
 * You need to write a program in C, C++, Java or Python to print duplicate characters from a given String, for example if String is "Java" then program should print "a".
 * Bonus points if your program is robust and handle different kinds of input
 * Created by alan on 17/1/17.
 */
public class DuplicatedCharacters {

    public void printDuplicatedCharacters(String origin){
        char[] characters=origin.toCharArray();

        Map<Character,Integer> charMap=new HashMap<>();
        for(Character c:characters){
            if(charMap.containsKey(c)){
                charMap.put(c,charMap.get(c)+1);
            }else{
                charMap.put(c,1);
            }
        }

        charMap.keySet().stream().filter(c -> charMap.get(c) > 1).forEach(c -> {
            System.out.println(c + ":" + charMap.get(c));
        });
    }


    @Test
    public void test(){
        String test="abcdabdrfg";
        printDuplicatedCharacters(test);
        System.out.println();

        String test1="alan";
        printDuplicatedCharacters(test1);
        System.out.println();

        String test2="";
        printDuplicatedCharacters(test2);
        System.out.println();

        String test3="12467364875387894768945680900";
        printDuplicatedCharacters(test3);
    }

}
