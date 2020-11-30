import java.util.*;
import java.io.*;

public class Lis{
    

    public static void main(String [] args) throws IOException{

       // int [] a={ 2, 5, 3, 7, 11, 8, 10, 13, 6 };
       int [] a={1,1,3,6,5,7};
        
        int [] lis=new int[a.length];
        int lisLength=0;
        Arrays.fill(lis,-1);
        

        for(int i=0;i<a.length;i++){

            int l=0,r=lisLength,ans=lisLength;
            
            while(l<=r){
                int mid=(l+r)/2;
                if(lis[mid]<a[i]){
                    ans=mid+1;
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }

           lis[ans]=a[i];
           if(ans>lisLength){
               lisLength=l;
           }
        }

        System.out.println(lisLength);
    }
}
