package exercici15;

public class Exercici15 {
	public static void main(String[] args) {
	    int[] valores = {3, 5};
	    System.out.println("Antes del intercambio: " + valores[0] + ", " + valores[1]);
	    
	    intercambiar(valores, 0, 1);
	    
	    System.out.println("Después del intercambio: " + valores[0] + ", " + valores[1]);
	}
	/* Idea basica de como intercambiar pero no sirve en java
	 public void intercambiar(int a, int b) {
	    int temp = a; 
	    a = b;
	    b = temp;
	}*/
	
	// Esta si sirve porque se le envia un array que es un odjeto y se le envia una
	//referencia del objeto a la función y la función cambia el objeto 
	public static void intercambiar(int[] arr, int indice1, int indice2) {
	    if (indice1 < arr.length && indice2 < arr.length) {
	        int temp = arr[indice1];
	        arr[indice1] = arr[indice2];
	        arr[indice2] = temp;
	    }
	}
}
