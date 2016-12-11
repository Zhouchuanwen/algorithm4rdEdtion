package DataStructureImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 16/12/11.
 */
public class DirectGraph {

    private int V;
    private int E;
    private List<Integer>[] adj;

    public DirectGraph(int V) {
        this.V = V;
        this.E=0;
        adj=(List<Integer>[]) new ArrayList[V];
        for(int v=0;v<V;v++){
            adj[v]=new ArrayList<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    /**
     * 给顶点添加边
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 将有向图进行反转.
     * @return
     */
    public DirectGraph reverse(){
        DirectGraph R=new DirectGraph(V);
        for(int v=0;v<V;v++)
            for (int w:adj[v])
                R.addEdge(w,v);
        return R;
    }

}
