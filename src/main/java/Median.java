/**
 * Created by alan on 16/11/22.
 */
public class Median {

    /** url=https://leetcode.com/problems/median-of-two-sorted-arrays/
     * des=num1,2 are sorted.The overall run time complexity should be O(log (m+n)).
     * 难点：log(m+n) 的时间复杂度
     * 中位数定义：当变量值的项数N为奇数时，处于中间位置的变量值即为中位数；当N为偶数时，中位数则为处于中间位置的2个变量值的平均数。
     *  index(L) = (CutPosition-1)/2, index(R) = (CutPosition)/2.
     * @param nums1
     * @param nums2
     * @return
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 > N2) return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = 2 * N1;
        while (lo <= hi) {
            int C1 = (lo + hi) / 2;
            int C2 = N1 + N2 - C1;

            double L1 = (C1 == 0) ? Integer.MIN_VALUE : nums1[(C1-1)/2];
            double R1 = (C1 == 2*N1) ? Integer.MAX_VALUE : nums1[C1/2];
            double L2 = (C2 == 0) ? Integer.MIN_VALUE : nums2[(C2-1)/2];
            double R2 = (C2 == 2*N2) ? Integer.MAX_VALUE : nums2[C2/2];

            if (L1 > R2) hi = C1 - 1;
            else if (L2 > R1) lo = C1 + 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }
}
