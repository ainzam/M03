package m3.uf4.pt1.fitxers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Enllac extends ElementSistema {

	private ElementSistema target;
	
	public Enllac (String nom, ElementSistema target) {
        super(nom);
        this.target = target;
	}
	public Enllac (String nom,Date creat, ElementSistema target) {
        super(nom, creat);
        this.target = target;
	}
	
    @Override
    public int getMida() {
        return 0;
    }
	
    public String imprimir(char unitats) {
        String dateFormatted = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(creat);
        
        String idStr = String.valueOf(id);
        
        
        String formattedId = StringUtils.leftPad(idStr, AMPLE_IDENT * getDepth()).replace(" ", ".");
        String formattedType = "L";
        String formattedDate = StringUtils.leftPad(dateFormatted, AMPLE_DATA);
        String formattedNom = StringUtils.center(nom, AMPLE_NOM);
        String formattedTargetPath = StringUtils.leftPad(target.getPath(), AMPLE_NOM);

        
        return String.format("%s%s%s%s => %s", formattedId, formattedType, formattedDate, formattedNom, formattedTargetPath);

    }
	public ElementSistema getTarget() {
		return target;
	}
	public void setTarget(ElementSistema target) {
		this.target = target;
	}
}
