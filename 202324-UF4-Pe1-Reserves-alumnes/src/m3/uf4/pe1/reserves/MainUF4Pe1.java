package m3.uf4.pe1.reserves;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class MainUF4Pe1 {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("CA", "ES"));

		/* EDIFICIS */

		Edifici nostromo = new Edifici("c/ Joseph Conrad, 111", "contact@nostromo.com", 960555111);
		Edifici fahrenheit = new Edifici("c/ Ray Bradbury, 451", "cronicas.marcianas@bradbury.com", 922555222);
		Edifici arrakis = new Edifici("c/ Frank Herbert, 19-65", "atreides@dune.com", 978555333);
		Edifici titan = new Edifici("c/ John Varley, 123-133", "capitanacirocco@titan.com", 935555333);

		/* ESPAIS */

		System.out.println(StringUtils.repeat("#", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.center("ESPAIS", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.repeat("#", Espai.AMPLE_INFORME) + System.lineSeparator());

		Espai robertHeinlein = new SalaReunions(nostromo, 1, "Robert Heinlein", true, true);
		Espai larryNiven = new SalaReunions(nostromo, 1, "Larry Niven", false, true);
		Espai arthurCClarke = new Auditori(fahrenheit, 0, "Arthur C. Clarke", 250);
		Espai stanislawLem = new Auditori(arrakis, -1, "Stanislaw Lem", 150);
		Espai poulAnderson = new AulaInformatica(titan, -2, "Poul Anderson", 15, false, true, "guardians",
				"$%time1960");

		System.out.println(larryNiven.capcaleraEspai() + System.lineSeparator());
		System.out.println(stanislawLem.capcaleraEspai() + System.lineSeparator());
		System.out.println(poulAnderson.capcaleraEspai() + System.lineSeparator());

		/* CALENDARIS */

		System.out.println(StringUtils.repeat("#", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.center("ESPAIS + CALENDARIS", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.repeat("#", Espai.AMPLE_INFORME) + System.lineSeparator());

		robertHeinlein.afegirReserva(sdf.parse("01/01/2024"));
		robertHeinlein.afegirReserva(sdf.parse("18/01/2024"));
		robertHeinlein.afegirReserva(sdf.parse("19/01/2024"));
		robertHeinlein.afegirReserva(sdf.parse("29/01/2024"));

		arthurCClarke.afegirReserva(sdf.parse("26/01/2024"));
		arthurCClarke.afegirReserva(sdf.parse("02/02/2024"));
		arthurCClarke.afegirReserva(sdf.parse("11/02/2024"));
		arthurCClarke.afegirReserva(sdf.parse("22/02/2024"));
		arthurCClarke.afegirReserva(sdf.parse("01/03/2024"));

		poulAnderson.afegirReserva(sdf.parse("02/04/2024"));
		poulAnderson.afegirReserva(sdf.parse("03/04/2024"));
		poulAnderson.afegirReserva(sdf.parse("04/04/2024"));
		poulAnderson.afegirReserva(sdf.parse("22/04/2024"));
		poulAnderson.afegirReserva(sdf.parse("29/04/2024"));

		System.out.println(robertHeinlein.capcaleraEspai());
		System.out.println(robertHeinlein.calendariEspai(1, 2024) + System.lineSeparator());
		System.out.println(arthurCClarke.capcaleraEspai());
		System.out.println(arthurCClarke.calendariEspai(2, 2024) + System.lineSeparator());
		System.out.println(poulAnderson.capcaleraEspai());
		System.out.println(poulAnderson.calendariEspai(04, 2024) + System.lineSeparator());

		/* CONSULTES RESERVES */

		System.out.println(StringUtils.repeat("#", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.center("CONSULTES", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.repeat("#", Espai.AMPLE_INFORME) + System.lineSeparator());

		if (poulAnderson.consultarReserva(sdf.parse("04/04/2024"))) {
			System.out.println("1) Espai \"" + poulAnderson.getNom() + "\" reservat el dia 04/04/2024");
		}
		if (!poulAnderson.consultarReserva(sdf.parse("05/04/2024"))) {
			System.out.println("2) Espai \"" + poulAnderson.getNom() + "\" disponible el dia 05/04/2024");
		}

		/* ANUL·LAR RESERVES */

		System.out.println(System.lineSeparator() + StringUtils.repeat("#", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.center("ANUL·LACIONS", Espai.AMPLE_INFORME));
		System.out.println(StringUtils.repeat("#", Espai.AMPLE_INFORME) + System.lineSeparator());

		if (robertHeinlein.anullarReserva(sdf.parse("19/01/2024"))) {
			System.out.println("3) Anul·lada reserva a \"" + robertHeinlein.getNom() + "\" dia 19/01/2024");
		}
		if (!robertHeinlein.anullarReserva(sdf.parse("20/01/2024"))) {
			System.out.println("4) Cap reserva a \"" + robertHeinlein.getNom() + "\" el dia 20/01/2024");
		}
	}

}
