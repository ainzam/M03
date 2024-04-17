package m3.uf5.preguntes.examen.model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.StringUtils;

@Entity
public class Examen implements Avaluable {
	public static final int MAX_PREGUNTES = 10;
	public static final int AMPLE_ASSISTENCIA = 28;
	public static final int COL_LLIURAMENT = 28;
	public static final int GAP_LLIURAMENT = 10;
	public static final int COL_CORRECCIO = 35;
	public static final int AMPLE_ENUNCIAT = 80;
	public static final int AMPLE_PUNTUACIO = 15;
	// http://www.fileformat.info/info/unicode/char/search.htm?q=square
	public static final char NO_LLIURAT_SQUARE = '\u25EF'; // '\u20DE'; '\u274F';
	public static final char LLIURAT_CHECK = '\u2A02'; // '\u274E'; ;'\u2327'
	public static final char CHECK_SQUARE = '\u20DE';

	@OneToOne(cascade = CascadeType.ALL)
	private UnitatFormativa unitat;

	@OneToMany(cascade = CascadeType.ALL)
	private LinkedList<Pregunta> preguntes; // Llista de preguntes

	@OneToMany(cascade = CascadeType.ALL)
	private TreeSet<Estudiant> alumnes; // Conjunt d'estudiants sense repetits i ordenat per cognoms + nom

	@OneToMany(cascade = CascadeType.ALL)
	private Deque<Lliurament> lliuraments; // Pila de lliuraments

	@OneToMany(cascade = CascadeType.ALL)
	private Deque<Lliurament> correccions; // Pila de correccions

	public Examen(UnitatFormativa unitat) throws Excepcio {
		if (unitat == null) {
			throw new Excepcio("Examen", "Cal indicar la Unitat Formativa");
		}
		this.unitat = unitat;
		this.preguntes = new LinkedList<Pregunta>();
		this.alumnes = new TreeSet<Estudiant>();
		this.lliuraments = new LinkedList<Lliurament>();
		this.correccions = new LinkedList<Lliurament>();
	}

	public UnitatFormativa getUnitat() {
		return unitat;
	}

	public void setUnitat(UnitatFormativa unitat) throws Excepcio {
		if (unitat == null) {
			throw new Excepcio("Examen", "Cal indicar la Unitat Formativa");
		}
		this.unitat = unitat;
	}

	public void inscriureEstudiant(Estudiant estudiant) throws Excepcio {
		if (estudiant == null) {
			throw new Excepcio("Examen", "Cal indicar l'estudiant per poder inscriure'l");
		}
		this.alumnes.add(estudiant);
	}

	public void inscriureEstudiants(Estudiant[] estudiants) throws Excepcio {
		if (estudiants == null) {
			throw new Excepcio("Examen", "Cal indicar els estudiants per poder-los inscriure");
		}
		this.alumnes.addAll(Arrays.asList(estudiants));
	}

	public void anularMatriculaEstudiant(Estudiant estudiant) throws Excepcio {
		if (estudiant == null) {
			throw new Excepcio("Examen", "Cal indicar l'estudiant per poder anul·lar la matrícula");
		}
		this.alumnes.remove(estudiant);
	}

	public String generarLlistatAssistencia() throws Excepcio {
		// Marcar el checkbox en cas que l'estudiant estigui a lliuraments o a
		// correccions
		String assistencia = "  " + StringUtils.center("Llistat assistència", Examen.AMPLE_ASSISTENCIA) + "  "
				+ System.lineSeparator();
		assistencia += "  " + StringUtils.repeat(".", Examen.AMPLE_ASSISTENCIA) + System.lineSeparator() + "  "
				+ System.lineSeparator();

		Iterator<Estudiant> it = this.alumnes.iterator();
		while (it.hasNext()) {
			Estudiant current = it.next();
			assistencia += "  " + StringUtils.rightPad(
					(this.lliuraments.contains(new Lliurament(current, this))
							|| this.correccions.contains(new Lliurament(current, this)) ? LLIURAT_CHECK
									: NO_LLIURAT_SQUARE)
							+ "  " + StringUtils.abbreviate(current.getCognomsNom(), Examen.AMPLE_ASSISTENCIA - 3),
					Examen.AMPLE_ASSISTENCIA) + System.lineSeparator();
		}

		assistencia += System.lineSeparator() + "  " + StringUtils.repeat("_", Examen.AMPLE_ASSISTENCIA)
				+ System.lineSeparator();
		return assistencia;
	}

