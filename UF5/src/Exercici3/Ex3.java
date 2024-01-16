package Exercici3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Set<Punt> punts = new HashSet<>();

		System.out.println("Introdueix les coordenades dels punts (x, y):");
		while (true) {
			System.out.print("x: ");
			int x = sc.nextInt();
			System.out.print("y: ");
			int y = sc.nextInt();

			// Comprovem si el punt ja existeix
			if (!punts.contains(new Punt(x, y))) {
				punts.add(new Punt(x, y));
			}

			System.out.print("Vols continuar introduint punts? (Fi per acabar): ");
			String resposta = sc.next();
			if (resposta.equals("Fi")) {
				break;
			}
		}

		System.out.println("Els punts introduïts són:");
		for (Punt punt : punts) {
			System.out.println(punt);
		}
	}
}

class Punt {

	private int x;
	private int y;

	public Punt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
