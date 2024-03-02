package m3.uf5.pt1;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

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
	    String comentario = String.format("%s.- \"%s\"", getUsuario().getNick(), getText());

	    String[] lineas = WordUtils.wrap(comentario, width).split(System.lineSeparator());

	    StringBuilder sb = new StringBuilder();
	    for (String linea : lineas) {
	        String totalCom = StringUtils.leftPad(linea, width + Blog.GAP);
	        sb.append(StringUtils.repeat(" ", Blog.AMPLE_LEFT) + Entrada.SEPARADOR + totalCom).append("\n");
	    }
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String fechaFormateada = dateFormat.format(getData());

	    String valoracion = String.format("%s, valoració: %s", fechaFormateada, getTextValoracio(getValoracio()));

	    String valoracionAlineada = StringUtils.leftPad(valoracion, width + Blog.GAP);
	    
	    sb.append(StringUtils.repeat(" ", Blog.AMPLE_LEFT) + Entrada.SEPARADOR + valoracionAlineada).append("\n");
	    
	    String separador = StringUtils.repeat(" ", Blog.AMPLE_LEFT) + Entrada.SEPARADOR + StringUtils.leftPad(StringUtils.repeat("-", 5), width + Blog.GAP);
	    sb.append(separador).append("\n");

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
