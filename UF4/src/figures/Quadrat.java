package figures;

public class Quadrat extends Figura {
	private int costat;

	@Override
	public double calcularPerimetre() {
		// TODO Auto-generated method stub
		return 4 * costat;
	}
}