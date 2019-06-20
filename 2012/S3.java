import java.util.ArrayList;
import java.util.Scanner;

public class S3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		int[] read = new int[N];
		int[] freq = new int[1001];

		for (int i = 0; i < N; i++) {
			int temp = in.nextInt();
			read[i] = temp;
			freq[temp] += 1;
		}

		int maxFir = 0, maxSec = 0;
		int firNum = -1, secNum = -1;
		ArrayList<Integer> max = new ArrayList<Integer>();
		ArrayList<Integer> min = new ArrayList<Integer>();

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > maxFir) {
				maxFir = freq[i];
			}
		}
		// System.out.println(maxFir);

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] == maxFir) {
				max.add(i);
			}
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > maxSec && freq[i] != maxFir) {
				maxSec = freq[i];
			}
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] == maxSec) {
				min.add(i);
			}
		}

		System.out.println(max);
		System.out.println(min);

//		if(max.get(max.size()-1) > min.get(min.size()-1)) {
//			System.out.println(Math.abs(max.get(max.size()-1) - min.get(0)));
//		} else {
//			System.out.println(Math.abs(max.get(0) - min.get(min.size()-1)));
//		}

		int diff = -1;

		if (max.size() != 1) {
			for (int i = 0; i < max.size() - 1; i++) {
				if (Math.abs(max.get(i) - max.get(i + 1)) > diff) {
					diff = Math.abs(max.get(i) - max.get(i + 1));
				}
			}
		} else {

			for (int i = 0; i < max.size(); i++) {
				for (int j = 0; j < min.size(); j++) {
					int temp = Math.abs(max.get(i) - min.get(j));
					// System.out.println(temp);
					if (temp > diff) {
						diff = temp;
					}
				}
			}
		}
		System.out.println(diff);
	}
}
