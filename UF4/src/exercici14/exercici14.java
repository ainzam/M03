package exercici14;

public class exercici14 {
	public static void main(String[] args) {
		int[] vectorEnters = { 1, 2, 3, 4, 5 }; // Exemple de vector d'enters

		// Crèiem un vector de Strings a partir del vector d'enters
		String[] vectorStrings  = convertirVectorEntersAStrings(vectorEnters);

		// Mostrem el vector de Strings
		for (String s : vectorStrings) {
			System.out.println(s);
		}
	}

	public static String[] convertirVectorEntersAStrings(int[] vectorEnters) {
		String[] vectorStrings = new String[vectorEnters.length];

		for (int i = 0; i < vectorEnters.length; i++) {
			// Utilitzem String.valueOf() per convertir l'enter a String
			vectorStrings[i] = String.valueOf(vectorEnters[i]);
		}

		return vectorStrings;
	}
}