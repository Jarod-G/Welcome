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
		int indiceNomMaj = -1;
		for(int i = 0; i < noms.length; i++) {
			noms[i] = noms[i].trim();
			if(noms[i].equals(noms[i].toUpperCase())) {
				indiceNomMaj = i;
			}else {
				sb.append(", ");
		        sb.append(noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase()); 
			}
			
		}
		if(indiceNomMaj != -1) {
			sb.append(". AND HELLO, " + noms[indiceNomMaj] + " !");
		}
		return sb.toString();
	}
}
