package m3.utils;

public class DiesSetmana {

    public static String obtenirDiaSetmana(int numero) {
        switch (numero) {
            case 1:
                return "Dilluns"; 
            case 2:
                return "Dimarts";
            case 3:
                return "Dimecres";
            case 4:
                return "Dijous";
            case 5:
                return "Divendres";
            case 6:
                return "Dissabte";
            case 7:
                return "Diumenge";
            default:
                return "Número de dia no vàlid";
        }
    }
}
