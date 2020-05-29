import java.util.*;
import java.io.*;
class c{
    static List<Integer> [] al;
    static boolean [] visited;
    static int [] lo;
    static int [] in;
    static int timer=0;
    static void dfs(int u,int p){
        visited[u]=true;
        lo[u]=in[u]=timer++;
        int children=0;
        for(int v : al[u]){

            if(!visited[v]){
                        
                children++;
                dfs(v,u);
                lo[u]=Math.min(lo[u],lo[v]);

                if(p==-1 && children>1){
                    System.out.print(u+" ");
                }
                if(p!=-1 && in[u]<=lo[v]){
                    System.out.print(u+" ");
                }
            }
            else if(v!=p){
                lo[u]=Math.min(lo[u],in[v]);
            }
        }
    }
    public static void main(String [] args){
        int [][] edge=new int[][]{{1,2},{2,3},{3,4},{5,4}};
        int n=5;
        al=new ArrayList[n+1];
        for(int i=1;i<=n;i++)al[i]=new ArrayList<>();
        lo=new int[n+1];
        in=new int[n+1];
        visited=new boolean[n+1];
        for(int i=0;i<edge.length;i++){
            al[edge[i][0]].add(edge[i][1]);
            al[edge[i][1]].add(edge[i][0]);
        }

        dfs(1, -1);



    }
}
