package Regex;
import java.util.*;

public class UsernameValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(s.matches("[_a-zA-Z0-9]{5,15}")) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}
	}

}