	public void apilarLliurament(Estudiant estudiant) throws Excepcio {
		if (estudiant == null) {
			throw new Excepcio("Examen", "Cal indicar l'estudiant per poder fer el lliurament");
		}
		if (this.lliuraments.contains(new Lliurament(estudiant, this))
				|| this.correccions.contains(new Lliurament(estudiant, this))) {
			throw new Excepcio("Examen", "L'estudiant " + estudiant.getCognomsNom() + " ja ha fet un lliurament");
		}

		this.lliuraments.addFirst(new Lliurament(estudiant, this)); // Push
	}

	public void corregirLliurament(double nota) throws Excepcio {
		// Treure de lliuraments i afegir a correccions
		this.validarNota(nota);

		if (this.lliuraments.isEmpty()) {
			throw new Excepcio("Examen", "No hi ha cap lliurament per corregir");
		}
		Lliurament correccio = this.lliuraments.removeFirst(); // pop()
		correccio.setNota(nota);
		this.correccions.addFirst(correccio);
	}

	public Estudiant consultarEstudiantPerCorregir() throws Excepcio {
		// Consultar estudiant cim de la pila de lliuraments
		if (this.lliuraments.isEmpty()) {
			throw new Excepcio("Examen", "No hi ha cap lliurament per corregir");
		}

		return this.lliuraments.getFirst().getEstudiant(); // peek()
	}

	public String mostrarCorreccions() {
		// Mostra les dues piles: lliuraments i correccions respectant l'ordre de
		// cadascuna

		String pila = "  " + StringUtils.repeat(" ", GAP_LLIURAMENT);
		pila += StringUtils.center("LLIURAMENTS", COL_LLIURAMENT);
		pila += StringUtils.repeat(" ", GAP_LLIURAMENT);
		pila += StringUtils.center("CORRECCIONS", COL_CORRECCIO) + System.lineSeparator();

		pila += "  " + StringUtils.repeat(" ", GAP_LLIURAMENT);
		pila += StringUtils.repeat(" ", COL_LLIURAMENT);
		pila += StringUtils.repeat(" ", GAP_LLIURAMENT);
		pila += StringUtils.repeat(" ", COL_CORRECCIO) + System.lineSeparator() + System.lineSeparator();

		Lliurament[] arrayLliuraments = this.lliuraments.toArray(new Lliurament[] {});
		Lliurament[] arrayCorreccions = this.correccions.toArray(new Lliurament[] {});

		int top = Math.max(arrayLliuraments.length, arrayCorreccions.length) - 1;

		while (top >= 0) {
			pila += "  ";
			// Primera columna. LLiuraments
			if (top <= arrayLliuraments.length - 1) {
				Estudiant current = arrayLliuraments[top].getEstudiant();

				if (top == arrayLliuraments.length - 1) {
					pila += StringUtils.center("TOP ->", GAP_LLIURAMENT);
				} else {
					pila += StringUtils.repeat(" ", GAP_LLIURAMENT);
				}
				pila += "[ " + StringUtils.center(StringUtils.abbreviate(current.getCognomsNom(), COL_LLIURAMENT - 4),
						COL_LLIURAMENT - 4, " ") + " ]";
			} else {
				pila += StringUtils.repeat(" ", GAP_LLIURAMENT + COL_LLIURAMENT);
			}

			// Segona columna. Correccions
			if (top <= arrayCorreccions.length - 1) {
				Lliurament correcio = arrayCorreccions[top];

				if (top == arrayCorreccions.length - 1) {
					pila += StringUtils.center("TOP ->", GAP_LLIURAMENT);
				} else {
					pila += StringUtils.repeat(" ", GAP_LLIURAMENT);
				}
				String avaluta = (new DecimalFormat("#0.00")).format(this.notaNormalitzada(correcio.getNota())) + " - "
						+ correcio.getEstudiant().getCognomsNom();
				pila += "[ "
						+ StringUtils.center(StringUtils.abbreviate(avaluta, COL_CORRECCIO - 4), COL_CORRECCIO - 4, " ")
						+ " ]";
			} else {
				pila += StringUtils.repeat(" ", GAP_LLIURAMENT + COL_CORRECCIO);
			}

			pila += System.lineSeparator() + System.lineSeparator();
			top--;
		}

		pila += "  " + StringUtils.repeat(" ", GAP_LLIURAMENT);
		pila += StringUtils.center(" TAULA PROFESSOR ", COL_LLIURAMENT + GAP_LLIURAMENT + COL_CORRECCIO, "_");
		pila += System.lineSeparator() + System.lineSeparator();

		return pila;
	}

