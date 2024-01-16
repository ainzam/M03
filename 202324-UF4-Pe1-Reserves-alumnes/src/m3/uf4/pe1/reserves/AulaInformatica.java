package m3.uf4.pe1.reserves;

import java.util.Date;

public class AulaInformatica extends Espai {

	private int equips;
	private boolean impressora;
	private boolean projector;
	private String user;
	private String password;

	public AulaInformatica(Edifici edifici, int planta, String nom, int equips, boolean impressora, boolean projector,
			String user, String password) {
		super(edifici, planta, nom);
		this.equips = equips;
		this.impressora = impressora;
		this.projector = projector;
		this.user = user;
		this.password = password;
	}

	public int getEquips() {
		return equips;
	}

	public void setEquips(int equips) {
		this.equips = (equips > 0) ? equips : 1;
	}

	public boolean isImpressora() {
		return impressora;
	}

	public void setImpressora(boolean impressora) {
		this.impressora = impressora;
	}

	public boolean isProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = (user != null) ? user : "";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = (password != null) ? password : "";
	}

	@Override
	public boolean afegirReserva(Date dia) {
		if (dia == null || dia.before(new Date())) {
			return false;
		}

		for (int i = 0; i < reserves.length; i++) {
			if (reserves[i] != null && reserves[i].equals(dia)) {
				return false;
			}
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

		for (int i = 0; i < reserves.length; i++) {
			if (reserves[i] != null && reserves[i].equals(dia)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean anullarReserva(Date dia) {
		if (dia == null || dia.before(new Date())) {
			return false;
		}

		for (int i = 0; i < reserves.length; i++) {
			if (reserves[i] != null && reserves[i].equals(dia)) {

				long tiempoRestante = reserves[i].getTime() - new Date().getTime();
				long diasRestantes = tiempoRestante / (24 * 60 * 60 * 1000);

				if (diasRestantes >= 2) {

					reserves[i] = null;
					return true;
				} else {
					return false;
				}
			}
		}

		return false;
	}

	@Override
	public String tipusEspai() {
		return "Aula Informàtica";
	}

	@Override
	public String[] infoEquipaments() {
		String[] equipaments = new String[4];
		equipaments[0] = "L'aula disposa de " + equips + " ordinadors";
		equipaments[1] = "L'accés als equips és: " + user + "/" + password;
		equipaments[2] = impressora ? "Hi ha impressora" : "No hi ha impressora";
		equipaments[3] = projector ? "Hi ha projector" : "No hi ha projector";
		return equipaments;
	}
}
