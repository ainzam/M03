package Exercici1;

import java.util.Arrays;

public class Ex1 {
	public static void main(String[] args) {
		String[] dades = { "hola", "adeu", "un dos tres", "tot tot tothom" };

		String[] mesdades = { "1", "12", "123" };

		dades = Arrays.copyOf(dades, dades.length + mesdades.length);

		System.arraycopy(mesdades, 0, dades, dades.length - mesdades.length, mesdades.length);

		dades[2] = "olele olala";

		System.out.println("Tamaño del vector: " + dades.length);

		System.out.println("contiene adeu?: " + Arrays.asList(dades).contains("adeu"));

		System.out.println("contiene not found?: " + Arrays.asList(dades).contains("not found"));

		System.out.println("elemento posición 5: " + dades[5]);

	}
}
