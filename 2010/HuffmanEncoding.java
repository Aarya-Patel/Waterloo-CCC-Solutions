import java.util.Arrays;
import java.util.Scanner;

public class HuffmanEncoding {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		int n = in.nextInt();
		String trash = in.nextLine();
		String[] nums = new String[n];
		String[] letter = new String[n];
		
		for(int i = 0; i < n; i++) {
			String[] temp = in.nextLine().split(" ");
			
			letter[i] = temp[0];
			nums[i] = temp[1];
		}
		String code = in.nextLine();
		String newCode = "";
		while(code.length() > 0) {
			int i = 0;
			
			while(!code.startsWith(nums[i]) && i < nums.length) {
				i++;
			}
			
			newCode += letter[i];
			code = code.substring(nums[i].length());
		}
		
		System.out.println(newCode);
		System.out.println(Arrays.toString(letter));
		System.out.println(Arrays.toString(nums));
	}
	
	
//	public static String encode(String code, String[] letter, String[] nums, int i) {
//		String codeD = "";
//		
//		for(int j = 0; j < code.length() - nums[i].length(); j+= nums[i].length()) {
//			if(code.substring(j, j + nums[i].length()).equals(nums[i])) {
//				codeD = codeD.substring(0, j) + letter[i] + codeD.substring(j);
//			}
//		}
//		
//		return codeD;
//	}
}
