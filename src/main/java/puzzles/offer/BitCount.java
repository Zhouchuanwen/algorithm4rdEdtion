package puzzles.offer;

import org.junit.Test;

/**
 * Created by alan on 17/2/1.
 */
public class BitCount {

    public static int add(int a,int b){
        if(a>Integer.MAX_VALUE||b>Integer.MAX_VALUE)
            return Integer.MIN_VALUE;

        int ans = a;
        while (b!=0){
            ans=a^b;
            b=(a&b)<<1;
            a=ans;
        }
        return ans;
    }

    @Test
    public void test(){
        int a=add(12,2);
        System.out.println(a);
        System.out.println(add(12<<3,-12));
    }

}
