import java.util.*;
import java.io.*;
public class b{
	static class Edge{
		int a,b,c;
		Edge(int a,int b,int c){
			this.a=a;this.b=b;this.c=c;
		}
	}
	static int [] parent;
	static int [] rank;
	static int find(int k){
		if(parent[k]!=k)
		  parent[k]=find(parent[k]);
		return parent[k];
	}
 
	static void merge(int a,int b){
		int x=find(a);
		int y=find(b);
		if(x==y)return;
		if(rank[x]>rank[y]){
			parent[y]=x;
		}
		else if(rank[y]>rank[x]){
			parent[x]=y;
		}
		else{
			parent[x]=y;
			rank[y]+=1;
		}
	}
 
    public static void main( String [] args) throws IOException{
       BufferInput sc=new BufferInput();
	   int n=sc.nextInt();
	   int m=sc.nextInt();
	   parent=new int[n+1];
	   rank=new int[n+1];
	   for(int i=1;i<=n;i++){
		   parent[i]=i;
		   rank[i]=0;
	   }
	   List<Edge> list=new ArrayList<>();
	   for(int i=0;i<m;i++){
		   int [] x=sc.nextIntArray(3);
		   list.add(new Edge(x[0],x[1],x[2]));
	   }
	   list.sort((a,b)->a.c-b.c);
	   long cost=0;
	   int cnt=0;
	   for(int i=0;i<list.size() && cnt<n-1;i++){
		   Edge e=list.get(i);
		   int x=find(e.a);
		   int y=find(e.b);
		   if(x!=y){
			   cnt++;
			   cost+=e.c;
			   merge(e.a,e.b);
		   }
	   }
 
	   if(cnt!=(n-1)){
		   System.out.println("IMPOSSIBLE");
	   }
	   else	
	       System.out.println(cost);
 
 
    }
}

class BufferInput{	
	 private int BUFFER_SIZE = 1 << 16;
	
	private  DataInputStream din;
	
	private  byte[] buffer;
	
	private int bufferPointer, bytesRead;
	
	public BufferInput() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}
 
	public BufferInput( String file_name) throws IOException {
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
 
