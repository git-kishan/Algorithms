import java.util.*;
import java.io.*;
public class b{
	
    public static void main( String [] args) throws IOException{
       BufferInput sc=new BufferInput();
       int n=sc.nextInt();
	   int m=sc.nextInt();
	   int [] in=new int[n+1];
 
	   List<Integer> [] al=new ArrayList[n+1];
	   for(int i=1;i<=n;i++)al[i]=new ArrayList<>();
	   for(int i=0;i<m;i++){
		   int s=sc.nextInt();
		   int d=sc.nextInt();
		   in[d]++;
		   al[s].add(d);
	   }
 
	   List<Integer> list=new ArrayList<>();
	   Queue<Integer> q=new LinkedList<>();
	   for(int i=1;i<=n;i++)if(in[i]==0)q.add(i);
 
	   while(!q.isEmpty()){
		   int u=q.poll();
		   list.add(u);
		   for(int v : al[u])if(--in[v]==0)q.add(v);
	   }
 
	   if(list.size()!=n){
		   System.out.println("IMPOSSIBLE");
	   }
	   else{
		   StringBuilder sb=new StringBuilder("");
		   for(int i : list)sb.append(i+" ");
		   System.out.println(sb.toString());
	   }
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
