import java.util.Scanner;

public class Gates {
	// array representation of disjoint set
	static int[] parent;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int G = in.nextInt();
		int P = in.nextInt();

		parent = new int[G + 1];

		// Set all the parents to itself
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int[] planes = new int[P];
		for(int i = 0; i < P; i++) {
			planes[i] = in.nextInt();
		}
		
		//Store the num of planes docked
		int dock = 0;
		//Temp for index
		int temp = 0;
		boolean bool = true;
		while(dock < P && bool) {
			int cur = planes[temp];
			int optimalPos = find(cur);
			
			if(optimalPos == 0) {
				System.out.println(dock);
				bool = false;
				break;
			}
			
			union(optimalPos, optimalPos-1);
			
			dock += 1;
			temp++;
		}
		
		if(bool) {
			System.out.println(dock);
		}
		
		
	}

	//Find the parent and return it
	public static int find(int x) {
		if (x != parent[x]) {
			//This changes the current root to its direct parent
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int x, int y) {
		parent[find(x)] = find(y);
	}
}
