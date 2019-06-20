import java.util.Arrays;
import java.util.Scanner;

public class MazeS3 {
	static int r = 0;
	static int c = 0;
	static String[][] maze;
	static int[][] grid;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		while (t > 0) {
			r = in.nextInt();
			c = in.nextInt();

			maze = new String[r][c];
			grid = new int[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					grid[i][j] = Integer.MAX_VALUE;
				}
			}

			String trash = in.nextLine();

			for (int i = 0; i < r; i++) {
				maze[i] = in.nextLine().split("");
			}

			travel(0, 0, 1);

			if (grid[r - 1][c - 1] == Integer.MAX_VALUE || grid[r-1][c-1] == -1) {
				System.out.println(-1);
			} else {
				System.out.println(grid[r - 1][c - 1]);
			}

			t--;
		}
	}

	public static void travel(int row, int col, int x) {
		if (row < r && row >= 0 && col >= 0 && col < c) {
			if (grid[row][col] >= 0 && x < grid[row][col]) {
				if (maze[row][col].equals("*")) {
					grid[row][col] = -1;
				} else if (maze[row][col].equals("+")) {
					grid[row][col] = x;
					travel(row + 1, col, x + 1);
					travel(row - 1, col, x + 1);
					travel(row, col + 1, x + 1);
					travel(row, col - 1, x + 1);
				} else if (maze[row][col].equals("|")) {
					grid[row][col] = x;
					travel(row + 1, col, x + 1);
					travel(row - 1, col, x + 1);
				} else if (maze[row][col].equals("-")) {
					grid[row][col] = x;
					travel(row, col + 1, x + 1);
					travel(row, col - 1, x + 1);
				}
			}
		}

	}

}
