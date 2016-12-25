package DataStructureImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * 最小堆实现
 * Created by alan on 16/12/24.
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {

    private int maxN;       //队列的最大容量
    private int n;          //元素个数
    private int[] pq;       //二叉堆基于数组下标从1开始
    private int[] qp;       //反转
    private Key[] keys;     //键


    public IndexMinPQ(int maxN){
        if (maxN<0) throw new IllegalArgumentException();
        this.maxN=maxN;
        n=0;
        keys=(Key[]) new Comparable[maxN+1];
        pq=new int[maxN+1];
        qp=new int[maxN+1];
        for(int i=0;i<=maxN;i++)
            qp[i]=-1;
    }

    public boolean isEmpty(){
        return n==0;
    }


    public boolean contains(int i){
        if(i<0||i>=maxN) throw new IllegalArgumentException();
        return qp[i]!=-1;
    }

    public int size() {
        return n;
    }


    public void insert(int i,Key key){
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");

        n++;
        qp[i]=n;
        pq[n]=i;
        keys[i]=key;
        swim(n);
    }

    public int delMin() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        pq[n+1] = -1;        // not needed
        return min;
    }

    public void delete(int i) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }


    public void exch(int i,int j){
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }



    private boolean greater(int i,int j){
        return keys[pq[i]].compareTo(keys[pq[j]])>0;
    }

    private void swim(int k){
        while (k>1 && greater(k/2,k)){
            exch(k,k/2);
            k=k/2;
        }
    }


    private void sink(int k){
        while (2*k<=n){
            int j=2*k;
            if(j<n && greater(j,j+1)) j++;
            if(!greater(k,j)) break;
            exch(k,j);
            k=j;
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {

        private IndexMinPQ<Key> copy;

        public HeapIterator(){
            copy=new IndexMinPQ<Key>(pq.length-1);
            for(int i=1;i<=n;i++){
                copy.insert(pq[i],keys[pq[i]]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }

        @Override
        public void remove() {
            throw  new UnsupportedOperationException();
        }
    }
}
