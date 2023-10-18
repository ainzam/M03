package exercici25;

import m3.utils.DiesSetmana;

public class Exercici25 {
	public static void main(String[] args) {
        int numeroDia = 3;
        String diaSetmana = DiesSetmana.obtenirDiaSetmana(numeroDia);
        System.out.println("El número " + numeroDia + " corresponde al día de la semana: " + diaSetmana);
    } 
}
