import DataStructureImpl.IndexMinPQ;
import org.junit.Test;

/**
 * Created by alan on 16/12/24.
 */
public class IndexMinPQTest {

    @Test
    public void test(){
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        for (int i : pq) {
            System.out.println(i + " " + strings[i]);
        }

        while (!pq.isEmpty()) {
            pq.delMin();
        }

    }


}
