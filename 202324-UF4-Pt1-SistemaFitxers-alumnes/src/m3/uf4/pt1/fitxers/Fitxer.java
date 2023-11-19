package m3.uf4.pt1.fitxers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fitxer extends ElementSistema {

	private int mida;

	public Fitxer(String nom, int mida) {
		super(nom);
		this.mida = mida;
	}

	public Fitxer(String nom, Date creat, int mida) {
		super(nom, creat);
		this.mida = mida;
	}

	@Override
	public int getMida() {
		return mida;
	}

	public String imprimir(char unitats) {
	    String sizeFormatted = SistemaFitxers.formatSize(unitats, mida);
	    return String.format("%d %s %s %s", id, sizeFormatted, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(creat), getPath());
	}
}
