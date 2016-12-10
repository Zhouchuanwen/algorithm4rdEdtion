package DataStructureImpl;



/**
 *
 * 因为之前的二查堆(树)在最坏的情况下(数据本身有序，二叉变为单枝)，遍历需要O(n)<虽然其它情况为O(lgN)>
 * 所以出出现下面的 2-3平衡树 => 由于2-3树在旋转的时候考虑情况太多,代码创建的东西太多反而会降低效率,所以出现了红黑树
 *
 * black-red-tree.
 *
 * Created by alan on 16/4/5.
 */
//TODO
public class BlackRedTree<Key extends  Comparable<Key>>{

    private final static boolean RED=true;
    private final static boolean BLACK=false;

    public class Node{
        Key key;
        int val;
        Node left,right;
        int N;
        boolean color;

        public Node(Key key, int val, Node left, Node right, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            N = n;
            this.color = color;
        }
    }


    public boolean isRed(Node  x){
        if(x==null) return false;
        return x.color==RED;
    }

}
