package datastructure;

import DataStructureImpl.MaxPQ;

/**
 * Created by alan on 16/12/5.
 */
public class HeapSort {


    public static void main(String[] args){
        MaxPQ maxPQ=new MaxPQ(10);
        for (int i=0;i<10;i++){
            int a=(int)(Math.random()*50);
            maxPQ.insert(a);
        }
        maxPQ.foreach();
        System.out.println(maxPQ.size());
    }

}
