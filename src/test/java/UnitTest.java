import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by alan on 16/2/22.
 */
public class UnitTest {

    @Test
    public void medianTest(){
//        int[] arr1= {1, 2, 3, 6};
//        int[] arr2= {};
//        Median median=new Median();
//        System.out.println(median.findMedianSortedArrays(arr1,arr2));


        HashSet<Integer> s=new HashSet<>();
        s.add(1);
        s.add(1);
        s.add(1);
        s.add(1);
        s.stream().forEach(i->{
            System.out.println(i);
        });
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
        String test1="dabab";String test2="babad";String test3="";String test4="Node";String test5="ab";
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
        String s1=zigZagConversion.convert2("PAYPALISHIRING",3);
        System.out.println(s1);
    }

    @Test
    public void ListNodeTest(){

        /**
         * 测试用例
         */
        MergeTwoSortedList.ListNode[] listNode1=new MergeTwoSortedList.ListNode[10];
        for(int i=0;i<5;i++){
            listNode1[i]=new MergeTwoSortedList.ListNode(i*4);
        }
        listNode1[0].next=listNode1[1];
        listNode1[1].next=listNode1[2];
        listNode1[2].next=listNode1[3];
        listNode1[3].next=listNode1[4];

        MergeTwoSortedList.ListNode[] listNode2=new MergeTwoSortedList.ListNode[10];
        for(int i=0;i<6;i++){
            listNode2[i]=new MergeTwoSortedList.ListNode(i*2);
        }
        listNode2[0].next=listNode2[1];
        listNode2[1].next=listNode2[2];
        listNode2[2].next=listNode2[3];
        listNode2[3].next=listNode2[4];
        listNode2[4].next=listNode2[5];

        MergeTwoSortedList m=new MergeTwoSortedList();
        m.foreach(listNode1[0]);
        m.foreach(listNode2[0]);

        System.out.println("归并排序后:");
        m.foreach(m.mergeTwoLists(listNode1[0],listNode2[0]));

        System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝>");

        MergeTwoSortedList.ListNode[] listNode=new MergeTwoSortedList.ListNode[10];
        for(int i=0;i<10;i++){
            listNode[i]=new MergeTwoSortedList.ListNode(i*4);
        }
        listNode[0].next=listNode[1];
        listNode[1].next=listNode[2];

        listNode[3].next=listNode[4];
        listNode[4].next=listNode[5];

        listNode[6].next=listNode[7];
        listNode[7].next=listNode[8];
        listNode[8].next=listNode[9];

        m.foreach(listNode[3]);
        m.foreach(listNode[6]);
        m.foreach(listNode[0]);

        MergeTwoSortedList.ListNode[] mylistNode=new MergeTwoSortedList.ListNode[3];
        mylistNode[0]=listNode[3];
        mylistNode[1]=listNode[6];
        mylistNode[2]=listNode[0];

        System.out.println("多路递归归并排序后:");
        m.foreach(m.mergekLists(mylistNode));
    }



}
