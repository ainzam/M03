package figures;

public class Main {

	public static void main(String[] args) {
		// Crear un array de Figura para almacenar círculos y cuadrados
		Figura[] figuras = new Figura[4];

		// Crear e inicializar círculos y cuadrados
		figuras[0] = new Cercle();
		((Cercle) figuras[0]).setRadi(5);

		figuras[1] = new Cercle();
		((Cercle) figuras[1]).setRadi(3);

		figuras[2] = new Quadrat();
		((Quadrat) figuras[2]).setCostat(4);

		figuras[3] = new Quadrat();
		((Quadrat) figuras[3]).setCostat(6);

		// Calcular e imprimir los perímetros
		for (Figura figura : figuras) {
			double perimetre = figura.calcularPerimetre();
			System.out.println("Perímetro: " + perimetre + figura);
		}
	}
}