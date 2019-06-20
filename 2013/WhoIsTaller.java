import java.util.LinkedList;
import java.util.Scanner;

public class WhoIsTaller {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		//Adjacency List
		LinkedList<Integer>[] adj = new LinkedList[N];
		LinkedList<Integer> queue = new LinkedList<>();
		
		//Initializing the adj list with LinkedList
		for(int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			adj[y-1].add(x-1);
		}
		
		int p = in.nextInt();
		int q = in.nextInt();
		
		//System.out.println((taller(adj, queue, p, q)));
	
		if(taller(adj, queue, p, q)) {
			System.out.println("yes");
		} else if(taller(adj, queue, q, p)) {
			System.out.println("no");
		} else {
			System.out.println("unknown");
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(adj[i]);
//		}		
	}
	
	public static boolean taller(LinkedList<Integer>[] adj, LinkedList<Integer> queue, int p, int q) {
		boolean[] visit = new boolean[adj.length];
	
		if(adj[q-1].isEmpty()) {
			return false;
		}
		
		for(int i = 0; i < adj[q-1].size(); i++) {
			if(adj[q-1].get(i) == p -1) {
				return true;
			}
			queue.add(adj[q-1].get(i));
			//System.out.println(adj[q-1].get(i));
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			//System.out.println(node);
			if(node == p-1) {
				return true;
			} else if(!visit[node]) {
				visit[node] = true;
				
				for(int i = 0; i < adj[node].size(); i++) {
					queue.add(adj[node].get(i));
				}
			}
		}
		
		return false;
	}
}
