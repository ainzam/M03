package exercici18;

import java.util.Scanner;

public class Exercici18 {

	public static void main(String[] args) {
		System.out.println("Escriure una frase:");

		Scanner scanner = new Scanner(System.in);

		String text = "";

		int opcio = 0;

		while (opcio != 5) {
			System.out.println("Menú:");
			System.out.println("1. Introduir un text");
			System.out.println("2. Mostrar la longitud del text");
			System.out.println("3. Entrar un altre text i indicar si són iguals");
			System.out.println("4. Entrar dos enters (inici i fi) i mostrar el tros del text corresponent");
			System.out.println("5. Sortir");
			System.out.print("Selecciona una opció: ");

			opcio = scanner.nextInt();
			scanner.nextLine();

			switch (opcio) {
			case 1:
				text = scanner.nextLine();
				break;
			case 2:
				mostrarLongitud(text);
				break;
			case 3:
				scanner.nextLine(); // Consumim la nova línia deixada per nextInt
				System.out.print("Entra un altre text: ");
				String text2 = scanner.nextLine();
				compararTexts(text, text2);
				break;
			case 4:
				scanner.nextLine(); // Consumim la nova línia deixada per nextInt
				System.out.print("Entra l'inici del tros: ");
				int inici = scanner.nextInt();
				System.out.print("Entra el final del tros: ");
				int fi = scanner.nextInt();
				mostrarTros(text, inici, fi);
				break;
			case 5:
				System.out.println("Fins aviat!");
				scanner.close();
				break;
			default:
				System.out.println("Opció no vàlida. Torna a intentar.");
				break;
			}
		}
	}

	public static void mostrarLongitud(String text) {
		System.out.println("La longitud del text és: " + text.length());
	}

	public static void compararTexts(String text1, String text2) {
		if (text1.equals(text2)) {
			System.out.println("Els textos són iguals.");
		} else {
			System.out.println("Els textos no són iguals.");
		}
	}

	public static void mostrarTros(String text, int inici, int fi) {
		if (inici >= 0 && fi <= text.length() && inici <= fi) {
			String tros = text.substring(inici, fi);
			System.out.println("El tros del text és: " + tros);
		} else {
			System.out.println("Índexs no vàlids. Torna a intentar.");
		}
	}
}
