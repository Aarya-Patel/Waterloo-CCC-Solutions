import java.util.Scanner;

public class PenniesInTheRingS2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int pennies = 0;
			int r = in.nextInt();
			
			if(r==0) {
				break;
			}
			
			for(int i = 1; i < r; i++) {
				pennies += (int) Math.sqrt(r*r - i*i) + 1 ;
				
			}
			
			pennies *= 4;
			pennies += 4+1;
			System.out.println(pennies);
		}
	}
}
