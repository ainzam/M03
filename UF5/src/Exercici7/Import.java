package Exercici7;

import java.util.ArrayList;
import java.util.Collections;

public class Import {

	private ArrayList<Bitllet> bitllets;

	public Import(int importTotal) {
		this.bitllets = new ArrayList<>();
		descompondreImport(importTotal);
	}

	private void descompondreImport(int importTotal) {
		while (importTotal > 0) {
			if (importTotal >= 20) {
				bitllets.add(new BitlletDeVint());
				importTotal -= 20;
			} else if (importTotal >= 10) {
				bitllets.add(new BitlletDeDeu());
				importTotal -= 10;
			} else {
				bitllets.add(new BitlletDeCinc());
				importTotal -= 5;
			}
		}
		Collections.sort(bitllets, Collections.reverseOrder());
	}

	public int getImport() {
		int importTotal = 0;
		for (Bitllet bitllet : bitllets) {
			importTotal += bitllet.importe;
		}
		return importTotal;
	}

	public void mostrarQuantitat(Bitllet bitllet) {
		int quantitat = 0;
		for (Bitllet b : bitllets) {
			if (b.esDeCinc() && bitllet.esDeCinc()) {
				quantitat++;
			} else if (b.esDeDeu() && bitllet.esDeDeu()) {
				quantitat++;
			} else if (b.esDeVint() && bitllet.esDeVint()) {
				quantitat++;
			}
		}
		System.out.println("Hi ha " + quantitat + " bitllets de " + bitllet.getColor() + " (" + bitllet.importe + "€)");
	}

	public static void main(String[] args) {
		Import import1 = new Import(155);
		import1.mostrarQuantitat(new BitlletDeCinc());
		import1.mostrarQuantitat(new BitlletDeDeu());
		import1.mostrarQuantitat(new BitlletDeVint());
	}

}
