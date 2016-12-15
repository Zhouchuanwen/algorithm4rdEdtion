package datastructure;

import DataStructureImpl.DirectGraph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 16/12/15.
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(DirectGraph G, int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDFS(DirectGraph G,Iterable<Integer> sources){
        marked=new boolean[G.V()];
        for (int s:sources)
            if(!marked[s])
                dfs(G,s);
    }


    /**
     * 对当前的邻接点进行宽度优先搜索
     * @param G
     * @param v
     */
    public void dfs(DirectGraph G,int v){
        marked[v]=true;
        for (int w:G.adj(v))
            if(!marked[w])
                dfs(G,w);
    }


    public boolean marked(int v){
        return marked[v];
    }


    public static void main(String[] args) throws FileNotFoundException {
        //读取图
        DirectGraph G=new DirectGraph(new FileInputStream("graph.txt"));

        //获取命令行参数
        List<Integer> sources=new ArrayList<>();
        for(int i=1;i<args.length;i++)
            sources.add(Integer.parseInt(args[i]));

        //BFS
        DirectedDFS reachable=new DirectedDFS(G,sources);
        for(int v=0;v<G.V();v++)
            if(reachable.marked(v))
                System.out.println(v+" ");
    }

}
