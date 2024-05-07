package m3.uf5.preguntes.examen;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import m3.uf5.preguntes.examen.model.Excepcio;
import m3.uf5.preguntes.examen.model.Pregunta;

public class MainObjectDB {
	public static final String ODB = "$objectdb/db/examen.odb";

	public static void main(String[] args) throws Excepcio {
		// MainAvaluacio.main(args);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(MainObjectDB.ODB); // Accés a la factoria
		EntityManager em = emf.createEntityManager();
		consultesInicials(em);
		consultesParametres();
		consultesPaginacio();
		consultesJoin();
		em.close();
		emf.close();
	}

	private static void consultesInicials(EntityManager em) {
		// Consultar total, màxim, mínima i mitjana puntuacions de preguntes

		System.out.println("------------------------------\nConsulta1");

		Query query1 = em.createQuery(
				"SELECT SUM(p.puntuacio), MAX(p.puntuacio), MIN(p.puntuacio), AVG(p.puntuacio) FROM Pregunta p");

		Object[] result1 = (Object[]) query1.getSingleResult();

		System.out.println("Suma Total: " + result1[0] + " Maximo: " + result1[1] + " Minimo: " + result1[2]
				+ " Media: " + result1[3]);

		// Consultar preguntes que continguin el text "cert" ordenades per
		// puntuació

		System.out.println("------------------------------\nConsulta2");

		Query query2 = em.createQuery("SELECT p FROM Pregunta p WHERE p.text LIKE '%cert%' ORDER BY p.puntuacio DESC");
		@SuppressWarnings("unchecked")
		List<Pregunta> result2 = query2.getResultList();
		for (Pregunta pregunta : result2) {
			System.out.println("Texto: " + pregunta.getText() + " - Puntuación: " + pregunta.getPuntuacio());
		}

		// Consultar preguntes verdader o fals que continguin el text "cert" i
		// puntuació inferior o igual a 1

		System.out.println("------------------------------\nConsulta3");

		Query query3 = em.createQuery("SELECT p FROM Pregunta p WHERE p.text LIKE '%cert%' and p.puntuacio <= 1");
		@SuppressWarnings("unchecked")
		List<Pregunta> result3 = query3.getResultList();
		for (Pregunta pregunta : result3) {
			System.out.println("Texto: " + pregunta.getText() + " - Puntuación: " + pregunta.getPuntuacio());
		}

		// Consultar preguntes que text de més de 50 caràcters, ordenades per mida
		// del text

		System.out.println("------------------------------\nConsulta4");

		Query query4 = em.createQuery("SELECT p FROM Pregunta p WHERE LENGTH(p.text) > 50 ORDER BY LENGTH(p.text)");
		@SuppressWarnings("unchecked")
		List<Pregunta> result4 = query4.getResultList();
		for (Pregunta pregunta : result4) {
			System.out.println("Texto: " + pregunta.getText() + " - Puntuación: " + pregunta.getPuntuacio());
		}

		// Consultar total de preguntes agrupades per puntuació

		System.out.println("------------------------------\nConsulta5");

		Query query5 = em.createQuery(
				"SELECT p.puntuacio, COUNT(p) FROM Pregunta p WHERE LENGTH(p.text) > 50 GROUP BY p.puntuacio");
		@SuppressWarnings("unchecked")
		List<Object[]> result5 = query5.getResultList();
		for (Object[] row : result5) {
			System.out.println("Puntuación: " + row[0] + " - Total: " + row[1]);
		}

		// Consultar els noms dels estudiants dels lliuraments ordenats per nom
		System.out.println("------------------------------\nConsulta6");

		Query query6 = em.createQuery("SELECT DISTINCT l.estudiant.nom FROM Lliurament l ORDER BY l.estudiant.nom");
		List<String> result6 = query6.getResultList();
		for (String nom : result6) {
			System.out.println("nom: " + nom);
		}

		// Consultar els noms dels estudiants en majúscules i els cognoms en
		// minúscules ordenats per edat
		System.out.println("------------------------------\nConsulta7");

		Query query7 = em.createQuery("SELECT UPPER(e.nom), LOWER(e.cognoms) FROM Estudiant e ORDER BY e.edat");
		@SuppressWarnings("unchecked")
		List<Object[]> result7 = query7.getResultList();
		for (Object[] resultado : result7) {
			String nombreEnMayusculas = (String) resultado[0];
			String apellidosEnMinusculas = (String) resultado[1];
			System.out.println("Nombre: " + nombreEnMayusculas + ", Apellidos: " + apellidosEnMinusculas);
		}

		// Consultar 10 primers caràcters del text de les preguntes ordenats per
		// puntuació descendent
		System.out.println("------------------------------\nConsulta8");
		Query query8 = em.createQuery("SELECT SUBSTRING(p.text, 1, 10) FROM Pregunta p ORDER BY p.puntuacio DESC");
		List<String> result8 = query8.getResultList();
		for (String nom : result8) {
			System.out.println("10 primers caràcters : " + nom);
		}

		// Consultar 10 darrers caràcters del text de les preguntes ordenats per
		// puntuació ascendent

		// TODO Consulta el text de les preguntes traient espais del principi i del
		// final
		// TODO Consulta el text de les preguntes traient els caràcters ': ' del final
		// TODO Consulta el text de les preguntes de Verdader Fals traient el caràcter
		// '-' del principi
		// TODO Consultar els lliuraments de tots els alumnes amb nom el següent patró
		// '_a%'
		// TODO Consultar les preguntes amb puntuació entre 1 i 1.5 inclosos ordenades
		// per text
		// TODO Consultar exàmens (mòdul i títol de la unitat formativa) i la suma de
		// les puntuacions de les seves preguntes ordenats per puntuació descendent
	}

