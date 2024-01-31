package Exercici6;

import java.util.ArrayList;
import java.util.List;

public class Exercici6 {

	public static void main(String[] args) {

		List<Figura> figures = new ArrayList<>();

		Triangle triangle = new Triangle();
		triangle.setAlcada(10);
		triangle.setBase(20);
		figures.add(triangle);

		Quadrat quadrat = new Quadrat();
		quadrat.setCostat(10);
		figures.add(quadrat);

		Recta recta = new Recta();
		figures.add(recta);

		// Iterar en ordre d'entrada
		for (Figura figura : figures) {
			System.out.println(figura.getNom() + ": " + figura.numCostats());
		}

		// Iterar en ordre invers
		for (int i = figures.size() - 1; i >= 0; i--) {
			Figura figura = figures.get(i);
			System.out.println(figura.getNom() + ": " + figura.numCostats());
		}

	}

}
