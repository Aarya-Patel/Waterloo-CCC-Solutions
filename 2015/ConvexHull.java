import java.util.Arrays;
import java.util.Scanner;

public class ConvexHull {
	static int K, N, M, A, B;
	static int[][] matrix;
	static int[][] damage;
	static boolean[] spt;
	static int[][] dist;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		K = in.nextInt();
		N = in.nextInt();
		M = in.nextInt();
		
		matrix = new int [N][N];
		damage = new int[N][N];
		spt = new boolean[N];
		dist = new int[N][2];
		
		for(int i = 0; i < M; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			int t = in.nextInt();
			int h = in.nextInt();
			matrix[a][b] = t;
			matrix[b][a] = t;
			damage[a][b] = h;
			damage[b][a] = h;
		}
		A = in.nextInt()-1;
		B = in.nextInt()-1;
		
		
		for(int i = 0; i < dist.length; i++) {
			dist[i][0] = Integer.MAX_VALUE;
		}
		
//		System.out.println(Arrays.deepToString(matrix));
//		System.out.println(Arrays.deepToString(damage));
//		System.out.println(K);
//		
		//Start at node A
		dist[A][0] = 0;
		dij(A,A);
//		System.out.println(Arrays.deepToString(dist));
		if(dist[B][0] != Integer.MAX_VALUE) {
			System.out.println(dist[B][0]);
		} else {
			System.out.println(-1);
		}
	}
	
	public static void dij(int u, int v) {
		spt[u] = true;
		 
		//Relax Nodes
		for(int i = 0; i < matrix[u].length; i++) {
//			System.out.println("Node" + (u+1) + " " + (i+1));
			if(i != v && matrix[u][i] != 0 && dist[u][0] + matrix[u][i] < dist[i][0] && (dist[u][1] + damage[u][i]) < K) {
				dist[i][0] = dist[u][0] + matrix[u][i];
				dist[i][1] = damage[u][i] + dist[u][1];
//				System.out.println("SWAP");
			}
		}
//		System.out.println(Arrays.toString(spt));
//		System.out.println(Arrays.deepToString(dist));
		
		//Pick Min Node not in spt set
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < dist.length; i++) {
//			System.out.println(i);
			if(!spt[i] && dist[i][0] < min) {
				min = dist[i][0];
				minIndex = i;
			}
		}
//		System.out.println(minIndex + " " + min);
	
		if(minIndex != -1) {
			dij(minIndex,u);
		}
	}
}
