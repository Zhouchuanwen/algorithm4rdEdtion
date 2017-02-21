import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alan on 17/2/21.
 */
public class AllOne {

    private Bucket head;

    private Bucket tail;

    private Map<Integer, Bucket> countBucketMap;

    private Map<Integer, Bucket> keyCountMap;

    private class Bucket{
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket prev;
        public Bucket(int cnt){
            count=cnt;
            keySet=new HashSet<>();
        }
    }

    /** Initialize your data structure here. */
    public AllOne(){


    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return "";
    }

}
