package puzzles.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 按照之字形打印二叉树
 * Created by alan on 17/1/18.
 */
public class Solution {

    class TreeNode{
        int value=0;
        TreeNode left=null;
        TreeNode right=null;

        public TreeNode(int value){
            this.value=value;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode treeNode){
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
        if(treeNode==null)
            return resultList;

        ArrayList<Integer> result=new ArrayList<>();

        Queue<TreeNode> nodes=new LinkedList<>();
        int nextNum=0;
        int tobePrint=1;
        int isLeftToRight=0;

        nodes.add(treeNode);

        while (!nodes.isEmpty()){
            TreeNode current=nodes.poll();
            result.add(current.value);
            nextNum++;

            if(current.left!=null)
                nodes.add(current.left);
            if(current.right!=null)
                nodes.add(current.right);

            //判断本层是否打印完毕
            if(nextNum==tobePrint){
                if(isLeftToRight==1){
                    resultList.add(reverse(result));
                }else{
                    resultList.add(result);
                }
                tobePrint=nodes.size();
                nextNum=0;
                result=new ArrayList<>();
                isLeftToRight=isLeftToRight^1;
            }
        }
        return resultList;
    }



    private ArrayList<Integer> reverse(ArrayList<Integer> result){
        ArrayList<Integer> reverseResult = new ArrayList<Integer>();
        for(int i=result.size()-1;i>=0;i--){
            reverseResult.add(result.get(i));
        }
        return reverseResult;
    }









}
