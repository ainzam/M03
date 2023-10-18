package figures.interfaces;

import java.awt.Color;

import figures.Punt;

interface InterfaceFigura {

	public double calcularPerimetre();
}

interface InterfaceDibuix {

	public void definirColor(Color c);
}

class Cercle implements InterfaceFigura, InterfaceDibuix {
	private int radi;
	private Punt centre;
	private Color c;

	@Override
	public double calcularPerimetre() {
		return 2 * 3.1416 * radi;
	}

	@Override
	public void definirColor(Color c) {
		this.c = c;
	}
}

class Quadrat implements InterfaceFigura, InterfaceDibuix {
	private int costat;
	private Color c;

	@Override
	public double calcularPerimetre() {
		return 4 * costat;
	}

	@Override
	public void definirColor(Color c) {
		this.c = c;
	}
}

public class Interfaces {
	public static void main(String[] args) {
		Quadrat q = new Quadrat();
		System.out.println(q.calcularPerimetre());
		q.definirColor(Color.BLACK);
	}
}