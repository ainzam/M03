package m3.uf4.pt1.fitxers;

import java.util.Date;

public abstract class ElementSistema implements Imprimible {
	private static int currentId = 1;
	protected int id;
	protected String nom;
	protected Date creat;
	protected Directori parent;

	public ElementSistema(String nom) {
		this.nom = (nom != null) ? nom : "";
		this.creat = new Date();
		this.id = currentId++;
	}

	public ElementSistema(String nom, Date creat) {
		this.nom = (nom != null) ? nom : "";
		this.creat = (creat != null) ? creat : new Date();
		this.id = currentId++;
	}

	public int getDepth() {
		return (parent != null) ? parent.getDepth() + 1 : 0;
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