	public void validarNota(double nota) throws Excepcio {
		if (nota < 0 || nota > this.getPuntuacio()) {
			throw new Excepcio("Examen",
					"El valor de la nota és incorrecte: " + (new DecimalFormat("#0.00")).format(nota));
		}
	}

	// Sobre 10
	private double notaNormalitzada(double nota) {
		if (this.getPuntuacio() == 0) {
			return 0;
		}
		return nota / this.getPuntuacio() * 10;
	}

	// retorna false si no hi ha espai al vector, text eś null o puntuació < 0
	public boolean afegirPreguntaOberta(String text, double puntuacio) throws Excepcio {
		this.validarPregunta(text, puntuacio);

		return this.preguntes.add(new PreguntaOberta(text, puntuacio));
	}

	// retorna false si no hi ha espai al vector, text eś null, puntuació < 0 o
	// opcions és null
	public boolean afegirPreguntaOpcions(String text, double puntuacio, String[] opcions) throws Excepcio {
		this.validarPregunta(text, puntuacio);

		return this.preguntes.add(new PreguntaOpcions(text, puntuacio, opcions));
	}

	// Esborra la pregunta (canvia la instància per null) num començant per 1 fins a
	// 10 retorna false si l'índex és incorrecte
	public boolean esborrarPregunta(int num) throws Excepcio {
		if (num < 1 || num > this.preguntes.size()) {
			throw new Excepcio("Examen", "No es pot esborrar la pregunta " + num + ", no existeix ");
		}

		this.preguntes.remove(num - 1);

		return true;
	}

	private void validarPregunta(String text, double puntuacio) throws Excepcio {
		if (this.preguntes.size() >= MAX_PREGUNTES) {
			throw new Excepcio("Examen", "L'examen ha arribat al límit de preguntes: " + MAX_PREGUNTES);
		}

		if (text == null) {
			throw new Excepcio("Examen", "Cal indicar el text de la pregunta");
		}

		if (puntuacio <= 0) {
			throw new Excepcio("Examen", "La puntuació de la pregunta hauria de ser major que 0");
		}
	}

	// titol
	@Override
	public String getTitol() {
		return StringUtils.center(" Examen " + unitat.getModulUf() + " ", AMPLE_ENUNCIAT, "#") + System.lineSeparator()
				+ System.lineSeparator()
				+ StringUtils.rightPad(StringUtils.abbreviate(unitat.getTitolUf(), AMPLE_ENUNCIAT), AMPLE_ENUNCIAT)
				+ System.lineSeparator();
	}

	public String getTitolHtml() {
		/* To Do */
		return "";
	}

	// suma punts
	@Override
	public double getPuntuacio() {
		double punt = 0;
		for (Pregunta pregunta : preguntes) {
			if (pregunta != null) {
				punt += pregunta.getPuntuacio();
			}
		}
		return punt;
	}

	// enunciat
	@Override
	public String getEnunciat() {
		String enunciat = StringUtils.rightPad("ENUNCIAT", AMPLE_ENUNCIAT - AMPLE_PUNTUACIO) + StringUtils
				.leftPad((new DecimalFormat("##0.0")).format(this.getPuntuacio()) + " PUNTS", AMPLE_PUNTUACIO);
		enunciat += System.lineSeparator() + StringUtils.repeat("-", AMPLE_ENUNCIAT) + System.lineSeparator()
				+ System.lineSeparator();

		int num = 1;
		Iterator<Pregunta> iterator = this.preguntes.iterator();
		while (iterator.hasNext()) {
			enunciat += iterator.next().getEnunciatPregunta(num) + StringUtils.repeat(System.lineSeparator(), 3);
			num++;
		}
		return enunciat;
	}

	@Override
	public boolean esAvaluable() {
		return this.getPuntuacio() > 0;
	}
}
