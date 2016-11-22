import org.junit.Test;

/**
 * Created by alan on 16/11/22.
 */
public class medianTest {

    @Test
    public void mediantest(){
        int[] arr1= {1, 2, 3, 6};
        int[] arr2= {};

        Median median=new Median();
        System.out.println(median.findMedianSortedArrays(arr1,arr2));

    }

}
