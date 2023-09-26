package exercici12;

import java.util.Scanner;

public class exercici12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce la longitud del vector: ");
		int longitud = sc.nextInt();

		int[] vector = new int[longitud];

		System.out.println("Introduce los elementos del vector:");
		for (int i = 0; i < longitud; i++) {

			vector[i] = sc.nextInt();
		}

		int pares = 0;
		int impares = 0;

		for (int i = 0; i < longitud; i++) {
			if (vector[i] % 2 == 0) {
				pares++;
			} else {
				impares++;
			}
		}

		System.out.println("Número de números pares: " + pares);
		System.out.println("Número de números impares: " + impares);

		sc.close();
	}
}