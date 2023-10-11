package figures;

public abstract class Figura {
	protected String nom;

	public abstract double calcularPerimetre();

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}