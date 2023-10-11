package figures;

public class Cercle extends Figura {
	private int radi;
	private Punt centre;

	@Override
	public double calcularPerimetre() {
		// TODO Auto-generated method stub
		return 2 * 3.1416 * radi;
	}
}