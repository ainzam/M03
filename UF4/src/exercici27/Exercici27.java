package exercici27;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercici27 {

	public static void main(String[] args) throws ParseException {

		Date fechaHoy = new Date();

		SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yy");

		String fechaHoyformateada = formato.format(fechaHoy);

		System.out.println("La fecha de hoy:" + fechaHoyformateada);

		Date fechafija = null;

		SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

		fechafija = formatoEntrada.parse("07/12/1975");

		String fechafijaformateada = formato.format(fechafija);

		System.out.println("La fecha 07/12/1975:" + fechafijaformateada);

	}

}
