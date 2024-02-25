package m3.uf4.pt1.fitxers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Directori extends ElementSistema {

	public static final int MAX_ELEMENTS = 10;
	public static final int MIDA_REFERENCIA = 4;
	private ElementSistema[] elements;

	public Directori(String nom) {
		super(nom);
		elements = new ElementSistema[MAX_ELEMENTS];
	}

	public Directori(String nom, Date creat) {
		super(nom, creat);
		elements = new ElementSistema[MAX_ELEMENTS];
	}

	public ElementSistema[] getElements() {
		return elements;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public Directori getRoot() {
		if (isRoot()) {
			return this;
		} else {
			return parent.getRoot();
		}
	}

	public int countElements() {
		int count = 0;
		for (ElementSistema element : elements) {
			if (element != null) {
				count++;
			}
		}
		return count;
	}

	public void addElement(ElementSistema nou) {
		for (int i = 0; i < MAX_ELEMENTS; i++) {
			if (elements[i] == null) {
				elements[i] = nou;
				nou.parent = this;
				break;
			}
		}
	}

	public void removeElement(int id) {
		for (int i = 0; i < MAX_ELEMENTS; i++) {
			if (elements[i] != null && elements[i].getId() == id) {
				elements[i] = null;
				break;
			}
		}
	}

	@Override
	public int getDepth() {

		if (isRoot()) {
			return 0;
		} else {

			return parent.getDepth() + 1;
		}
	}

	@Override
	public String getPath() {

		if (isRoot()) {
			return "";
		} else {

			return parent.getPath() + "/" + nom;
		}
	}

	@Override
	public int getMida() {
		int totalMida = 0;
		for (ElementSistema element : elements) {
			if (element != null) {
				totalMida += element.getMida();
			}
		}
		return totalMida + countElements() * MIDA_REFERENCIA;
	}

	@Override
	public String imprimir(char unitats) {
		String result = "";


		result += String.format("%s D%s%s%s%s%s%s%n",
				StringUtils.leftPad(String.valueOf(getId()), AMPLE_IDENT * getDepth()).replace(' ', '.'),
				StringUtils.leftPad("", AMPLE_GAP),
				StringUtils.leftPad(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(creat), AMPLE_DATA),
				StringUtils.leftPad("", AMPLE_GAP),
				StringUtils.rightPad(SistemaFitxers.formatSize(unitats, getMida()), AMPLE_MIDA),
				StringUtils.leftPad("", AMPLE_GAP), StringUtils.rightPad(nom, AMPLE_NOM));


		result += System.lineSeparator();


		for (ElementSistema element : elements) {
			if (element != null) {
				result += element.imprimir(unitats);
				result += System.lineSeparator();
			}
		}

		return result;
	}
}
