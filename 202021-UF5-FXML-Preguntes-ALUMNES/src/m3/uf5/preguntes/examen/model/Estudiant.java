package m3.uf5.preguntes.examen.model;

import javax.persistence.Entity;

@Entity
public class Estudiant implements Comparable<Estudiant> {
	public static final int MIN_EDAT = 18;
	private String nom;
	private String cognoms;
	private int edat;

	public Estudiant(String nom, String cognoms, int edat) throws Excepcio {
		super();
		// Exemple validació
		if (nom == null || "".equals(nom.trim())) {
			throw new Excepcio("Estudiant", "Cal indicar el nom de l'estudiant");
		}
		this.nom = nom;
		if (cognoms == null || "".equals(cognoms.trim())) {
			throw new Excepcio("Estudiant", "Cal indicar els cognoms de l'estudiant");
		}
		this.cognoms = cognoms;
		if (edat < MIN_EDAT) {
			throw new Excepcio("Estudiant", "L'edat mínima dels estudiants és: " + MIN_EDAT);
		}
		this.edat = edat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws Excepcio {
		if (nom == null || "".equals(nom.trim())) {
			throw new Excepcio("Estudiant", "Cal indicar el nom de l'estudiant");
		}
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) throws Excepcio {
		if (cognoms == null || "".equals(cognoms.trim())) {
			throw new Excepcio("Estudiant", "Cal indicar els cognoms de l'estudiant");
		}
		this.cognoms = cognoms;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) throws Excepcio {
		if (edat < MIN_EDAT) {
			throw new Excepcio("Estudiant", "L'edat mínima dels estudiants és: " + MIN_EDAT);
		}
		this.edat = edat;
	}

	public String getCognomsNom() {
		return this.cognoms + ", " + this.nom;
	}

	@Override
	public int compareTo(Estudiant o) {
		return this.getCognomsNom().compareTo(o.getCognomsNom());
	}
}
