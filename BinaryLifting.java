import java.util.*;
import java.io.*;

public class BinaryLifting{

    static List<Integer> [] al;
    static int [][] up;
    static int [] level;
    static int logn;

    static void preprocessing(int u,int p){
        if(p!=-1)level[u]=level[p]+1;
        up[u][0]=p;
        
        for(int i=1;i<=logn;i++){
            if(up[u][i-1]!=-1){
                up[u][i]=up[up[u][i-1]][i-1];
            }
        }
        for(int v : al[u])if(v!=p)preprocessing(v,u);
    }

    static int query(int u,int v){

        if(level[u]<level[v]){// assume level of u is greater otherwise swap it
            int temp=u;
            u=v;
            v=temp;
        }

        int k=level[u]-level[v];

        for(int i=logn;i>=0 & k>0;i--){
            int bit=((k>>i)&1);
            if(bit==0)continue;
            u=up[u][i];
        }
        
        if(u==v)return u;

        for(int i=logn;i>=0;i--){
            if(up[u][i]!=up[v][i]){
                u=up[u][i];
                v=up[v][i];
            }
        }
        return up[u][0];
    }


    public static void main(String [] args) throws IOException{
        FastScanner sc=new FastScanner();
        int n=sc.nextInt();
        int q=sc.nextInt();

        al=new ArrayList[n+1];
        for(int i=0;i<=n;i++)al[i]=new ArrayList<>();
        logn=(int)Math.ceil(Math.log(n)/Math.log(2));
        up=new int[n+1][logn+1];
        for(int i=0;i<=n;i++)Arrays.fill(up[i],-1);
        level=new int[n+1];

        for(int i=1;i<=(n-1);i++){
            int v=sc.nextInt();
            int u=i+1;
            al[u].add(v);
            al[v].add(u);
        }
        preprocessing(1,-1);

        StringBuilder sb=new StringBuilder("");
        while(q-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int ans=query(a,b);
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString().trim());


    }
}






























class FastScanner{	
    private int BUFFER_SIZE = 1 << 16;
   
   private  DataInputStream din;
   
   private  byte[] buffer;
   
   private int bufferPointer, bytesRead;
   
   public FastScanner() {
       din = new DataInputStream(System.in);
       buffer = new byte[BUFFER_SIZE];
       bufferPointer = bytesRead = 0;
   }

   public FastScanner( String file_name) throws IOException {
       din = new DataInputStream(new FileInputStream(file_name));
       buffer = new byte[BUFFER_SIZE];
       bufferPointer = bytesRead = 0;
   }
   
   public String readLine() throws IOException {
        byte[] buf = new byte[64];
       int cnt = 0, c;
       while ((c = read()) != -1) {
           if (c == '\n')
               break;
           buf[cnt++] = (byte) c;
       }
       return new String(buf, 0, cnt);
   }
   
   public String next() throws IOException{

       byte c = read();
       while(Character.isWhitespace(c)){
           c = read();
       }
       
        StringBuilder builder = new StringBuilder();
       builder.append((char)c);
       c = read();
       while(!Character.isWhitespace(c)){
           builder.append((char)c);
           c = read();
       }
       
       return builder.toString();
   }

   public int nextInt() throws IOException {
       int ret = 0;
       byte c = read();
       while (c <= ' ')
           c = read();
        boolean neg = (c == '-');
       if (neg)
           c = read();
       do {
           ret = ret * 10 + c - '0';
       } while ((c = read()) >= '0' && c <= '9');

       if (neg)
           return -ret;
       return ret;
   }
   
   public int[] nextIntArray( int n) throws IOException {
        int arr[] = new int[n];
       for(int i = 0; i < n; i++){
           arr[i] = nextInt();
       }
       return arr;
   }

   public long nextLong() throws IOException {
       long ret = 0;
       byte c = read();
       while (c <= ' ')
           c = read();
        boolean neg = (c == '-');
       if (neg)
           c = read();
       do {
           ret = ret * 10 + c - '0';
       } while ((c = read()) >= '0' && c <= '9');
       if (neg)
           return -ret;
       return ret;
   }
   
   public long[] nextLongArray( int n) throws IOException {
        long arr[] = new long[n];
       for(int i = 0; i < n; i++){
           arr[i] = nextLong();
       }
       return arr;
   }

   public char nextChar() throws IOException{
       byte c = read();
       while(Character.isWhitespace(c)){
           c = read();
       }
       return (char) c;	
   }
   
   public double nextDouble() throws IOException {
       double ret = 0, div = 1;
       byte c = read();
       while (c <= ' ')
           c = read();
        boolean neg = (c == '-');
       if (neg)
           c = read();

       do {
           ret = ret * 10 + c - '0';
       } while ((c = read()) >= '0' && c <= '9');

       if (c == '.') {
           while ((c = read()) >= '0' && c <= '9') {
               ret += (c - '0') / (div *= 10);
           }
       }

       if (neg)
           return -ret;
       return ret;
   }
   
   public double[] nextDoubleArray( int n) throws IOException {
        double arr[] = new double[n];
       for(int i = 0; i < n; i++){
           arr[i] = nextDouble();
       }
       return arr;
   }

   private void fillBuffer() throws IOException {
       bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
       if (bytesRead == -1)
           buffer[0] = -1;
   }

   private byte read() throws IOException {
       if (bufferPointer == bytesRead)
           fillBuffer();
       return buffer[bufferPointer++];
   }

   public void close() throws IOException {
       if (din == null)
           return;
       din.close();
   }

}

