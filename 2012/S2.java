import java.util.Scanner;
public class S2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		int val = 0;
		int oldR = Integer.MAX_VALUE;
		int oldS = 0;
		
		for(int i = 0; i < line.length(); i += 2) {
			int a = Character.getNumericValue(line.charAt(i));
			int r = roman(line.charAt(i + 1));
			
			val += a * r;
			if(r > oldR) {
				val -= 2 * oldS;
			} 
			
			oldR = r;
			oldS = a * r;
		}
		
		
		
		System.out.println(val);
	}
	
	public static int roman(char str) {
		if(str == 'I') {
			return 1;
		} else if(str == 'V') {
			return 5;
		} else if(str == 'X') {
			return 10;
		} else if(str == 'L') {
			return 50;
		} else if(str == 'C') {
			return 100;
		} else if(str == 'D') {
			return 500;
		} else {
			return 1000;
		}
	}
}
