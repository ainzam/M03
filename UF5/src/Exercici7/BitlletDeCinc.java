package Exercici7;

public class BitlletDeCinc extends Bitllet {

	public BitlletDeCinc() {
		super(5, "Verd");
	}

	@Override
	public boolean esDeCinc() {
		return true;
	}

	@Override
	public boolean esDeDeu() {
		return false;
	}

	@Override
	public boolean esDeVint() {
		return false;
	}

}
