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

	public String imprimir(char unitats) {
	    String sizeFormatted = SistemaFitxers.formatSize(unitats, mida);
	    String dateFormatted = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(creat);
	    
	    String idStr = String.valueOf(id);
	    
	    String gap = StringUtils.leftPad("",AMPLE_GAP);
	    String formattedId = StringUtils.leftPad(idStr, AMPLE_IDENT).replace(' ', '.');
	    String formattedType = "F";
	    String formattedDate = StringUtils.leftPad(dateFormatted, AMPLE_DATA);
	    String formattedSize = StringUtils.leftPad(sizeFormatted, AMPLE_MIDA);
	    String formattedNom = StringUtils.leftPad(nom, AMPLE_NOM);
	    

	    return String.format("%s%s%s%s%s%s%s%s", formattedId, formattedType,gap, formattedDate,gap , formattedSize ,gap , formattedNom);

	}
}
