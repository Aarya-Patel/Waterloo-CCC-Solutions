import java.util.LinkedList;
import java.util.Scanner;

public class Friends {

	static LinkedList<Integer>[] adj = new LinkedList[10000];
	static LinkedList<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			adj[a].add(b);
		}
		

		while (true) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			
			
			if (x == y && x == 0) {
				break;
			} else {
				queue.clear();
				int temp = DFSHelper(x,y);
				if(temp == -1) {
					
					System.out.println("No");
				} else {
					System.out.println("Yes " + temp);
				}
			}
		}
	}

	public static int DFSHelper(int start, int end) {
		boolean[] visited = new boolean[10000];
		queue.add(start);
		return DFS(start, end, -1, visited);
		
	}

	public static int DFS(int start, int end, int dist, boolean[] visited) {

		if (start == end) {
			return dist;
		} else if(queue.isEmpty()) {

			return -1;
		} else {
			int cur = queue.poll();

			visited[cur] = true;
			
			for(int i = 0; i < adj[cur].size(); i++) {
				if(!visited[adj[cur].get(i)]) {
					queue.add(adj[cur].get(i));

				}
			}
			
			return DFS(adj[cur].get(0), end, dist + 1, visited);
		}
	}

}
