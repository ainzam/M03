package exercici26;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Exercici26 {
	public static void main(String[] args) {
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(new Ingrediente("Macarrons", 5.10, false));
		ingredientes.add(new Ingrediente("Crema de llet", 4.00, false));
		ingredientes.add(new Ingrediente("Bacon", 3.20, false));

		List<Ingrediente> postreIngredientes = new ArrayList<>();
		postreIngredientes.add(new Ingrediente("Taronja", 1.00, true));
		postreIngredientes.add(new Ingrediente("Pera", 1.00, true));
		postreIngredientes.add(new Ingrediente("Pinya", 1.50, true));

		// Mostrar lista de ingredientes
		System.out.println("Macarrons Carbonara, preu: 12,30€");
		System.out.println("# Nom          Preu   Fruita");
		System.out.println(StringUtils.repeat("-", 31));
		for (int i = 0; i < ingredientes.size(); i++) {
			Ingrediente ingrediente = ingredientes.get(i);
			String nombreAlineado = StringUtils.rightPad(ingrediente.getNombre(), 15);
			String precioAlineado = StringUtils.rightPad(String.format("%.2f €", ingrediente.getPrecio()), 9);
			String frutaAlineada = ingrediente.tieneFruta() ? "Si" : "No";
			System.out.printf("%d- %s %s %s%n", i + 1, nombreAlineado, precioAlineado, frutaAlineada);
		}

		// Mostrar lista de postre
		System.out.println("\nPostre: Macedònia, preu: 3,15€");
		System.out.println("No cal fer servir el forn");
		System.out.println("# Nom          Preu   Fruita");
		System.out.println(StringUtils.repeat("-", 31));
		for (int i = 0; i < postreIngredientes.size(); i++) {
			Ingrediente ingrediente = postreIngredientes.get(i);
			String nombreAlineado = StringUtils.rightPad(ingrediente.getNombre(), 15);
			String precioAlineado = StringUtils.rightPad(String.format("%.2f €", ingrediente.getPrecio()), 9);
			String frutaAlineada = ingrediente.tieneFruta() ? "Si" : "No";
			System.out.printf("%d- %s %s %s%n", i + 1, nombreAlineado, precioAlineado, frutaAlineada);
		}

	}
}

class Ingrediente {
	private String nombre;
	private double precio;
	private boolean tieneFruta;

	public Ingrediente(String nombre, double precio, boolean tieneFruta) {
		this.nombre = nombre;
		this.precio = precio;
		this.tieneFruta = tieneFruta;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public boolean tieneFruta() {
		return tieneFruta;
	}
}
