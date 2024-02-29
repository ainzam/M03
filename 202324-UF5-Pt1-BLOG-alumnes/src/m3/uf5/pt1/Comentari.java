package m3.uf5.pt1;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Comentari extends Publicacio {

	public static final int IDENT_COMMENT = 5;
	public static final int IDENT_INC = 2;
	private static Map<Integer, String> valoracions = new TreeMap<>();

	static {
		valoracions.put(0, "0-Stars");
		valoracions.put(1, "1-Star");
		valoracions.put(2, "2-Stars");
		valoracions.put(3, "3-Stars");
	}
	private int valoracio;

	public Comentari(Usuari usuari, String text, int valoracio) {
		super(usuari, text);
		if (!valoracions.containsKey(valoracio)) {
			throw new IllegalArgumentException("Valoració incorrecta: " + valoracio);
		}
		this.setValoracio(valoracio);
	}

	@Override
	public String imprimirPublicacio(String ident, int width) {
	    StringBuilder sb = new StringBuilder();
	    sb.append(ident).append(getText()).append("\n");
	    sb.append(ident).append("Valoració: ").append(Comentari.getTextValoracio(getValoracio())).append("\n");
	    return sb.toString();
	}

	public static boolean containsValoracio(int key) {
		return valoracions.containsKey(key);
	}

	public static String getTextValoracio(int key) {
		return valoracions.get(key);
	}

	public static Set<Integer> getValoracions() {
		return valoracions.keySet();
	}

	public int getValoracio() {
		return valoracio;
	}

	public void setValoracio(int valoracio) {
		this.valoracio = valoracio;
	}

}
