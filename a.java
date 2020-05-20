import java.util.*;
import java.io.*;

class a {
   static  void buildTree(int [] tree,int [] arr,int index,int s,int e){
     if(s>e){
        return ;
     }
     if(s==e){
       tree[index]=arr[s];
       return; 
     }
     int mid=(s+e)/2;
     buildTree(tree,arr,2*index,s,mid);
     buildTree(tree,arr,2*index+1,mid+1,e);
     int left=tree[2*index];
     int right=tree[2*index+1];
     tree[index]=Math.min(left,right);
     
  }
  static int query(int [] tree,int index,int s,int e,int l,int r){
  
       if(r<s||l>e){
         return Integer.MAX_VALUE;
       }
       if(l<=s && e<=r){
         return tree[index];
       }
       int mid=(s+e)/2;
       int left=query(tree,2*index,s,mid,l,r);
       int right=query(tree,2*index+1,mid+1,e,l,r);
       return Math.min(left,right);
  }
    public static void update(int [] tree,int index,int s,int e,int i,int val){
        if(i<s||i>e){
            return;
        }
        if(s==e){
            tree[s]=val;
            return;
        }
        int mid=(s+e)/2;
        update(tree,2*index,s,mid,i,val);
        update(tree,2*index+1,mid+1,e,i,val);
        tree[index]=Math.min(tree[2*index],tree[2*index+1]);
    }
    public static void main(String args[] ){
       
        int [] arr={1,2,5,3,6,1,2,6};
        int n=arr.length;
        int [] tree=new int[4*n+1];
        buildTree(tree,arr,1,0,arr.length-1);
    
        // while(q-->0){
        //     String [] query=br.readLine().trim().split(" ");
        //     char c=query[0].charAt(0);
        //     int l=Integer.parseInt(query[1]);
        //     int r=Integer.parseInt(query[2]);
        //     if(c=='q'){
        //         int num=query(tree,1,0,n-1,l-1,r-1);
        //         System.out.println(num);
        //     }else if(c=='u'){
        //         update(tree,1,0,arr.length-1,l-1,r);
        //     }
        // }
    }
}
