import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 16/11/25.
 */
public class longestPalindrome {

    //https://leetcode.com/problems/longest-palindromic-substring/


    // 花费了额外的空间，效率也接近是O(n^2)，原因在于使用了两次遍历
    public List<String> longest(String s){
        long start=System.nanoTime();
        char[] str=s.toCharArray();
        List<String> results=new ArrayList<>();

        if(isPalindromic(str)||s.length()==1){
            results.add(s);
            return results;
        }


        for(int i=0;i<str.length-1;i++){
            StringBuilder sb=new StringBuilder();
            sb.append(str[i]);
            int j=i+1;
            while (j<=str.length-1){
                if(isPalindromic(sb.append(str[j]).toString().toCharArray()))
                    results.add(sb.toString());
                j++;
            }
        }
        System.out.println("time1:"+(double) (System.nanoTime()-start)/1000000);
        return results;
    }

    public static boolean isPalindromic(char[] c){
        if(c.length==1) return true;
        for(int i=0,j=c.length-1;i<j;i++,j--){
            if(c[i]!=c[j]){
                return false;
            }
        }
        return true;
    }



    //这个很机智的在max上面做范围判断
    public String longestPalindrome(String s) {
        long start=System.nanoTime();
        char[] ca = s.toCharArray();
        int rs = 0, re = 0;
        int max = 0;
        for(int i = 0; i < ca.length; i++) {
            if(isPalindrome(ca, i - max - 1, i)) {
                rs = i - max - 1; re = i;
                max += 2;
            } else if(isPalindrome(ca, i - max, i)) {
                rs = i - max; re = i;
                max += 1;
            }
        }
        System.out.println("time2:"+(double) (System.nanoTime()-start)/1000000);
        return s.substring(rs, re + 1);
    }


    private boolean isPalindrome(char[] ca, int s, int e) {
        if(s < 0) return false;

        while(s < e) {
            if(ca[s++] != ca[e--]) return false;
        }
        return true;
    }

}
