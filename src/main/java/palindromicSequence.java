import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alan on 16/11/18.
 */
public class palindromicSequence {


    //http://www.nowcoder.com/test/question/0147cbd790724bc9ae0b779aaf7c5b50?pid=2811407&tid=6014751

    public static void main(String[] args){
        Scanner in =new Scanner(System.in);

        int num=in.nextInt();
        List<Integer> sequence=new ArrayList<>();

        for(int i=0;i<num;i++){
            sequence.add(in.nextInt());
        }

        int times=transferTimes(sequence);
        System.out.println(times);
    }


    static int times=0;
    public static int transferTimes(List<Integer> sequence){
        if(isPalindromic(sequence)) return times;
        //操作：要求最少操作次数，那么当首数小于尾数时，应当对首数进行操作；当首数大于尾数时，应当对尾数进行操作；当相等的时候，首++，尾--，进行循环。
        for(int i=0,j=sequence.size()-1;i<j;i++,j--){
            if(sequence.get(i)<sequence.get(j)){
                int sum=sequence.get(i)+sequence.get(i+1);
                sequence.set(i+1,sum);
                sequence.remove(i);
                break;
            }else if(sequence.get(i)>sequence.get(j)){
                int sum=sequence.get(j)+sequence.get(j-1);
                sequence.set(j-1,sum);
                sequence.remove(j);
                break;
            }else{
                continue;
            }
        }
        times++;
        return transferTimes(sequence);
    }

    public static boolean isPalindromic(List<Integer> sequence){
        if(sequence.size()==1) return true;
        for(int i=0,j=sequence.size()-1;i<j;i++,j--){
            if(sequence.get(i)!=sequence.get(j)){
                return false;
            }
        }
        return true;
    }

}
