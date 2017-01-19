package puzzles.Dynamic;

/**
 * Created by alan on 17/1/19.
 */
public class MaxSum {


    //连续最大子数组和
    public int findGreatestSumOfSubArray(int[] array){
        if(array==null||array.length==0) return 0;
        int maxSum=array[0];
        int curSum=array[0];

        for(int i=0;i<array.length;i++){
            if(curSum<0)
                curSum=0;
            curSum+=array[i];
            maxSum=Math.max(curSum,maxSum);
        }
        return maxSum;
    }

}
