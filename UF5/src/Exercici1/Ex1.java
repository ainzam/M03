package Exercici1;

import java.util.Arrays;
import java.util.LinkedList;

public class Ex1 {
	public static void main(String[] args) {
		// Crea un Vector de String a partir del vector següent
		String[] dades = { "hola", "adeu", "un dos tres", "tot tot tothom" };

		// Afegeix les següents dades totes de cop
		String[] mesdades = { "1", "12", "123" };
		int midaOriginal = dades.length;
		dades = Arrays.copyOf(dades, midaOriginal + mesdades.length);
		System.arraycopy(mesdades, 0, dades, midaOriginal, mesdades.length);

		// Afegeix el text “olele olala” a la posició 2
		dades[2] = "olele olala";

		// Mostra:
		// La mida del vector
		System.out.println("La mida del vector és: " + dades.length);

		// Si conté l'element “adeu”
		if (Arrays.asList(dades).contains("adeu")) {
			System.out.println("El vector conté l'element “adeu”");
		} else {
			System.out.println("El vector no conté l'element “adeu”");
		}

		// Si conté l'element “not found”
		if (Arrays.asList(dades).contains("not found")) {
			System.out.println("El vector conté l'element “not found”");
		} else {
			System.out.println("El vector no conté l'element “not found”");
		}

		// L'element de la posició 5
		if (dades.length >= 5) {
			System.out.println("L'element de la posició 5 és: " + dades[5]);
		} else {
			System.out.println("No existeix un element a la posició 5");
		}

		// Esborra l'element de la posició 0
		dades = Arrays.copyOfRange(dades, 1, dades.length);

		// Esborra “hola”
		dades = Arrays.stream(dades).filter(s -> !s.equals("hola")).toArray(String[]::new);

		// Converteix els elements de la posició 3 fins al final en una llista enllaçada
		// (LinkedList)
		LinkedList<String> llistaEnllaçada = new LinkedList<>();
		for (int i = 3; i < dades.length; i++) {
			llistaEnllaçada.add(dades[i]);
		}

		// Mostra el contingut de la llista enllaçada
		System.out.println("El contingut de la llista enllaçada és:");
		for (String element : llistaEnllaçada) {
			System.out.println(element);
		}
	}
}
