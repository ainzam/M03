package m3.uf5.pt1;

import java.util.Date;

public abstract class Publicacio {

	public Usuari getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuari usuario) {
		this.usuario = usuario;
	}

	protected Usuari usuario;
	protected String text;

	protected Date data;

	public Publicacio(Usuari usuari, String text) {
		this.usuario = usuari;
		this.text = text;
		this.data = new Date();

		usuari.afegirPublicacio(this);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public abstract String imprimirPublicacio(String ident, int width);
}
