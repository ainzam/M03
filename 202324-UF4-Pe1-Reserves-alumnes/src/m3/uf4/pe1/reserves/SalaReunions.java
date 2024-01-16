package m3.uf4.pe1.reserves;

import java.util.Date;

public class SalaReunions extends Espai {

	private boolean aacc;
	private boolean wifi;

	public SalaReunions(Edifici edifici, int planta, String nom, boolean aacc, boolean wifi) {
		super(edifici, planta, nom);
		this.aacc = aacc;
		this.wifi = wifi;
	}

	@Override
	public String[] infoEquipaments() {
		String[] info = new String[2];
		info[0] = "Aire condicionat? " + (aacc ? "Si" : "No");
		info[1] = "Accés WiFi? " + (wifi ? "Si" : "No");
		return info;
	}

	@Override
	public String tipusEspai() {
		return "Sala de Reunions";
	}

	@Override
	public boolean afegirReserva(Date dia) {

		if (dia == null || dia.before(new Date())) {
			return false;
		}

		if (consultaReserva(dia)) {
			return false;
		}
		for (int i = 0; i < reserves.length; i++) {
			if (reserves[i] == null) {
				reserves[i] = dia;
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean consultaReserva(Date dia) {

		if (dia == null || dia.before(new Date())) {
			return false;
		}
		for (Date reserva : reserves) {
			if (reserva != null) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean anullarReserva(Date dia) {

		return false;
	}

}
