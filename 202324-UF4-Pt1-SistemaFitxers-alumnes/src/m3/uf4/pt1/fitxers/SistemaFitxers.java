package m3.uf4.pt1.fitxers;

public class SistemaFitxers implements Imprimible {

	public static final int LIMIT_CAPACITAT = 2147483647;
	private Directori arrel;

	public SistemaFitxers() {

		arrel = new Directori("/");
	}

	@Override
	public String imprimir(char unitats) {

		return arrel.imprimir(unitats);
	}

	public static String formatSize(char unitats, int mida) {

		switch (unitats) {
		case 'B':
			return String.format("%d B", mida);
		case 'K':
			return String.format("%d KB", mida / 1024);
		case 'M':
			return String.format("%d MB", mida / 1024 / 1024);
		case 'G':
			return String.format("%d GB", mida / 1024 / 1024 / 1024);
		default:
			return "Unidad no válida";
		}
	}

	public Directori getArrel() {
		return arrel;
	}

	public void setArrel(Directori arrel) {

	}

}
