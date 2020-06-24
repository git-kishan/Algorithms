import java.util.*;
import java.io.*;
public class b{
	static List<int[]> [] al;//[0]->weight ,[1]->vertex
	static boolean [] vis;

    public static void main( String [] args) throws IOException{
	   BufferInput sc=new BufferInput();
	   int n=sc.nextInt();
	   int m=sc.nextInt();
	   al=new ArrayList[n+1];
	   vis=new boolean[n+1];
	   for(int i=1;i<=n;i++)al[i]=new ArrayList<>();
	   for(int i=0;i<m;i++){
		   int a=sc.nextInt();
		   int b=sc.nextInt();
		   int c=sc.nextInt();
		   al[a].add(new int[]{c,b});
		   al[b].add(new int[]{c,a});
	   }
	   TreeSet<int []> tset=new TreeSet<>((a,b)->{//[0]->weight ,[1]->vertex
		if(a[0]==b[0])return a[1]-b[1];
		else if(a[1]==b[1])return a[0]-b[0];
		return a[0]-b[0];
	   });
	   tset.add(new int []{0,1});
	   long cost=0;
	   while(!tset.isEmpty()){
		   int [] p=tset.pollFirst();
		   int u=p[1];
		   int w=p[0];
		   if(vis[u])continue;
		   vis[u]=true;
		   cost+=w;
		   for(int [] v : al[u]){
			   if(!vis[v[1]])tset.add(new int[]{v[0],v[1]});
		   }
	   }

	   boolean valid=true;
	   for(int i=1;i<=n;i++)if(!vis[i])valid=false;
	   if(!valid)System.out.println("IMPOSSIBLE");
	   else System.out.println(cost);
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


