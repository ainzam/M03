package m3.uf5.pt1;

import java.util.Collection;

public class Entrada extends Publicacio{
	
	public static final String SEPARADOR = "|";
	public static final String NOT_PROVIDED = "NA";
	private String titol;
	private Collection<Comentari> comentaris;
	
	public Entrada(Usuari usuari,String titol, String text) {
		super(usuari,text);
		this.titol = titol;
	}
	
	public void afegirComentari(Usuari usuari,String text, int valoracio) {
		//TODO 
	}
	
	public String valoracioMitjaEntrada() {
		//TODO 
		return null;
	}
	
	public int totalValoracionPerValor(int valor) {
		//TODO 
		return 0;
	}
	
	public String imprimirPublicacio(String ident, int width) {
		//TODO 
		return null;
	}
	
	
}