package puzzles.Array;

import puzzles.Map.A;

import java.util.Arrays;

/**
 * Created by alan on 17/1/21.
 */
public class MergeSortedArray {

    public static int[] merge(int[] A,int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int a=A.length-1;
        int b=B.length-1;
        int index=A.length+B.length-1;
        int[] c=new int[index+1];

        while (index>=0){
            if(a>=0 && b>=0){
                if(A[a]>B[b]){
                    c[index]=A[a];
                    a--;
                }else {
                    c[index]=B[b];
                    b--;
                }
            }else if(a>=0){
                c[index]=A[a];
                a--;
            }else if(b>=0){
                c[index]=B[b];
                b--;
            }
            index--;
        }
        return c;
    }

    public static void main(String[] args){
        int A[]={1,2,22,34,55,32,9};
        int B[]={5,4,90,31,89,32,45,12,1000,100};
        int[] a=merge(A,B);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
