package puzzles.offer;

/**
 * Created by alan on 17/1/19.
 */
public class InsertSort {


    /**
     * 插入排序
     * @param arr
     */
    public static void insert(int arr[]){
        int len=arr.length;
        int target;

        int j;
        for(int i=1;i<len;i++){
            j=i;
            target=arr[i];

            while (j>0 && target<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=target;
        }
    }

}
