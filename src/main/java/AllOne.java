import java.util.HashMap;
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

    private Map<String, Integer> keyCountMap;

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
        head=new Bucket(Integer.MIN_VALUE);
        tail=new Bucket(Integer.MAX_VALUE);
        head.next=tail;
        tail.prev=head;
        countBucketMap=new HashMap<>();
        keyCountMap=new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(countBucketMap.containsKey(key)){
            changeKey(key,1);
        }else {
            keyCountMap.put(key, 1);

            if (head.next.count != 1)
                addBucketAfter(new Bucket(1), head);
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
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


    private void changeKey(String key,int offset){
        int count=keyCountMap.get(key);
        keyCountMap.put(key,count+offset);
        Bucket curBucket=countBucketMap.get(count);
        Bucket newBucket;

        if(countBucketMap.containsKey(count+offset)){
            newBucket=countBucketMap.get(count+offset);
        }else{
            newBucket=new Bucket(count+offset);
            countBucketMap.put(count+offset,newBucket);

        }
    }


    public void addBucketAfter(Bucket newBucket,Bucket preBucket){
        newBucket.prev=preBucket;
        newBucket.next=preBucket.next;


    }























}
