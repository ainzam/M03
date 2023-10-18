package exercici16;

public class Exercici16 {
	final static double PI = 3.1416;

	public static void main(String[] args) {

		double radio = Double.parseDouble(args[0]);
		double area = calcularAreaCirculo(radio);
		System.out.println("El área del círculo con radio " + radio + " es: " + area);

	}

	public static double calcularAreaCirculo(double radio) {
		
		double area = PI * radio * radio; 

		return area;
	}
}
