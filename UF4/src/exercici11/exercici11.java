package exercici11;

import java.util.Scanner;

public class exercici11 {
	private static Scanner leer;

	public static void main(String[] args) {

		leer = new Scanner(System.in);

		int[] vector = new int[10];

		System.out.println("Introduce números. El cero para salir");

		for (int i = 0; i < 10; i++) {
			vector[i] = leer.nextInt();
		}
		int i = 0;

		if (vector[0] < vector[1]) {

			while (i <= vector.length && vector[i] < vector[i + 1]) {
				i++;
			}

			if (vector[i] > vector[i + 1]) {
				System.out.println("NO estan ordenats");
			} else {
				System.out.println("SI estan ordenats");
			}
		} else {
			while (i <= vector.length && vector[i] > vector[i + 1]) {
				i++;
			}

			if (vector[i] < vector[i + 1]) {
				System.out.println("NO estan ordenats");
			} else {
				System.out.println("SI estan ordenats");
			}
		}

	}
}
