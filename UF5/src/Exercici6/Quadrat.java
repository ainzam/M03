package Exercici6;

public class Quadrat extends Figura {

	private int costat;

	@Override
	public int numCostats() {
		return 4;
	}

	public int area() {
		return this.costat * this.costat;
	}

	public int getCostat() {
		return costat;
	}

	public void setCostat(int costat) {
		this.costat = costat;
	}
}
