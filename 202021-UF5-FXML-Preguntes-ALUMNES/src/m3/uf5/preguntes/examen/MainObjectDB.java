package m3.uf5.preguntes.examen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import m3.uf5.preguntes.examen.model.Excepcio;

public class MainObjectDB {
	public static final String ODB = "$objectdb/db/examen.odb";

	public static void main(String[] args) throws Excepcio {
		// MainAvaluacio.main(args);

		consultesInicials();
		consultesParametres();
		consultesPaginacio();
		consultesJoin();
	}

	private static void consultesInicials() {
		// TODO Consultar total, màxim, mínima i mitjana puntuacions de preguntes
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(MainObjectDB.ODB); // Accés a la factoria
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery(
				"SELECT SUM(p.puntuacio), MAX(p.puntuacio), MIN(p.puntuacio), AVG(p.puntuacio) FROM Pregunta p");

		Object[] result = (Object[]) query.getSingleResult();

		System.out.println("Suma Total: " + result[0] + " Maximo: " + result[1] + " Minimo: " + result[2] + " Media: "
				+ result[3]);

		em.close();
		emf.close();
		// TODO Consultar preguntes que continguin el text "cert" ordenades per
		// puntuació

		// TODO Consultar preguntes verdader o fals que continguin el text "cert" i
		// puntuació inferior o igual a 1
		// TODO Consultar preguntes que text de més de 50 caràcters, ordenades per mida
		// del text
		// TODO Consultar total de preguntes agrupades per puntuació
		// TODO Consultar els noms dels estudiants dels lliuraments ordenats per nom
		// TODO Consultar els noms dels estudiants en majúscules i els cognoms en
		// minúscules ordenats per edat
		// TODO Consultar 10 primers caràcters del text de les preguntes ordenats per
		// puntuació descendent
		// TODO Consultar 10 darrers caràcters del text de les preguntes ordenats per
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
