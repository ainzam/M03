package m3.uf4.pe1.reserves;

import java.util.Date;

public class Auditori extends Espai {

	private int capacitat;

	public Auditori(Edifici edifici, int planta, String nom, int capacitat) {
		super(edifici, planta, nom);
		this.capacitat = (capacitat > 0) ? capacitat : 1;
	}

	public int getCapacitat() {
		return capacitat;
	}

	public void setCapacitat(int capacitat) {
		this.capacitat = (capacitat > 0) ? capacitat : 1;
	}

	@Override
	public String[] infoEquipaments() {
		String[] info = new String[1];
		info[0] = "L'aforament de l'auditori és de " + capacitat + " persones";
		return info;
	}

	@Override
	public String tipusEspai() {
		return "Auditori";
	}

	@Override
	public boolean anullarReserva(Date dia) {
		System.out.println("No es pot anul·lar les reserves d'un auditori.");
		return false;
	}

	@Override
	public boolean consultaReserva(Date dia) {
		if (dia == null || dia.before(new Date())) {
			return false;
		}
		return false;
	}

}
