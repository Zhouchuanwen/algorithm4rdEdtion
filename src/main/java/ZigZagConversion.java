/**
 *
 * https://leetcode.com/problems/zigzag-conversion/
 *
 *
 * Created by alan on 16/12/6.
 */

/*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
*/


/**
 * 分析题目的到锯齿形Zigzag问题:
 *             找规律如上 =>  步长:    offset=2n-2
 */



public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows==1) return s;

        // 步长
        int offset=2*numRows-2;

        StringBuffer result=new StringBuffer();
        for(int i=0;i<numRows;i++){
            for (int j = 0; j*offset + i < s.length(); j ++) {
                //第一行和最后一行
                result.append(s.charAt(j*offset + i));
                //倾斜的下一个数字
                if (i != 0 && i != numRows - 1 && (j+1)*offset - i < s.length())
                    result.append(s.charAt((j+1)*offset - i));
            }
        }
        return result.toString();
    }



    public String convert2(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int magic = numRows * 2 - 2;
        int initialDistance = magic;
        for (int i = 0; i < numRows; i++) {
            fill(sb, i, initialDistance, magic, s);
            initialDistance = initialDistance - 2;
        }
        return sb.toString();
    }

    public void fill(StringBuilder sb, int start, int initialDistance, int magic, String s) {
        while (start < s.length()) {
            //第0行和最后一行的步长是固定的,所以initialDistance＝0，单独考虑.
            if (initialDistance == 0)
                initialDistance = magic;
            //从start开始，步长为initialDistance.
            sb.append(s.charAt(start));
            start = start + initialDistance;
            initialDistance = magic - initialDistance;
        }
    }


}
