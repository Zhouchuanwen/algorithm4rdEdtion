package puzzles.poj;

import java.util.ArrayList;
import java.util.List;
/**
 * 剑指offer:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *           顺时针打印就是按圈数循环打印，一圈包含两行或者两列，在打印的时候会出现某一圈中只包含一行
 *           要判断从左向右打印和从右向左打印的时候是否会出现重复打印
 *
 * Created by alan on 17/1/18.
 */
public class PrintMatrix {

    public List<Integer> printMartix(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return null;
        }

        ArrayList<Integer> list=new ArrayList<>();
        int rows=matrix.length;
        int cols=matrix[0].length;

        //起点坐标
        int start=0;

        //只要每圈的起点坐标*2小于rows和cols就继续转圈打印
        while(rows>start*2 && cols>start*2){
            printCircle(list,matrix, rows, cols, start);
            start++;
        }

        return list;
    }



    private void printCircle(ArrayList<Integer> list, int[][] matrix, int rows, int cols, int start) {
        // 矩阵的终点坐标
        int endX = rows - start - 1;
        int endY = cols - start - 1;
        // 打印从左到右的一行
        for (int i = start; i <= endY; i++) {
            list.add(matrix[start][i]);
        }
        // 打印从上到下的一列
        if (start < endX) {
            for (int j = start + 1; j <= endX; j++) {
                list.add(matrix[j][endY]);
            }
        }
        // 打印从右向左的一行
        if (start < endY && start < endX) {
            for (int k = endY - 1; k >= start; k--) {
                list.add(matrix[endX][k]);
            }
        }
        // 打印从下到上的一列
        if (start < endY && start < endX - 1) {
            for (int m = endX - 1; m >= start + 1; m--) {
                list.add(matrix[m][start]);
            }
        }
    }


}
