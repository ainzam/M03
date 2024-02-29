package m3.uf5.pt1;

import java.util.Stack;

import org.apache.commons.text.WordUtils;

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
	    StringBuilder sb = new StringBuilder();
	    sb.append(ident).append(getData()).append(" | ").append(usuario.getNick()).append("\n");
	    sb.append(ident).append(SEPARADOR.repeat(width / 2)).append("\n");
	    String[] lines = WordUtils.wrap(getTitol(), width).split(System.lineSeparator());
	    for (String line : lines) {
	        sb.append(ident).append(line).append("\n");
	    }
	    for (Comentari comentari : comentaris) {
	        sb.append(comentari.imprimirPublicacio(ident + "  ", width)).append("\n");
	    }
	    sb.append(ident).append(SEPARADOR.repeat(width / 2)).append("\n");
	    sb.append(ident).append("Mitjana de valoracions: ").append(valoracioMitjaEntrada()).append("\n");
	    return sb.toString();
	}


}