	private static void consultesParametres() {
		// TODO Consultar total de preguntes agrupades per puntuació sempre que el total
		// de preguntes sigui > PARAM, on PARAM és un paràmetre variable
		// TODO Consultar preguntes verdader o fals que continguin el text PARAM1 i
		// puntuació inferior o igual a PARAM2, on PARAM1 i PARAM2 és un paràmetre
		// variable (Feu servir la opció de paràmetres numerats: 1, 2, ..)
		// TODO Consultar preguntes que text de més de PARAM caràcters, ordenades per
		// mida del text, on PARAM és un paràmetre variable
		// TODO Consultar les preguntes amb puntuació entre 1 i 1.5 inclosos ordenades
		// per text
	}

	private static void consultesPaginacio() {
		// TODO Per una mida de pàgina de 3, obtenir la primera pàgina de la consulta
		// dels noms, cognoms i edat dels estudiants ordenats per longitud de
		// nom+cognoms
		// TODO Obtenir la segona pagina de la consulta anterior
		// TODO Obtenir la darrera pagina de la consulta anterior
	}

	private static void consultesJoin() {
		// TODO Consultar el nom, cognoms i edat dels alumnes i la nota dels diferents
		// Lliuraments ordenats per nota
		// TODO Consultar TOTS els exàmens i les seves preguntes si escau. Cal mostrar
		// cicle i número de la Unitat Formativa de l'examen i el text i la puntuació de
		// la pregunta. Ordenat per cicle i número
		// TODO Consultar preguntes dels exàmens que tinguin puntuació superior a
		// PARAM1, on PARAM és un paràmetre variable. Cal mostrar cicle i número de la
		// Unitat Formativa de l'examen i el text i la puntuació de la pregunta. Ordenat
		// per puntuació descendent
		// TODO Consultar lliuraments d'exàmens amb més de PARAM preguntes, on PARAM és
		// un paràmetre variable. Cal mostrar cicle i número de la Unitat Formativa de
		// l'examen, el total de preguntes de l'examen i el nom,cognoms i edat de
		// l'alumne que ha fet el lliurament. Ordenat pel total de preguntes de l'examen
		// i per nom i cognoms de l'alumne.
	}
}
