package datastructure.BST;

import java.util.ArrayDeque;

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
