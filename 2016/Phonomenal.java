import java.util.LinkedList;
import java.util.Scanner;

public class Phonomenal {

	public static LinkedList<Integer>[] adj;
	public static int N, M;
	public static boolean[] pho;
	public static boolean[] marked;
	public static int[] dist;
	public static int totalDist = 0;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		M = in.nextInt();
		
		pho = new boolean[N];
		marked = new boolean[N];
		dist = new int[N];
		adj = new LinkedList[N];
		
		for(int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			pho[in.nextInt()] = true;
		}
		
		for(int i = 0; i < N-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		
		//Mark all the nodes in the path from a starting pho restaurant
		for(int i = 0; i < N; i++) {
			if(pho[i]) {
				mark(i,-1);
				break;
			}
		}
		
		//Compute DFS by calculating dist from a starting node(pho restaurant) and DFS from that node
		for(int i = 0; i < N; i++) {
			if(marked[i]) {
				computeDist(i, -1, 0);
				break;
			}
		}
		
		//Find the max dist node from the starting pho restaurant
		int maxIndex = -1;
		for(int i = 0; i < dist.length; i++) {
			if(marked[i] && (maxIndex == -1 || dist[maxIndex] < dist[i])) {
				maxIndex = i;
			}
		}
		
		//Once we have the furthest vertex in the path, We can finally DFS and compute this dist
		//Reset dist array
		dist = new int[N];
		computeDist(maxIndex, -1, 0);
		
		int optimalDist = 0;
		for(int i = 0; i < dist.length; i++) {
			optimalDist = Math.max(optimalDist, dist[i]);
		}
		
		System.out.println(totalDist - optimalDist);
		
	}
	
	//DFS and compute dist from the starting node
	public static void computeDist(int current, int prev, int d) {
		dist[current] = d;
		for(int i : adj[current]) {
			if(marked[i] && i != prev) {
				computeDist(i, current, d + 1);
			}
		}
	}
	
	
	//Recursively find all the nodes in the path
	public static void mark(int current, int prev) {
		
		if(pho[current]) {
			marked[current] = true;
		}
		
		for(int i : adj[current]) {
			if(i == prev) {
				continue;
			}
			mark(i, current);
			if(marked[i]) {
				totalDist += 2;
				marked[current] = true;
			}
		}
	}
}
