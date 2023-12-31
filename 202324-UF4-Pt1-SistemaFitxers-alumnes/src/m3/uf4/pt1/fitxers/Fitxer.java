package m3.uf4.pt1.fitxers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

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

	@Override
	public String imprimir(char unitats) {
		String sizeFormatted = SistemaFitxers.formatSize(unitats, mida);
		String dateFormatted = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(creat);
		String trimmedNom = StringUtils.substring(nom, 0, AMPLE_NOM - 3);

		if (nom.length() > AMPLE_NOM) {
			trimmedNom += "...";
		}

		String idStr = String.valueOf(id);

		String gap = StringUtils.leftPad("", AMPLE_GAP);
		String formattedId = StringUtils.leftPad(idStr, AMPLE_IDENT * getDepth()).replace(' ', '.');
		String formattedType = "F";
		String formattedDate = StringUtils.leftPad(dateFormatted, AMPLE_DATA);
		String formattedSize = StringUtils.rightPad(sizeFormatted, AMPLE_MIDA);
		String formattedNom = StringUtils.rightPad(trimmedNom, AMPLE_NOM);

		return String.format("%s %s%s%s%s%s%s%s", formattedId, formattedType, gap, formattedDate, gap, formattedSize,
				gap, formattedNom);

	}
}
