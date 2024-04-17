package m3.uf5.preguntes.examen.model;

import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

@Entity
public class PreguntaOpcions extends Pregunta {
	private HashSet<String> opcions = new HashSet<String>();

	public PreguntaOpcions(String text, double puntuacio, String[] opcions) throws Excepcio {
		super(text, puntuacio);
		if (opcions == null || opcions.length < 2) {
			throw new Excepcio("PreguntaOpcions", "Opcions de la pregunta incorrectes");
		}
		this.opcions = new HashSet<String>(Arrays.asList(opcions));
	}

	public String[] getOpcions() {
		return this.opcions.toArray(new String[] {});
	}

	@Override
	public int getTotalOpcions() {
		return this.opcions.size();
	}

	public void setOpcions(String[] opcions) throws Excepcio {
		if (opcions == null || opcions.length < 2) {
			throw new Excepcio("PreguntaOpcions", "Opcions de la pregunta incorrectes");
		}
		this.opcions.clear();
		this.opcions.addAll(Arrays.asList(opcions));
	}

	@Override
	public boolean esOpcions() {
		return true;
	}

	@Override
	public String getEnunciatPregunta(int num) {
		String resposta = System.lineSeparator();
		for (String opcio : opcions) {
			resposta += StringUtils.rightPad("  " + Examen.CHECK_SQUARE + "  " + opcio, Examen.AMPLE_ENUNCIAT + 2, ".")
					+ System.lineSeparator();
		}
		// resposta += System.lineSeparator();
		return super.crearEnunciatPregunta(num, resposta);
	}

}
