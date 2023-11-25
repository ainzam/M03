package m3.uf4.pt1.fitxers;

import java.util.Date;

public abstract class ElementSistema implements Imprimible {
	private static int currentId = 1;
	protected int id;
	protected String nom;
	protected Date creat;
	protected Directori parent;

	public ElementSistema(String nom) {
		if(nom != null) {
			this.nom = nom;
		}else {
			this.nom = "";
		}
		this.creat = new Date();
		this.id = currentId++;
	}

	public ElementSistema(String nom, Date creat) {
		if(nom != null) {
			this.nom = nom;
		}else {
			this.nom = "";
		}
		if(creat != null) {
			this.creat = creat;
		}else {
			this.creat = new Date();
		}
		this.id = currentId++;
	}

	public int getDepth() {
		int depth;
		if(parent != null) {
			depth = parent.getDepth() + 1;
			return depth;
		}else {
			return 0;
		}
	}

	public String getPath() {
        if (parent != null) {
            return parent.getPath() + "/" + nom;
        } else {
            return "/" + nom;
        }
	}

	public abstract int getMida();
	
	public int getId() {
	    return id;
	}

	public String getNom() {
		return nom;
	}
}
