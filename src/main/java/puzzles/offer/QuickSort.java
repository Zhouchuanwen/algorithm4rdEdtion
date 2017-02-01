package puzzles.offer;

/**
 * Created by alan on 17/1/19.
 */
public class QuickSort {

    public static int partition(int[] arr,int low,int high){
        int key=arr[low];

        while (low<high){

            while (arr[high]>=key && high>low){
                high--;
            }

            arr[low]=arr[high];

            while (arr[low]<=key && high>low){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[high]=key;
        return high;
   }


   public static void sort(int[] arr,int low,int high){
       if(low>=high){
           return;
       }
       int index=partition(arr,low,high);
       sort(arr,low,index);
       sort(arr,index+1,high);
   }

   public static void main(String[] args){
       int test[]={239034,12,21,34,45,56,53,433,90,802,345,6567,782,2,8,45,9,1};

       sort(test,0,test.length-1);

       for(int i=0;i<test.length;i++){
           System.out.println(test[i]+" ");
       }
   }

}
