package datastructure;

import DataStructureImpl.MaxPQ;
import org.junit.Test;

/**
 * Created by alan on 16/2/5.
 */
public class HeapSort {

    static MaxPQ maxPQ=new MaxPQ(1000);
    static String res = null;

    static {
        for (int i=0;i<1000;i++){
            int a=(int)(Math.random()*100000);
            maxPQ.insert(a);
            res=res+"-"+String.valueOf(a);
        }
    }

    public static void main(String[] args){
        System.out.println("堆无序:"+res);
        System.out.println("堆有序:"+maxPQ.foreach());
        maxPQ.heapsort();
        System.out.println("堆排序: "+maxPQ.foreach());
        System.out.println("maxPQ大小"+maxPQ.size());
    }



    @Test
    public void testDelMax(){
        System.out.println("为空:"+maxPQ.isEmpty());
        System.out.println(maxPQ.foreach());
        System.out.println("删除最大元素；"+maxPQ.delMax());
        System.out.println(maxPQ.foreach());
    }

}
