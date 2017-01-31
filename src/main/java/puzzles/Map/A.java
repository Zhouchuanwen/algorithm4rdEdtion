package puzzles.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by alan on 17/1/17.
 */
public class A {

    @Test
    public void test(){
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new LinkedHashMap<>();

        map1.put("1",1);
        map1.put("2",1);
        map1.put("3",1);
        map1.put("3",1);
        map1.put("4",1);
        map1.put("5",1);
        map1.put("6",1);


        map2.put("22",1);
        map2.put("11",1);
        map2.put("13",1);

        map1.forEach((i,j)->{
            System.out.println(i+":"+j);
        });

        map2.forEach((i,j)->{
            System.out.println(i+":"+j);
        });
    }
}
