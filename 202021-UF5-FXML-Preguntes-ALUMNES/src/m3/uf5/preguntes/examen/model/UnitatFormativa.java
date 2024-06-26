package m3.uf5.preguntes.examen.model;

import javax.persistence.Entity;

@Entity
public class UnitatFormativa {
	private String cicle;
	private String modul;
	private int num;
	private String titol;
	private int hores;

	public UnitatFormativa(String cicle, String modul, int num, String titol, int hores) throws Excepcio {
		if (cicle == null || "".equals(cicle.trim())) {
			throw new Excepcio("UnitatFormativa", "Cal indicar el nom del Cicle Formatiu");
		}
		this.cicle = cicle;
		if (modul == null || "".equals(modul.trim())) {
			throw new Excepcio("UnitatFormativa", "Cal indicar el nom del Mòdul Professional");
		}
		this.modul = modul;
		if (num <= 0) {
			throw new Excepcio("UnitatFormativa", "El número d'unitat formativa hauria de ser 1,2,3...: " + num);
		}
		this.num = num;
		if (titol == null || "".equals(titol)) {
			throw new Excepcio("UnitatFormativa", "Cal indicar el titol de la Unitat Formativa");
		}
		this.titol = titol;
		if (hores <= 0) {
			throw new Excepcio("UnitatFormativa", "El nombre d'hores de la Unitat Formativa és incorrecte: " + hores);
		}
		this.hores = hores;
	}

	public String getCicle() {
		return cicle;
	}

	public void setCicle(String cicle) throws Excepcio {
		if (cicle == null || "".equals(cicle.trim())) {
			throw new Excepcio("UnitatFormativa", "Cal indicar el nom del Cicle Formatiu");
		}
		this.cicle = cicle;
	}

	public String getModul() {
		return modul;
	}

	public void setModul(String modul) throws Excepcio {
		if (modul == null || "".equals(modul.trim())) {
			throw new Excepcio("UnitatFormativa", "Cal indicar el nom del Mòdul Professional");
		}
		this.modul = modul;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) throws Excepcio {
		if (titol == null || "".equals(titol)) {
			throw new Excepcio("UnitatFormativa", "Cal indicar el titol de la Unitat Formativa");
		}
		this.titol = titol;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) throws Excepcio {
		if (num <= 0) {
			throw new Excepcio("UnitatFormativa", "El número d'unitat formativa hauria de ser 1,2,3...: " + num);
		}
		this.num = num;
	}

	public int getHores() {
		return hores;
	}

	public void setHores(int hores) throws Excepcio {
		if (hores <= 0) {
			throw new Excepcio("UnitatFormativa", "El nombre d'hores de la Unitat Formativa és incorrecte: " + hores);
		}
		this.hores = hores;
	}

	// Properties
	public String getTitolUf() {
		return "UF" + this.getNum() + ": " + this.getTitol();
	}

	public String getModulUf() {
		return this.cicle + " - " + this.getModul();
	}

	@Override
	public String toString() {
		return this.getModulUf() + ". " + getTitolUf();
	}
}
