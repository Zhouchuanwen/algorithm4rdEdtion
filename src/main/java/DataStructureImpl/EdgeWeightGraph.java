package DataStructureImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 加权无向图
 * Created by alan on 16/12/15.
 */
public class EdgeWeightGraph {

    private final int V;   //顶点总数
    private int E;         //边的总数
    private List<Edge>[] adj;  //邻接表

    public EdgeWeightGraph(int V) {
        this.V = V;
        this.E=0;

        for(int v=0;v<V;v++){
            adj[v]=new ArrayList<>();
        }
    }


    /**
     *
     * @param in  流读取一个加权无向图
     * @param V   顶点总数
     */
    public EdgeWeightGraph(InputStream in, int V){
        this.V = V;
        try {
            String res="";
            BufferedReader bin=new BufferedReader(new InputStreamReader(in));
            while ((res=bin.readLine())!=null){
                String[] vertexs=res.split(" ");
                if(vertexs.length==3){
                    int v=Integer.parseInt(vertexs[0]);
                    int w=Integer.parseInt(vertexs[1]);
                    double weight=Double.parseDouble(vertexs[2]);
                    addEdge(new Edge(v,w,weight));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public void addEdge(Edge e){
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * @return  返回无向图中所有的边
     */
    public Iterable<Edge> edges(){
        List<Edge> list=new ArrayList<>();
        for(int v=0;v<V;v++){
            for(Edge e:adj[v]){
                if(e.other(v)>v)
                    list.add(e);
            }
        }
        return list;
    }

}
