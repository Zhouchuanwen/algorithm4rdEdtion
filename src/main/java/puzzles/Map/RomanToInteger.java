package puzzles.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by alan on 17/1/17.
 */
public class RomanToInteger {

    public static void main(String[] args){
        String romanStr = "IVMCA";
        System.out.println(romanToInt(romanStr));
    }


    public static int romanToInt(String roman){
        int result=0;
        int now,temp;

        HashMap<Character,Integer> reflect = new HashMap<>();
        reflect.put('I',1);
        reflect.put('X',10);
        reflect.put('C',100);
        reflect.put('M',1000);
        reflect.put('V',5);
        reflect.put('L',50);
        reflect.put('D',500);

        for (int i=0;i<roman.length();i++){
            char c=roman.charAt(i);
            if(reflect.containsKey(c)){
                now=reflect.get(c);
                if(i==roman.length()-1){
                    result+=reflect.get(c);
                    break;
                }
                temp=roman.charAt(i+1);
                if(now>=temp){
                    result+=reflect.get(c);
                }else {
                    result-=reflect.get(c);
                }
            }else {
                throw new IllegalArgumentException("Found illegal character at "+i);
            }
        }
        return result;
    }


}
