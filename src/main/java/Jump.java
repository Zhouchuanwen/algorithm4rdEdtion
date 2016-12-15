import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.nowcoder.com/question/next?pid=2811407&qid=46572&tid=6192278
 * Created by alan on 16/12/14.
 *
 */
public class Jump {


    //查找公约数的最佳方法
    public static List<Integer> gcd(int x){
        if(x<=0) return null;
        List<Integer> list=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                list.add(i);
                if(x/i!=i){
                    list.add(x/i);
                }
            }
        }
        return list;
    }


    /**
     * 动态规划思想
     * @param n
     * @param m
     * @return
     */
    public static int timesTojump(int n,int m){
        if (m == n) {
            return 0;
        }
        int steps = m - n + 1;// 算上了起点和终点
        int[] dp = new int[steps];// 规划的量：到达 每个位置需要的最小步数
        dp[0] = 0; // 起点
        for (int i = 1; i < steps; i++) {
            dp[i] = Integer.MAX_VALUE; // 初始化 表示后续位置都不能到达
        }
        for (int i = 0; i < steps; i++) {
            // 0对应n石板 ；steps - 1 = m-n对应m石板
            if (dp[i] == Integer.MAX_VALUE) { // 该位置不能像前走
                dp[i] = 0;
                continue;
            }
            List<Integer> list = gcd(i + n); // i+n才是石板号
            for (int j = 0; j < list.size(); j++) {
                int x = list.get(j);
                if (i + n + x <= m) {
                    dp[i + x] = Math.min(dp[i + x], dp[i] + 1);
                }
            }
        }
        if (dp[steps - 1] == 0) {
            return -1;
        } else {
            return dp[steps - 1];
        }
    }


    public static void main(String[] args){
        System.out.println(timesTojump(4,24));
    }


}
