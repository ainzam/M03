package Exercici6;

public class Triangle extends Figura {

	private int alcada;
	private int base;

	public int getAlcada() {
		return alcada;
	}

	public void setAlcada(int alcada) {
		this.alcada = alcada;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	@Override
	public int numCostats() {
		return 3;
	};

	public int area() {
		return (this.base * this.alcada) / 2;
	}

}
