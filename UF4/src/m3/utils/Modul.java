package m3.utils;

public class Modul {
	/**
	 * Classe per treballar amb els mòduls ------------------------------------
	 */
	public String getModulCurt(int Codi) {
		String sModul = "";
		switch (Codi) {
		case 1:
			sModul = "Xarxes";
			break;
		case 2:
			sModul = "Hardware";
			break;
		// ...
		default:
			sModul = "Error. Codi invàlid";
			break;
		}
		return sModul;
	}
}