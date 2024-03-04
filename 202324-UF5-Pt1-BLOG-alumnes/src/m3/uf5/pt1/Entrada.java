package m3.uf5.pt1;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

public class Entrada extends Publicacio implements Comparable<Entrada>,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	public static final String SEPARADOR = "|";
	public static final String NOT_PROVIDED = "NA";
	private String titol;
	private Stack<Comentari> comentaris;
	
	public Entrada() {
	    // Constructor sin argumentos
	}

	public Entrada(Usuari usuari, String titol, String text) {
		super(usuari, text);
		this.titol = titol;
		this.comentaris = new Stack<>();
	}

	public void afegirComentari(Usuari usuari, String text, int valoracio) {
		Comentari comentari = new Comentari(usuari, text, valoracio);
		comentaris.push(comentari);
	}

	public String valoracioMitjaEntrada() {
	    if (comentaris.isEmpty()) {
	        return NOT_PROVIDED;
	    }

	    double sumaValoracions = 0;
	    Iterator<Comentari> iterator = comentaris.iterator();
	    while (iterator.hasNext()) {
	        sumaValoracions += iterator.next().getValoracio();
	    }

	    double mitjaValoracio = sumaValoracions / comentaris.size();
	    return String.format("%.1f", mitjaValoracio);
	}

	public int totalValoracionsPerValor(int valor) {
	    int totalValoracions = 0;
	    Iterator<Comentari> iterator = comentaris.iterator();
	    while (iterator.hasNext()) {
	        Comentari comentari = iterator.next();
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
	    
	    String tituloCentrado = StringUtils.center(titol, width);

	    String separacion = StringUtils.center(StringUtils.repeat("-", titol.length()), width);

	    sb.append(tituloCentrado).append("\n");
	    sb.append(separacion).append("\n\n");

	    String[] lineasTexto = WordUtils.wrap(text, width ).split(System.lineSeparator());
	    for (String linea : lineasTexto) {
	        sb.append(linea).append("\n");
	    }
	    return sb.toString();
	}


    @Override
    public int compareTo(Entrada otraEntrada) {
        int resultado = this.data.compareTo(otraEntrada.data);
        if (resultado == 0) {
            resultado = this.titol.compareTo(otraEntrada.titol);
        }
        return resultado;
    }

	@Override
	public int hashCode() {
		return Objects.hash(titol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(titol, other.titol);
	}

	public Stack<Comentari> getComentaris() {
		return comentaris;
	}

	public void setComentaris(Stack<Comentari> comentaris) {
		this.comentaris = comentaris;
	}


}