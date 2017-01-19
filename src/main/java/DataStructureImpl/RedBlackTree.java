package DataStructureImpl;



/**
 *
 * 因为之前的二查堆(树)在最坏的情况下(数据本身有序，二叉变为单枝)，遍历需要O(n)<虽然其它情况为O(lgN)>
 * 所以出出现下面的 2-3平衡树 => 由于2-3树在旋转的时候考虑情况太多,代码创建的东西太多反而会降低效率,所以出现了红黑树
 *
 * black-red-tree. 保证最坏情况下的性能，支持更多的操作{排名，选择，排序，范围查找}
 *
 * Created by alan on 16/4/5.
 */
public class RedBlackTree<Key extends  Comparable<Key>,Value>{

    private Node root;

    private final static boolean RED=true;
    private final static boolean BLACK=false;

    public class Node{
        Key key;
        Value val;
        Node left,right;
        int N;             //以该节点为根子节点的总数
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
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

    /**
     * 根节点总是黑色的
     * @param h
     */
    public void flipColors(Node h){
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }

    public int size(Node node){
        if(node==null) return 0;
        return node.N;
    }



    public void put(Key key, Value value){
        root=put(root,key,value);
        root.color=BLACK;
    }

    /**
     * 插入操作
     * 从父节点开始找Key,找到则更新，没有则创建
     * @param h
     * @param key
     * @param value
     * @return
     */
    public Node put(Node h,Key key,Value value){
        //用红链接与父节点相连
        if(h==null)
            return new Node(key,value,1,RED);

        int cmp=key.compareTo(h.key);
        if(cmp<0) h.left=put(h.left,key,value);
        else if(cmp>0) h.right=put(h.right,key,value);
        else h.val=value;

        if(isRed(h.right) && !isRed(h.left)) h=rotateLeft(h);
        else if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);
        else flipColors(h);

        h.N=1+size(h.left)+size(h.right);
        return h;
    }


}
