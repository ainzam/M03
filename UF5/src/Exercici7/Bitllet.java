package Exercici7;

public abstract class Bitllet implements Comparable<Bitllet> {

	protected int importe;
	protected String color;

	public Bitllet(int importe, String color) {
		this.importe = importe;
		this.color = color;
	}

	public abstract boolean esDeCinc();

	public abstract boolean esDeDeu();

	public abstract boolean esDeVint();

	public String getColor() {
		return color;
	}

	@Override
	public int compareTo(Bitllet other) {
		return Integer.compare(other.importe, this.importe); // Ordenar de major a menor
	}
}