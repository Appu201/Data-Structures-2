package Regex;
import java.util.*;

public class MobileValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(s.matches("[6-9]\\d{9}")) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}

	}

}
