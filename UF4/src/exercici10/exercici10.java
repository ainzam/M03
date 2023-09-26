package exercici10;

import java.util.Scanner;

public class exercici10 {
	private static Scanner leer;

	public static void main(String[] args) {

		leer = new Scanner(System.in);

		int[] vector = new int[10];

		boolean hay = false;

		System.out.println("Introduce números. El cero para salir");

		for (int i = 0; i < 10; i++) {
			vector[i] = leer.nextInt();
		}

		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (vector[i] == vector[j]) {
					hay = true;
				}
			}

		}
		if (hay) {
			System.out.println("Hay numeros repetidos");
		} else {
			System.out.println("NO hay numeros repetidos");
		}

	}

}
