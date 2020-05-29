import java.util.*;
import java.io.*;
public class b{
    static int [] reset;
    
    static void kmpPreprocess(String pat){
        int i=0,j=1;
        reset[0]=-1;
        while(i<pat.length()){
            while(j>=0 && pat.charAt(i)!=pat.charAt(j)){
                j=reset[j];
            }
            i++;j++;
            reset[i]=j;
        }
    }



    static void kmpSearch(String s,String pat){
        reset=new int[pat.length()+1];
        Arrays.fill(reset,-1);
        kmpPreprocess(pat);
        int i=0,j=0;

        while(i<s.length()){
            while(j>=0 && s.charAt(i)!=pat.charAt(j)){
                j=reset[j];
            }
            i++;j++;
            if(j==pat.length()){
                System.out.println("substring found at "+(i-j)+" index");
                j=reset[j];
            }
        }
    }

    public static void main(String [] args){
        String s="abcabcabcabcdefgfgadfddsabcabc";
        String pat="abcabc";
        kmpSearch(s, pat);

        System.out.println("");
        for(int i : reset){
            System.out.print(i+" ");
        }
        System.out.println("");

    }
}
