package datastructure.BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://segmentfault.com/a/1190000002685939
 * Created by alan on 17/1/17.
 */
public class BinarySearchTree {

    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value=value;
            left=null;
            right=null;
        }
    }

    private TreeNode root;

    public BinarySearchTree(){
        this.root=null;
    }

    public BinarySearchTree(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }

    //递归方式创建二叉树
    private TreeNode makeBinaryTreeByArray(int[] array,int index) {
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    //广度优先
    public void bfs(){
        if (root==null) return;
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.remove();
            System.out.print(node.value+"    ");

            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

    }

    //深度优先
    public void dfs(){
        if (root==null) return;
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.push(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.pop();
            System.out.print(node.value+"    ");

            if(node.right!=null)
                queue.push(node.right);
            if(node.left!=null)
                queue.push(node.left);
        }
    }


    public TreeNode search(int key){
        TreeNode current=root;
        while (current!=null && current.value!=key){
            if(key<current.value)
                current=current.left;
            else
                current=current.right;
        }
        return current;
    }


    public TreeNode insert(int key){
        TreeNode node=new TreeNode(key);
        TreeNode current=root;
        TreeNode parent=null;

        if(current==null){
            root=node;
            return root;
        }
        while (true){
            parent=current;
            if(key<current.value){
                current=current.left;
                if(current==null){
                    parent.left=node;
                    return node;
                }
            }else {
                current = current.right;
                if (current == null) {
                    parent.right = node;
                    return node;
                }
            }
        }
    }



    /**删除节点*/
    public TreeNode deletNode(TreeNode root,int key){
        if(root==null)
            return null;

        if(key<root.value){
            root.left=deletNode(root.left,key);
        }else if(key>root.value){
            root.right=deletNode(root.right,key);
        }else {
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //找到右子树最小的节点，设置为root, 然后删除之后返回的节点作为右子树
            TreeNode minNode=findMin(root.right);
            root.value=minNode.value;
            root.right=deletNode(root.right,root.value);
        }
        return root;
    }


    /**根据BST 左子树比父节点小的特点*/
    public TreeNode findMin(TreeNode node){
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }

    /**根据BST 右子树比父节点大的特点*/
    public TreeNode findMax(TreeNode node){
        while (node.right!=null){
            node=node.right;
        }
        return node;
    }


    /**
     * 判断是否为同一棵树
     */
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.value!=q.value)
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }


    /**
     * 求树的最大高度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }else {
            int right=maxDepth(root.right);
            int left=maxDepth(root.left);
            return 1+Math.max(right,left);
        }
    }


    /**
     * 平衡树:
     *      它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1
     *      并且左右两个子树都是一棵平衡二叉树
     *
     *  最小二叉平衡树的节点的公式如下 F(n)=F(n-1)+F(n-2)+1 这个类似于一个递归的数列
     */
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        int depthOfLeft=getDepth(root.left,1);
        int depthOfRight=getDepth(root.right,1);

        if(Math.abs(depthOfLeft-depthOfRight)>1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


    public int getDepth(TreeNode tree,int currentDepth){
        if(tree==null)
            return currentDepth;
        return Math.max(getDepth(tree.left,currentDepth+1),getDepth(tree.right,currentDepth+1));
    }


    /**
     * 反转二叉树
     */
    public TreeNode invertTree(TreeNode root){
        if(root==null){
            return root;
        }else {
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;

            invertTree(root.right);
            invertTree(root.left);
        }
        return root;
    }


    /**
     * 找到叶子节点,以及去掉叶子节点之后的叶子节点
     */
    public List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> results=new ArrayList<>();
        if(root!=null)
            find(root,results);
        return results;
    }

    public int find(TreeNode node,List<List<Integer>> result){
        if(node==null)
            return 0;
        int depth=Math.max(find(node.right,result),find(node.left,result));
        if(depth==result.size())
            result.add(new ArrayList<>());
        result.get(depth).add(node.value);
        return depth+1;
    }



    /**
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /｜
     *           22   4 28 32 23
     */
    public static void main(String[] args){
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinarySearchTree tree=new BinarySearchTree(arr);
        System.out.print("深度优先:");
        tree.dfs();
        System.out.println();
        System.out.print("广度优先:");
        tree.bfs();
    }

}
