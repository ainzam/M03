package figures;

public abstract class Figura {
	private String nom;

	public abstract double calcularPerimetre();

	public String getNom() {
		return this.nom;
	}

}