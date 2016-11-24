import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alan on 16/11/22.
 */
public class ThreeSum {

    //https://leetcode.com/problems/3sum/


    public List<List<Integer>> mythreeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {
                int b = nums[j], c = nums[k];
                //和大于0 就减小max
                while (j < k && (c = nums[k]) + a + b > 0)
                    k--;

                if (a + b + c == 0)
                    l.add(Arrays.asList(a, b, c));

                //去掉重复下一个的情况
                while (j < nums.length - 2 && nums[j] == nums[j + 1])
                    j++;
            }
            //去掉重复下一个的情况
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }
        return l;
    }
}
