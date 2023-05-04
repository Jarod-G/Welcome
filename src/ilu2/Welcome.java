package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		if(input == null || input.trim().length() == 0 ) {
			return "Hello, my friend";
		}
		
		if(input.equals(input.toUpperCase())) {
			return "HELLO, " + input.toUpperCase() + " !";
		}
		String[] noms = input.split(",");
		return multipleNoms(noms);
	}
	
	
	public static String multipleNoms(String[] noms) {
		StringBuilder sb = new StringBuilder("Hello");
		for(int i = 0; i < noms.length; i++) {
			sb.append(", ");
			noms[i] = noms[i].trim();
	        sb.append(noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase()); 
		}
		return sb.toString();
	}
}
