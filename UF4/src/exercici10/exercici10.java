package exercici10;

import java.util.Scanner;

public class exercici10 {
	private static Scanner leer;

	public static void main(String[] args) {

		leer = new Scanner(System.in);

		int[] vector = new int[10];

		System.out.println("Introduce números. El cero para salir");

		for (int i = 0; i < 10; i++) {
			vector[i] = leer.nextInt();
		}

		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = i + 1; j < vector.length; j++) {
				if (vector[i] == vector[j]) {
					System.out.println("Hay numeros repetidos");
					return;
				}
			}

		}

	}

}
