package exercici9;

public class exercici9 {
	public static void main(String[] args) {

		int[] vector = { 4, 5, 6, 7 };

		int suma = funcioSuma(vector);

		System.out.println("la suma del vector es:" + suma);

	};

	public static int funcioSuma(int[] vector) {

		int suma = 0;

		for (int i = 0; i < vector.length; i++) {

			suma += vector[i];

		}

		return suma;
	};
}
