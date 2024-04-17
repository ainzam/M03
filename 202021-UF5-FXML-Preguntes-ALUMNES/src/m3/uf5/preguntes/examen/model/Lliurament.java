package m3.uf5.preguntes.examen.model;

import javax.persistence.Entity;

@Entity
public class Lliurament {
	private double nota;
	private Estudiant estudiant;
	private Examen examen;

	public Lliurament(Estudiant estudiant, Examen examen) throws Excepcio {
		if (estudiant == null) {
			throw new Excepcio("Lliurament", "Cal indicar l'estudiant per crear el lliurament");
		}
		this.estudiant = estudiant;
		if (examen == null) {
			throw new Excepcio("Lliurament", "Cal indicar l'examen per crear el lliurament");
		}
		this.examen = examen;
		this.nota = 0;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) throws Excepcio {
		this.examen.validarNota(nota);
		this.nota = nota;
	}

	public Estudiant getEstudiant() {
		return estudiant;
	}

	public void setEstudiant(Estudiant estudiant) throws Excepcio {
		if (estudiant == null) {
			throw new Excepcio("Lliurament", "Cal indicar l'estudiant per crear el lliurament");
		}
		this.estudiant = estudiant;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) throws Excepcio {
		if (examen == null) {
			throw new Excepcio("Lliurament", "Cal indicar l'examen per crear el lliurament");
		}
		this.examen = examen;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return this.estudiant.equals(((Lliurament) obj).getEstudiant());
	}

}
