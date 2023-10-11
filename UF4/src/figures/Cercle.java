package figures;

public class Cercle extends Figura {
	private int radi;
	private Punt centre;

	@Override
	public double calcularPerimetre() {
		// TODO Auto-generated method stub
		return 2 * 3.1416 * radi;
	}

	public int getRadi() {
		return radi;
	}

	public void setRadi(int radi) {
		this.radi = radi;
	}

	public Punt getCentre() {
		return centre;
	}

	public void setCentre(Punt centre) {
		this.centre = centre;
	}

}