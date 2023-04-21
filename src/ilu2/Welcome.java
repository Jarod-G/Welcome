package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		if(input.trim().length() == 0) {
			return "Hello, my friend";
		}
		input = input.substring(0,1).toUpperCase() + input.substring(1);
		return "Hello, " + input;
	}
}
