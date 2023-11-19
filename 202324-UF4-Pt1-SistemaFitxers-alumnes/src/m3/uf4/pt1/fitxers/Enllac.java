package m3.uf4.pt1.fitxers;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        String sizeFormatted = SistemaFitxers.formatSize(unitats, getMida());
        return String.format("%d %s %s %s => %s", getId(), sizeFormatted, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(creat), getPath(), target.getPath());
    }
	public ElementSistema getTarget() {
		return target;
	}
	public void setTarget(ElementSistema target) {
		this.target = target;
	}
}
