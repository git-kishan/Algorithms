import java.util.*;
import java.io.*;
public class b{
	static Scanner sc=new Scanner(System.in);
	static long mod=1000*1000*1000+7; 
	static List<Integer> [] al;
	static int [] lo;
	static int [] in;
	static boolean [] visited;
	static int timer=0;
	
	static void dfs(int u,int par){
		visited[u]=true;
		in[u]=lo[u]=timer;
		timer++;
		for(int v : al[u]){
			if(!visited[v]){
				dfs(v,u);
				lo[u]=Math.min(lo[u],lo[v]);
				if(in[u]<lo[v]){
					System.out.println("Bridge : "+u+" - "+v);
				}
			}
			else if(v!=par){
				lo[u]=Math.min(lo[u],in[v]);
			}
		}
	}
	public static void main(String [] args){
		 int [][] edges=new int[][]{{1,2},{1,3},{1,4}};
		 int n=4;
		 al=new ArrayList[n+1];
		 for(int i=1;i<=n;i++)
			 al[i]=new ArrayList<>();
		 for(int i=0;i<edges.length;i++){
			 al[edges[i][0]].add(edges[i][1]);
			 al[edges[i][1]].add(edges[i][0]);
		 }
		 lo=new int[n+1];
		 in=new int[n+1];
		 visited=new boolean[n+1];
		 dfs(1,-1);
    }
}
