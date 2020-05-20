import java.util.*;
class Bit{
    static int [] bit;
    static int query(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=bit[i];
            i-=i&(-i);
        }
        return sum;
    }
    static void update(int i,int n,int val){
        i++;
        while(i<=n){
            bit[i]+=val;
            i+=i&(-i);
        }
    }
    public static void main(String [] args){
        int [] a={4,1,2,5,2,6};
        int max=-1;
        for(int  i : a)
          max=Math.max(max,i);
        bit=new int[max+5];
        for(int i=0;i<a.length;i++){
            int s=query(a[i]);
            System.out.println(a[i]+" : "+s);
            update(a[i],max+1,1);
        }
           

    }
