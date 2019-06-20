import java.util.ArrayList;
import java.util.Scanner;

public class TwentyFourS4 {
	static int max = -1;
	static ArrayList<Integer> cards;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		while (N > 0) {
			N--;

			max = Integer.MIN_VALUE;

			cards = new ArrayList<Integer>();

			for (int i = 0; i < 4; i++) {
				cards.add(in.nextInt());
			}

			for (int i = 0; i < cards.size(); i++) {
				int n = cards.get(i);
				cards.remove(i);
				recur(n);
				cards.add(i, n);
			}
			
			System.out.println(max);
		}
	}

	public static void recur(int num) {

		if (num <= 24 && cards.isEmpty() && num > max) {
			max = num;
		}
		

		for (int i = 0; i < cards.size(); i++) {
		
			int n = cards.get(i);
			cards.remove(i);
			recur(num * n);
			recur(num + n);
			recur(num - n);
			
			if (num % n == 0.0) {
				recur(num / n);
			}

			cards.add(i, n);
		}
	}


}
