package datastructure.BST;

/**
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




}
