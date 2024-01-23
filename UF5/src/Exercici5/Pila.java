package Exercici5;

import java.util.LinkedList;

public class Pila {

	private LinkedList<String> elements;

	public Pila() {
		this.elements = new LinkedList<>();
	}

	public void afegir(String element) {
		this.elements.addFirst(element);
	}

	public String treure() {
		if (this.elements.isEmpty()) {
			return null;
		}
		return this.elements.removeLast();
	}

	public boolean estàBuida() {
		return this.elements.isEmpty();
	}

	public static void main(String[] args) {
		Pila pila = new Pila();

		// Afegim elements a la pila
		pila.afegir("1");
		pila.afegir("2");
		pila.afegir("3");
		pila.afegir("4");
		pila.afegir("5");
		pila.afegir("6");

		// Treuem 3 elements de la pila
		String element1 = pila.treure();
		String element2 = pila.treure();
		String element3 = pila.treure();

		// Imprimim els elements extrets
		System.out.println("Els 3 primers elements extrets són:");
		System.out.println(element1);
		System.out.println(element2);
		System.out.println(element3);

		// Afegim més elements a la pila
		pila.afegir("A");
		pila.afegir("B");
		pila.afegir("C");

		// Treuem 2 elements de la pila
		String element4 = pila.treure();
		String element5 = pila.treure();

		// Imprimim els elements extrets
		System.out.println("\nEls 2 últims elements extrets són:");
		System.out.println(element4);
		System.out.println(element5);
	}
}