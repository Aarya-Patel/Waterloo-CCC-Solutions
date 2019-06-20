import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ComputerPurchase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		HashMap<String, Integer> comp = new HashMap<String, Integer>();
		ArrayList<String> name = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			name.add(in.next());
//			String temp = in.nextLine();
			int score = 2 * in.nextInt() + 3 * in.nextInt() + in.nextInt();
			// in.nextLine();
			comp.put(name.get(i), score);
		}

		ArrayList<String> good = new ArrayList<String>();

		int max = -1;

		// Find the max
		for (int i = 0; i < comp.size(); i++) {
			if (comp.get(name.get(i)) >= max) {
				max = comp.get(name.get(i));
			}

		}

		// ADd the max elements
		for (int i = 0; i < comp.size(); i++) {
			if (comp.get(name.get(i)) == max) {
				good.add(name.get(i));

			}
		}

		for (int i = 0; i < good.size(); i++) {
			comp.remove(good.get(i));
			for (int j = 0; j < name.size(); j++) {
				if (good.get(i) == name.get(j)) {
					name.remove(j);
				}
			}
		}

		// System.out.println(comp);

		// System.out.println(name);

		ArrayList<String> good2 = new ArrayList<String>();

		max = -1;

		// Find the max
		for (int i = 0; i < name.size(); i++) {
			if (comp.get(name.get(i)) >= max) {
				max = comp.get(name.get(i));
			}
		}
		// Add the max elements
		for (int i = 0; i < name.size(); i++) {
			if (comp.get(name.get(i)) == max) {
				good2.add(name.get(i));
				// name.remove(i);
			}
		}
		// System.out.println(name);
		if (!good.isEmpty()) {
			for (int i = 0; i < good.size() - 1; ++i) {
				for (int j = i + 1; j < good.size(); ++j) {
					if (good.get(i).compareTo(good.get(j)) > 0) {

						// swap words[i] with words[j[
						String temp = good.get(i);
						good.set(i, good.get(j));
						good.set(j, temp);
					}
				}
			}
		}
		// System.out.println(good);
		if (!good2.isEmpty()) {
			for (int i = 0; i < good2.size() - 1; ++i) {
				for (int j = i + 1; j < good2.size(); ++j) {
					if (good2.get(i).compareTo(good2.get(j)) > 0) {

						// swap words[i] with words[j[
						String temp = good2.get(i);
						good2.set(i, good2.get(j));
						good2.set(j, temp);
					}
				}
			}
		}
		// System.out.println(good2);

		for (int i = 0; i < 2; i++) {
			if (!good.isEmpty()) {
				System.out.println(good.get(0));
				good.remove(0);
			} else if(!good2.isEmpty()){
				System.out.println(good2.get(0));
				good2.remove(0);
			}
		}

//		int index = 0;
//		int temp = 1;
//		for (int a = 0; a < 2; a++) {
//			String key = good.get(0);
//			if (!good.isEmpty()) {
//				for (temp = 1; temp < good.size(); temp++) {
//
//					if (key.compareTo(good.get(temp)) < 0) {
//						key = good.get(temp);
//						index = temp;
//					} else {
//						key = good.get(temp - 1);
//						index = temp -1;
//					}
//				}
//				System.out.println(key);
//				good.remove(index);
//				temp--;
//			} else {
//				
//				String key2 = good2.get(0);
//
//				for (temp = 1; temp < good2.size(); temp++) {
//
//					if (key.compareTo(good2.get(temp)) < 0) {
//						key = good2.get(temp);
//						index = temp;
//					} else {
//						key = good2.get(temp - 1);
//						index = temp -1;
//					}
//				}
//
//				System.out.println(key2);
//				good2.remove(index);
//				temp--;
//				
//			}
//		}

	}
}
