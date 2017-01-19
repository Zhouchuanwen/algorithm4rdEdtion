package puzzles.offer;

import java.util.TreeMap;

/**
 * Created by alan on 17/1/19.
 */
public class halfSearch {


    public static int sort(int[] arr,int a,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            if(a==arr[mid]){
                return mid;
            }else if(a>mid){
                return sort(arr,a,mid+1,high);
            }else {
                return sort(arr,a,low,mid-1);
            }
        }
        return -1;
    }

}
