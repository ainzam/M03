package m3.uf5.pt1;

import java.util.Date;

public abstract class Publicacio {

    protected Usuari usuario;
    protected String text;
    
    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	protected Date data;
    
    public Publicacio(Usuari usuari, String text) {
        this.usuario = usuari;
        this.text = text;
        this.data = new Date(); 
        
        usuari.afegirPublicacio(this);
    }
    
    public abstract String imprimirPublicacio(String ident, int width);
}
