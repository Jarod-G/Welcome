package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		if(input == null || input.trim().length() == 0 ) {
			return "Hello, my friend";
		}
		String[] noms = input.split(",");
		int upperNumber = numberUpper(noms);
		String[] nomsUpper = splitUpper(noms,upperNumber), nomsLower = splitLower(noms,upperNumber);
		
		if(nomsLower.length == 0) {
			return nomsUpperCase(nomsUpper) + " !";
		}
		if(nomsUpper.length == 0){
			return nomsLowerCase(nomsLower);
		}
		if(nomsLower.length != 0 && nomsUpper.length == 1) {
			return nomsLowerCase(nomsLower) + "." + " AND " + nomsUpperCase(nomsUpper) + " !";
		}
		return nomsLowerCase(nomsLower) + "."  + nomsUpperCase(nomsUpper) + " !";
	}
	
	
	private static String nomsLowerCase(String[] noms) {
		StringBuilder sb = new StringBuilder("Hello");
		for(int i = 0; i < noms.length; i++) {
				noms[i] = noms[i].trim();
				if(noms[i].contains("yoda")) {
					sb = yodaPresentLower(noms);
					break;
				}
				if(i == noms.length-1 && noms.length > 1) {
					sb.append(" and " + noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase());
				}else {
					sb.append(", ").append(noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase());
				}
		}
		return sb.toString();
	}
	
	
	private static StringBuilder yodaPresentLower(String[] noms) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < noms.length; i++) {
				noms[i] = noms[i].trim();
				if(i == noms.length-1 && noms.length > 1) {
					sb.append("and " + noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase()).append(", ");
				}else {
					sb.append(noms[i].substring(0, 1).toUpperCase()).append(noms[i].substring(1).toLowerCase()).append(", ");
				}
		}
		sb.append("Hello");
		return sb;
	}
	
	
	private static String nomsUpperCase(String[] noms) {
		StringBuilder sb = new StringBuilder();
		if(noms.length > 1) {
			sb.append(" AND HELLO");
		}else {
			sb.append("HELLO");
		}
		for(int i = 0; i < noms.length; i++) {
				noms[i] = noms[i].trim();
				if(noms[i].contains("YODA")) {
					sb = yodaPresentUpper(noms);
					break;
				}
				if(i == noms.length-1 && noms.length > 1) {
					sb.append(" AND " + noms[i]);
				}else {
					sb.append(", " + noms[i]);
				}
		}
		return sb.toString();
	}
	
	
	private static StringBuilder yodaPresentUpper(String[] noms) {
		StringBuilder sb = new StringBuilder();
		if(noms.length > 1) {
			sb.append(" AND ");
		}
		for(int i = 0; i < noms.length; i++) {
				noms[i] = noms[i].trim();
				if(i == noms.length-1 && noms.length > 1) {
					sb.append(" AND " + noms[i]);
				}else {
					sb.append(noms[i]);
				}
		}
		sb.append(", HELLO");
		return sb;
	}
	
	
	private static String[] splitUpper(String[] noms, int upperNumber) {
		String[] upperArray = new String[upperNumber];
		int indiceUpper = 0;
		for(int i = 0; i < noms.length; i++) {
			noms[i] = noms[i].trim();
			if(noms[i].equals(noms[i].toUpperCase()))  {
				upperArray[indiceUpper] = noms[i].toUpperCase();
				indiceUpper++;
			}
		}
		upperArray = compteNomsAffichage(upperArray);
		return upperArray;
	}
	
	
	private static String[] splitLower(String[] noms, int upperNumber) {
		String[] lowerArray = new String[noms.length - upperNumber];
		int indiceLower = 0;
		for(int i = 0; i < noms.length; i++) {
			noms[i] = noms[i].trim();
			if(!(noms[i].equals(noms[i].toUpperCase())))  {
				lowerArray[indiceLower] = noms[i];
				indiceLower++;
			}
		}
		lowerArray = compteNomsAffichage(lowerArray);
		return lowerArray;
	}
	
	
	private static int numberUpper(String[] noms) {
		int number = 0;
		for(int i = 0; i < noms.length; i++) {
			noms[i] = noms[i].trim();
			if(noms[i].equals(noms[i].toUpperCase()))  { 
				number++;
			}
		}
		return number;
	}
	
	
	private static String[] compteNomsAffichage(String[] noms) {
		String[] distinctsNoms = nomsDistincts(noms);
		for(int i = 0; i < distinctsNoms.length; i++) {
			int nbNoms = compteNoms(noms,distinctsNoms[i]);
			if(nbNoms > 1) {
				distinctsNoms[i] = distinctsNoms[i]+" (x" + Integer.toString(nbNoms) + ")";
			}else {
				distinctsNoms[i] = distinctsNoms[i];
			}
		}
		return distinctsNoms;
	}

	
	private static String[] nomsDistincts(String[] noms) {
		int nbNomsMultipleTotal = compteNomsTotal(noms);
		String[] distinctsNoms = new String[noms.length - nbNomsMultipleTotal];
		int indiceDistincts = 0;
		for(int i = 0; i < noms.length; i++) {
			boolean nomDist = true;
			for(int x = 0; x < distinctsNoms.length; x++) {
				if(distinctsNoms[x] != null && distinctsNoms[x].equals(noms[i])) {
					nomDist = false;
				}
			}
			if(nomDist == true) {
				distinctsNoms[indiceDistincts] = noms[i];
				indiceDistincts++;
			}
		}
		return distinctsNoms;
	}
	
	
	private static int compteNoms(String[] noms, String nom) {
		int nbNomsPresent = 1;
		for(int x = 0; x < noms.length; x++) {
			if(noms[x].equals(nom)) {
				nbNomsPresent++;
			}
		}
		return nbNomsPresent - 1;
	}
	
	
	public static int compteNomsTotal(String[] noms) {
	    int nbNomsMultiples = 0, nbOccurrencesMultiples = 0;;
	    for (int i = 0; i < noms.length; i++) {
	        for (int j = i + 1; j < noms.length; j++) {
	            if (noms[i].equals(noms[j])) {
	                nbNomsMultiples++;
	                break; // on passe à l'élément suivant dès qu'on a trouvé un nom multiple
	            }
	        }
	    }
	    for (int i = 0; i < noms.length; i++) {
	        for (int j = i + 1; j < noms.length; j++) {
	            if (noms[i].equals(noms[j])) {
	                nbOccurrencesMultiples++;
	                break; // on passe à l'élément suivant dès qu'on a compté une occurrence de nom multiple
	            }
	        }
	    }
	    return nbOccurrencesMultiples;
	}

}
