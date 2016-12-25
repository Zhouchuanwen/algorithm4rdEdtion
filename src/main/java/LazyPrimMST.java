import DataStructureImpl.Edge;
import DataStructureImpl.EdgeWeightGraph;
import DataStructureImpl.MinPQ;

import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * 最小生成树的Prim时延实现
 *      时间：ELogE(worst)
 *
 * Created by alan on 16/12/24.
 */
public class LazyPrimMST {

    private boolean[] marked;       //最小生成树顶点
    private Queue<Edge> mst;        //最小生成树的边
    private MinPQ<Edge> pq;    //横切边，包括失效边


    public LazyPrimMST(EdgeWeightGraph G){
        pq=new MinPQ<Edge>();
        marked=new boolean[G.V()];
        mst=new LinkedList<>();

        visit(G,0);    //假设G是连通的

        while (!pq.isEmpty()){
            Edge e=pq.delMin();    //从pq中得到最小的边

            int v=e.either(),w=e.other(v);
            if(marked[v] && marked[w]) continue;  //跳过失效的边
            mst.add(e);                           //将边添加到树中
            if(!marked[v])
                visit(G,v);
            if(!marked[w])
                visit(G,w);
        }
    }

    private void visit(EdgeWeightGraph G, int v) {
        marked[v]=true;
        for (Edge e:G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }


    public Iterable<Edge> edges(){
        return mst;
    }


}
