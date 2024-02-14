package Exercici7;

public class BitlletDeVint extends Bitllet {

	public BitlletDeVint() {
		super(20, "Groc");
	}

	@Override
	public boolean esDeCinc() {
		return false;
	}

	@Override
	public boolean esDeDeu() {
		return false;
	}

	@Override
	public boolean esDeVint() {
		return true;
	}

}