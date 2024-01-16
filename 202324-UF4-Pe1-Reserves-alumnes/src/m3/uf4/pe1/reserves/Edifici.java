package m3.uf4.pe1.reserves;

public class Edifici {

	private String adreca;
	private String mailContacte;
	private int telefon;

	public Edifici(String adreca, String mailContacte, int telefon) {
		setAdreca(adreca);
		this.mailContacte = mailContacte;
		setTelefon(telefon);
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		if (adreca != null) {
			this.adreca = adreca;
		} else {
			this.adreca = "";
		}
	}

	public String getMailContacte() {
		return mailContacte;
	}

	public void setMailContacte(String mailContacte) {
		this.mailContacte = mailContacte;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getTelefonFormat() {
		String telefonString = String.valueOf(telefon);

		while (telefonString.length() < 9) {
			telefonString = "0" + telefonString;
		}

		return telefonString.substring(0, 3) + " " + telefonString.substring(3, 5) + " " + telefonString.substring(5, 7)
				+ " " + telefonString.substring(7);
	}
}
