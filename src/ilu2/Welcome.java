package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		if(input == null || input.trim().length() == 0 ) {
			return "Hello, my friend";
		}
		String[] noms = input.split(",");
		if(noms.length > 1) {
			return "Hello, " + noms[0].substring(0,1).toUpperCase() + noms[0].substring(1).toLowerCase() + ", " + noms[1].substring(0,1).toUpperCase() + noms[1].substring(1).toLowerCase() ;
		}
		if(input.equals(input.toUpperCase())) {
			return "HELLO, " + input.toUpperCase() + " !";
		}
		input = input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
		return "Hello, " + input;
	}
}
