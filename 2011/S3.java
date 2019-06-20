import java.util.ArrayList;
import java.util.Scanner;

public class S3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		ArrayList<String> out = new ArrayList<String>();
		
		for(int i = 0; i < T; i++) {
			int m = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			
			if(check(m,x) > y) {
				out.add("crystal");
			} else {
				out.add("empty");
			}
		}

		
		for(String i : out) {
			System.out.println(i);
		}
	}
	
	public static int check(int m, int x) {
		if(m >= 1) {
			int power = (int)Math.pow(5, (m-1));
			int thisX = x / power;
			
			if(thisX == 0 || thisX == 4) {
				return 0;
			} 
			else if(thisX == 1 || thisX == 3) {
				return 1*power + check(m-1, x % power);
			} 
			else {
				return 2*power + check(m-1, x % power);
			}	
		} 
		
		return 0;
		
	}
	
}
