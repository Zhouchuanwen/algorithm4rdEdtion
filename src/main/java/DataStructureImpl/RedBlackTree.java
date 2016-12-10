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
public class RedBlackTree<Key extends  Comparable<Key>>{

    private final static boolean RED=true;
    private final static boolean BLACK=false;

    public class Node{
        Key key;
        int val;
        Node left,right;
        int N;             //以该节点为根自节点的总数
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


    /**
     *  左旋
     */
    public Node rotateLeft(Node h){
        //交换左右链接
        Node x=h.right;
        h.right=x.left;
        x.left=h;

         //改变连接颜色
        x.color=h.color;
        h.color=RED;

        //改变连接的自节点总数
        x.N=h.N;
        h.N=1+size(h.right)+size(h.right);

        return x;
    }

    /**
     *  右旋
     */
    public Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;

        x.color=h.color;
        h.color=RED;

        x.N=h.N;
        h.N=1+size(h.right)+size(h.right);
        return  x;
    }


    public int size(Node node){
        if(node==null) return 0;
        return node.N;
    }


}
