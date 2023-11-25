package m3.uf4.pt1.fitxers;

public class SistemaFitxers implements Imprimible {

	public static final int LIMIT_CAPACITAT = 2147483647;
	private Directori arrel;

	public SistemaFitxers() {
		//  Crear un directorio raíz con el nombre "/"
		arrel = new Directori("/");
	}

	@Override
	public String imprimir(char unitats) {
		// Llama al método imprimir del directorio raíz con las unidades especificadas
		return arrel.imprimir(unitats);
	}

	public static String formatSize(char unitats, int mida) {
		// Implementa la lógica para formatear el tamaño según las unidades
		switch (unitats) {
		case 'B':
			return String.format("%d B", mida);
		case 'K':
			return String.format("%.1f KB", mida / 1024.0);
		case 'M':
			return String.format("%.1f MB", mida / 1048576.0);
		case 'G':
			return String.format("%.1f GB", mida / 1073741824.0);
		default:
			return "Unidad no válida";
		}
	}

	public Directori getArrel() {
		return arrel;
	}

	public void setArrel(Directori arrel) {
		// modificar aquest mètode per tal que no faci res
	}

}
