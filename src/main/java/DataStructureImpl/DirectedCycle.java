package DataStructureImpl;

import java.util.Stack;

/**
 *
 * 有向无环图
 *
 * 无环检测: 如果任务调度之间存在x->y,y->z,z->x ("->"代表依赖)
 *          那么任务是无法执行的. 例子先导课程安排.
 *
 * Created by alan on 16/12/15.
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;    //有向环中的所有的顶点
    private boolean[] onStack;      //递归调用栈上的所有顶点

    public DirectedCycle(DirectGraph G){
        onStack=new boolean[G.V()];
        edgeTo=new int[G.V()];
        marked=new boolean[G.V()];
        for (int v=0;v<G.V();v++)
            if(!marked[v])
                dfs(G,v);
    }

    /**
     * 检测是否有环
     * @param G
     * @param v
     */
    private void dfs(DirectGraph G,int v){
        onStack[v]=true;
        marked[v]=true;

        for (int w:G.adj(v)){
            if(this.hasCycle()) {
                return;
            } else if (!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }else if(onStack[w]){
                cycle=new Stack<>();
                for(int x=v;x!=w;x=edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v]=false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

}
