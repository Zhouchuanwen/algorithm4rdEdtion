import org.junit.Test;
import puzzles.offer.PrintMatrix;

/**
 * Created by alan on 17/1/18.
 */
public class PrintmartixTest {

    @Test
    public void test(){
        PrintMatrix printMatrix=new PrintMatrix();
        int[][] array={{1,2,3,4},{6,7,8,9},{10,11,12,13},{14,15,16,17}};
        printMatrix.printMartix(array).stream().forEach(integer -> {
            System.out.println(integer);
        });
    }
}
