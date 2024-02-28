package m3.uf5.pt1;

import java.util.Stack;

public class Entrada extends Publicacio {

	public static final String SEPARADOR = "|";
	public static final String NOT_PROVIDED = "NA";
	private String titol;
	private Stack<Comentari> comentaris;

	public Entrada(Usuari usuari, String titol, String text) {
		super(usuari, text);
		this.titol = titol;
		this.comentaris = new Stack();
	}

	public void afegirComentari(Usuari usuari, String text, int valoracio) {
		Comentari comentari = new Comentari(usuari, text, valoracio);
		comentaris.push(comentari);
	}

	public String valoracioMitjaEntrada() {

		double sumaValoracions = 0;
		for (Comentari comentari : comentaris) {
			sumaValoracions += comentari.getValoracio();
		}
		double mitjaValoracio = sumaValoracions / comentaris.size();
		return String.format("%.1f", mitjaValoracio);

	}

	public int totalValoracionsPerValor(int valor) {
		int totalValoracions = 0;
		for (Comentari comentari : comentaris) {
			if (comentari.getValoracio() == valor) {
				totalValoracions++;
			}
		}
		return totalValoracions;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	@Override
	public String imprimirPublicacio(String ident, int width) {
		// TODO
		return null;
	}

}