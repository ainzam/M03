package Exercici6;

public abstract class Figura {
	protected int posicio_x;
	protected int posicio_y;

	public abstract int numCostats();

	public String getNom() {
		return this.getClass().getSimpleName();
	}

}
