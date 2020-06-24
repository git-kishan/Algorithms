import java.util.*;
import java.io.*;

class a{
  static List<int [] > [] al;
    public static void main(String [] args){
      //{u , v ,w}
      // int [][] edges={{0,1,1},{0,2,5},{1,2,2},{1,3,2},{1,4,1},{2,4,2},{3,4,3},
      //               {3,5,1},{4,5,2}};
      int [][] edges={{2,1,1},{2,3,1},{3,4,1}};
      int n=5;
      al=new ArrayList[5];
      for(int i=0;i<n;i++)al[i]=new ArrayList<>();
      for(int i=0;i<edges.length;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int w=edges[i][2];
        al[u].add(new int[]{v,w});
      }

      int [] dist=new int[n];
      Arrays.fill(dist,Integer.MAX_VALUE);
      boolean [] vis=new boolean[n];
      TreeSet<int [] > tset=new TreeSet<>((a,b)->{
        if(a[1]==b[1])return a[0]-b[0];
        return a[1]-b[1];
      });

      dist[2]=0;
      tset.add(new int[]{2,0});// (vertex,dist);

      while(!tset.isEmpty()){
        int [] p=tset.pollFirst();
        System.out.println("polled : "+p[0]+" , "+p[1]);
        int u=p[0];
        int d=p[1];
        if(vis[u])continue;
        vis[u]=true;

        for(int [] x : al[u]){
          int v=x[0];
          int w=x[1];
          if(!vis[v] && dist[v]>(d+w)){
            dist[v]=d+w;
            tset.add(new int []{v,d+w});
          }
        } 
      }


      for(int i=0;i<n;i++){
        System.out.println(i+" : "+ dist[i]);
      }

    }
}

