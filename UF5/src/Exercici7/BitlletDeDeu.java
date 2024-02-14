package Exercici7;

public class BitlletDeDeu extends Bitllet {

	public BitlletDeDeu() {
		super(10, "Blau");
	}

	@Override
	public boolean esDeCinc() {
		return false;
	}

	@Override
	public boolean esDeDeu() {
		return true;
	}

	@Override
	public boolean esDeVint() {
		return false;
	}

}