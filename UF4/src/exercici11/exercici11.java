package exercici11;

import java.util.Scanner;

public class exercici11 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce la longitud del vector: ");
		int n = sc.nextInt();

		int[] vector = new int[n];

		System.out.println("Introduce los valores del vector:");
		for (int i = 0; i < n; i++) {
			vector[i] = sc.nextInt();
		}

		boolean Asc = true;
		boolean Desc = true;

		for (int i = 0; i < n - 1; i++) {
			if (vector[i] > vector[i + 1]) {
				Asc = false;
				break;
			}
		}

		for (int i = 0; i < n - 1; i++) {
			if (vector[i] < vector[i + 1]) {
				Desc = false;
				break;
			}
		}

		if (Asc) {
			System.out.println("El vector está ordenado en forma ascendente.");
		} else if (Desc) {
			System.out.println("El vector está ordenado en forma descendente.");
		} else {
			System.out.println("El vector no está ordenado.");
		}

		sc.close();
	}
}