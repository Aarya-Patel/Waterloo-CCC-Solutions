import java.util.Arrays;
import java.util.Scanner;

public class S5 {

	static int R;
	static int C;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Input
		R = in.nextInt();
		C = in.nextInt();
		// Array representing the lab
		int[][] lab = new int[R][C];
		// Num of cats
		int K = in.nextInt();
		// Label all the position -1 if it is a cat cage
		for (int i = 0; i < K; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			lab[x - 1][y - 1] = -1;
		}
		
		System.out.println(travel(lab, 0 , 0));
	}

	public static int travel(int[][] lab, int r, int c) {
		if (r == R-1 & c == C-1) {
			return 1;
		}  
		if(lab[r][c] == -1) {
			return 0;
		}
		
		if(r != R-1 && c != C-1 ) {
			return travel(lab, r + 1, c) + travel(lab, r, c + 1);
		} 
		else if (r != R-1 ) {
			return travel(lab, r + 1, c);
		} else if(c != C-1 ) {
			return travel(lab, r, c + 1);
		}
		
		return 0;

	}
}
