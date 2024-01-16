package m3.uf4.pe1.reserves;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public abstract class Espai implements Reservable {

	public static final int AMPLE_INFORME = 57;
	public static final int MIDA_RESERVES = 1000;
	protected Edifici edifici;
	protected int planta;
	protected String nom;
	protected Date reserves[];
	private static final String TITOL_INFORME = "Equipaments";
	private static final String TITOL_CALENDARI = "Calendari de reserves";
	private static final String BORDER_CHAR = "-";
	private static final String MIDDLE_BORDER = " | ";
	private static final String LEFT_BORDER = "| ";
	private static final String RIGHT_BORDER = " |";
	private static final int COL1 = 29;
	private static final int COL2 = 17;
	private static final int DAY_WIDTH = 3;

	public Espai(Edifici edifici, int planta, String nom) {
		this.edifici = edifici;
		this.planta = planta;
		this.nom = (nom != null) ? nom : "";
		this.reserves = new Date[MIDA_RESERVES];
	}

	public String capcaleraEspai() {
		String ubicacio = "";
		int innerWidth = AMPLE_INFORME - LEFT_BORDER.length() - RIGHT_BORDER.length();
		ubicacio += StringUtils.repeat(BORDER_CHAR, AMPLE_INFORME) + System.lineSeparator();
		ubicacio += LEFT_BORDER + StringUtils.rightPad(StringUtils.abbreviate(edifici.getAdreca(), COL1), COL1);
		ubicacio += MIDDLE_BORDER + StringUtils.leftPad(this.tipusEspai(), COL2) + RIGHT_BORDER
				+ System.lineSeparator();
		ubicacio += LEFT_BORDER + StringUtils.rightPad("Telf: " + edifici.getTelefonFormat(), COL1);
		ubicacio += MIDDLE_BORDER + StringUtils.leftPad(StringUtils.abbreviate(this.nom, COL2), COL2) + RIGHT_BORDER
				+ System.lineSeparator();
		ubicacio += LEFT_BORDER
				+ StringUtils.rightPad(StringUtils.abbreviate("Mail: " + edifici.getMailContacte(), COL1), COL1);
		ubicacio += MIDDLE_BORDER + StringUtils.leftPad("Planta: " + this.planta, COL2) + RIGHT_BORDER
				+ System.lineSeparator();
		ubicacio += StringUtils.repeat(BORDER_CHAR, AMPLE_INFORME) + System.lineSeparator();
		ubicacio += LEFT_BORDER + StringUtils.center(StringUtils.upperCase(TITOL_INFORME), innerWidth) + RIGHT_BORDER
				+ System.lineSeparator();
		ubicacio += StringUtils.repeat(BORDER_CHAR, AMPLE_INFORME) + System.lineSeparator();
		String[] infoConcrete = this.infoEquipaments();
		if (infoConcrete != null) {
			for (int i = 0; i < infoConcrete.length; i++) {
				ubicacio += LEFT_BORDER
						+ StringUtils.center(StringUtils.abbreviate(infoConcrete[i], innerWidth), innerWidth)
						+ RIGHT_BORDER + System.lineSeparator();
			}
		}
		ubicacio += StringUtils.repeat(BORDER_CHAR, AMPLE_INFORME);
		return ubicacio;
	}

	public abstract String tipusEspai();

	public abstract String[] infoEquipaments();

	public String calendariEspai(int mes, int any) {
		String scalendari = "";
		Locale locale = new Locale("CA", "ES");
		DateFormatSymbols sym = new DateFormatSymbols(locale);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM, yyyy", locale);
		int innerWidth = AMPLE_INFORME - LEFT_BORDER.length() - RIGHT_BORDER.length();

		Calendar cal = Calendar.getInstance(locale);
		// cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(any, mes - 1, 1);
		mes = cal.get(Calendar.MONTH) + 1; // Evita mesos incorrectes > 12 o < 1
		any = cal.get(Calendar.YEAR);

		// Header
		scalendari += LEFT_BORDER + StringUtils.center(StringUtils.upperCase(TITOL_CALENDARI), innerWidth)
				+ RIGHT_BORDER + System.lineSeparator();
		scalendari += LEFT_BORDER + StringUtils.center(sdf.format(cal.getTime()), innerWidth) + RIGHT_BORDER
				+ System.lineSeparator();
		scalendari += StringUtils.repeat(BORDER_CHAR, AMPLE_INFORME) + System.lineSeparator();

		// Grid header
		String[] sdays = sym.getShortWeekdays();
		scalendari += LEFT_BORDER + StringUtils.upperCase(sdays[Calendar.MONDAY]) + MIDDLE_BORDER;
		scalendari += StringUtils.upperCase(sdays[Calendar.TUESDAY]) + MIDDLE_BORDER;
		scalendari += StringUtils.upperCase(sdays[Calendar.WEDNESDAY]) + MIDDLE_BORDER;
		scalendari += StringUtils.upperCase(sdays[Calendar.THURSDAY]) + MIDDLE_BORDER;
		scalendari += StringUtils.upperCase(sdays[Calendar.FRIDAY]) + MIDDLE_BORDER;
		scalendari += StringUtils.upperCase(sdays[Calendar.SATURDAY]) + MIDDLE_BORDER;
		scalendari += StringUtils.upperCase(sdays[Calendar.SUNDAY]) + RIGHT_BORDER;
		scalendari += System.lineSeparator();
		scalendari += StringUtils.repeat(BORDER_CHAR, AMPLE_INFORME) + System.lineSeparator();

		// Grid
		int primerDiaMes = Math.floorMod(cal.get(Calendar.DAY_OF_WEEK) - 2, 7) + 1; // Sunday 1 ... Saturday 7 => Monday
																					// 1 .... Sunday 7
		int diesDelMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int primeraSetmana = cal.get(Calendar.WEEK_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, diesDelMes); // Últim dia
		int setmanesMes = cal.get(Calendar.WEEK_OF_MONTH) - primeraSetmana + 1;

		int diaMes = 0;
		String[][] monthView = new String[setmanesMes][9];
		for (int i = 0; i < monthView.length; i++) {
			monthView[i][0] = LEFT_BORDER;
			for (int j = 1; j < 8; j++) {
				String sdia = "";
				if (diaMes == 0 && j < primerDiaMes) {
					sdia = StringUtils.center(BORDER_CHAR, DAY_WIDTH); // Primera setmana
				}
				if (diaMes == 0 && j == primerDiaMes) {
					diaMes = 1;
				}
				if (diaMes > 0 && diaMes <= diesDelMes) {
					sdia = StringUtils.center(diaMes + "", DAY_WIDTH);
					diaMes++;
				} else {
					sdia = StringUtils.center(BORDER_CHAR, DAY_WIDTH); // Última setmana
				}
				monthView[i][j] = sdia + MIDDLE_BORDER;
			}
			monthView[i][8] = System.lineSeparator();
		}

		// Afegir reserves
		for (int i = 0; i < reserves.length; i++) {
			if (reserves[i] != null) {
				cal.setTime(reserves[i]);
				if (cal.get(Calendar.YEAR) == any && cal.get(Calendar.MONTH) + 1 == mes) {
					int diaSetmana = Math.floorMod(cal.get(Calendar.DAY_OF_WEEK) - 2, 7) + 1; // Sunday 1 ... Saturday 7
																								// => Monday 1 ....
																								// Sunday 7
					int setmanaMes = cal.get(Calendar.WEEK_OF_MONTH) - primeraSetmana;
					monthView[setmanaMes][diaSetmana] = StringUtils.center("XX", DAY_WIDTH) + MIDDLE_BORDER;
				}
			}
		}
		for (int i = 0; i < monthView.length; i++) {
			for (int j = 0; j < 9; j++) {
				scalendari += monthView[i][j];
			}
		}
		scalendari += StringUtils.repeat(BORDER_CHAR, AMPLE_INFORME);
		return scalendari;
	}

	@Override
	public boolean afegirReserva(Date dia) {
		Calendar calActual = Calendar.getInstance();
		Calendar calDia = Calendar.getInstance();
		calDia.setTime(dia);

		if (calDia.after(calActual)) {

			int posicio = cercarReserva();
			if (posicio != -1) {
				reserves[posicio] = dia;
				return true;
			} else {

				return false;
			}
		} else {
			return false;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean consultarReserva(Date dia) {
		for (int i = 0; i < MIDA_RESERVES; i++) {
			if (reserves[i] != null && reserves[i].equals(dia)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean anullarReserva(Date dia) {
		Calendar calActual = Calendar.getInstance();
		Calendar calReserva = Calendar.getInstance();
		calReserva.setTime(dia);

		long diferenciaDias = (calReserva.getTimeInMillis() - calActual.getTimeInMillis()) / (24 * 60 * 60 * 1000);

		if (diferenciaDias >= 2) {

			int posicio = cercarReserva(dia);
			if (posicio != -1) {
				reserves[posicio] = null;
				return true;
			}

		}
		return false;
	}

	private int cercarReserva() {
		for (int i = 0; i < MIDA_RESERVES; i++) {
			if (reserves[i] == null) {
				return i;
			}
		}
		return -1;
	}

	private int cercarReserva(Date dia) {
		for (int i = 0; i < MIDA_RESERVES; i++) {
			if (reserves[i] != null && reserves[i].equals(dia)) {
				return i;
			}
		}
		return -1;
	}

}
