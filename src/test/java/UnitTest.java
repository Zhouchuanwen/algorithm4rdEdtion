import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 16/11/22.
 */
public class UnitTest {

    @Test
    public void medianTest(){
        int[] arr1= {1, 2, 3, 6};
        int[] arr2= {};
        Median median=new Median();
        System.out.println(median.findMedianSortedArrays(arr1,arr2));

    }



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




    @Test
    public void threeSumTest(){
        int[] sum={-1,0,1,2,-1,-4};
        ThreeSum threeSum=new ThreeSum();
        List<List<Integer>> lists=threeSum.mythreeSum(sum);
        for (int i=0;i<lists.size();i++){
            StringBuilder sb=new StringBuilder("[");
            lists.get(i).stream().forEach(num->{
                sb.append(num+",");
            });
            int start=sb.toString().lastIndexOf(",");
            int end=start+1;
            sb.replace(start,end,"]");
            System.out.println(sb.toString());
        }

    }




    @Test
    public void longestPalindromeTest(){
        longestPalindrome l=new longestPalindrome();
        String test1="dabab";
        String test2="babad";
        String test3="";
        String test4="a";
        String test5="ab";
        String test="abqiwyequwyqwiejnmnnbxzbcnbzxavbcbvaxzjjlzkjckjzxkljczkxasdasdasdasdsaasdasdasasadasasasjzxkjkasidpaosidaosidoaisidapsihsjkdhfjsdgfhgf";

        System.out.println("results:--------");
        l.longest(test).stream().max((o1, o2) -> o1.length()-o2.length()).ifPresent(System.out::println);

        System.out.println("++++++++++++++++++");
        System.out.println(l.longestPalindrome("abqiwyequwyqwiejnmnnbxzbcnbzxavbcbvaxzjjlzkjckjzxkljczkxasdasdasdasdsaasdasdasasadasasasjzxkjkasidpaosidaosidoaisidapsihsjkdhfjsdgfhgf"));

    }



    @Test
    public void reverseTest(){
        reverseInt res=new reverseInt();
        System.out.println(res.reverse(145));
    }



    @Test
    public void zigzagTest(){
        ZigZagConversion zigZagConversion=new ZigZagConversion();
        String s=zigZagConversion.convert("PAYPALISHIRING",3);
        System.out.println(s);
    }





}
