package Exercici4;

import java.util.LinkedList;

public class Cua {

	private LinkedList<String> elements;

	public Cua() {
		this.elements = new LinkedList<>();
	}

	public void afegir(String element) {
		this.elements.addLast(element);
	}

	public String treure() {
		if (this.elements.isEmpty()) {
			return null;
		}
		return this.elements.removeFirst();
	}

	public boolean estàBuida() {
		return this.elements.isEmpty();
	}

	public static void main(String[] args) {
		Cua cua = new Cua();

		// Afegim elements a la cua
		cua.afegir("1");
		cua.afegir("2");
		cua.afegir("3");
		cua.afegir("4");
		cua.afegir("5");
		cua.afegir("6");

		// Treuem 3 elements de la cua
		String element1 = cua.treure();
		String element2 = cua.treure();
		String element3 = cua.treure();

		// Imprimim els elements extrets
		System.out.println("Els 3 primers elements extrets són:");
		System.out.println(element1);
		System.out.println(element2);
		System.out.println(element3);

		// Afegim més elements a la cua
		cua.afegir("A");
		cua.afegir("B");
		cua.afegir("C");

		// Treuem 2 elements de la cua
		String element4 = cua.treure();
		String element5 = cua.treure();

		// Imprimim els elements extrets
		System.out.println("\nEls 2 últims elements extrets són:");
		System.out.println(element4);
		System.out.println(element5);

		System.out.println("\nLa cua al final és:");
		for (String element : cua.elements) {
			System.out.println(element);
		}

	}
}
