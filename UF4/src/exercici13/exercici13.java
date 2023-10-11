package exercici13;

import java.util.Scanner;

public class exercici13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] vectorCadenes = new String[10];

		for (int i = 0; i < 10; i++) {
			System.out.print("Introdueix una cadena de text: ");
			vectorCadenes[i] = sc.nextLine();
		}

		String cadenaMesLlarga = "";
		int longitudMaxima = 0;

		for (int i = 0; i < 10; i++) {
			if (vectorCadenes[i].length() > longitudMaxima) {
				cadenaMesLlarga = vectorCadenes[i];
				longitudMaxima = vectorCadenes[i].length();
			}
		}

		System.out.println("La cadena més llarga és: " + cadenaMesLlarga);
		System.out.println("La longitud de la cadena més llarga és: " + longitudMaxima);

		sc.close();
	}
}