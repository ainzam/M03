package exercici17;

import java.util.Scanner;

public class Exercici17 {
	final static double PI = 3.1416;
	
	public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Por favor, ingrese el radio del círculo: ");
        double radio = leer.nextDouble();

        double area = calcularAreaCirculo(PI, radio);
        System.out.println("El área del círculo con radio " + radio + " es: " + area);

        leer.close(); 
    }
	public static double calcularAreaCirculo(double PI, double radio) {
		// Calcular el área del círculo
		double area = PI * radio * radio;
		return area;
	}
}
