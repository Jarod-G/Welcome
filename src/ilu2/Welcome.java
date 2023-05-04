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
		int upperNumber = numberUpper(noms);
		String[] nomsUpper = splitUpper(noms,upperNumber), nomsLower = splitLower(noms,upperNumber);

		if(nomsUpper.length == 0){
			return nomsLowerCase(nomsLower);
		}
		return nomsLowerCase(nomsLower) + "." + nomsUpperCase(nomsUpper) + " !";
	}
	
	
	public static String nomsLowerCase(String[] noms) {
		StringBuilder sb = new StringBuilder("Hello");
		for(int i = 0; i < noms.length; i++) {
				noms[i] = noms[i].trim();
				if(i == noms.length-1 && noms.length > 1) {
					sb.append(" and " + noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase());
				}else {
					sb.append(", ").append(noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase());
				}
		}
		return sb.toString();
	}
	
	
	public static String nomsUpperCase(String[] noms) {
		StringBuilder sb = new StringBuilder(" AND HELLO");
		for(int i = 0; i < noms.length; i++) {
				noms[i] = noms[i].trim();
				if(i == noms.length-1 && noms.length > 1) {
					sb.append(" AND " + noms[i].toUpperCase());
				}else {
					sb.append(", " + noms[i].toUpperCase());
				}
		}
		return sb.toString();
	}
	
	
	public static String[] splitUpper(String[] noms, int upperNumber) {
		String[] upperArray = new String[upperNumber];
		int indiceUpper = 0;
		for(int i = 0; i < noms.length; i++) {
			noms[i] = noms[i].trim();
			if(noms[i].equals(noms[i].toUpperCase()))  {
				upperArray[indiceUpper] = noms[i];
				indiceUpper++;
			}
		}
		return upperArray;
	}
	
	
	public static String[] splitLower(String[] noms, int upperNumber) {
		String[] lowerArray = new String[noms.length - upperNumber];
		int indiceLower = 0;
		for(int i = 0; i < noms.length; i++) {
			noms[i] = noms[i].trim();
			if(!(noms[i].equals(noms[i].toUpperCase())))  {
				lowerArray[indiceLower] = noms[i];
				indiceLower++;
			}
		}
		return lowerArray;
	}
	
	
	public static int numberUpper(String[] noms) {
		int number = 0;
		for(int i = 0; i < noms.length; i++) {
			noms[i] = noms[i].trim();
			if(noms[i].equals(noms[i].toUpperCase()))  { 
				number++;
			}
		}
		return number;
	}
	
}
