package m3.uf4.pt1.fitxers;

import java.io.IOException;

public class MainTestSistemaFitxers {

	public static void main(String[] args) throws IOException {
		SistemaFitxers sistema = new SistemaFitxers();

		System.out.println("###### 1. IMPRIMIR SISTEMA KB" + System.lineSeparator());
		System.out.println(sistema.imprimir('K'));
		System.out.println();

		Directori arrel = sistema.getArrel();

		System.out.println("###### 2. CONSULTES ARREL BUIDA" + System.lineSeparator());
		System.out.println("    ID (1): " + arrel.getId());
		System.out.println("    nom (\"/\"): " + arrel.getNom());
		System.out.println("    elements (0): " + arrel.countElements());
		System.out.println("    depth (0): " + arrel.getDepth());
		System.out.println("    Mida (0): " + arrel.getMida());
		System.out.println("    Arrel (\"/\"): " + arrel.getRoot().getNom());
		System.out.println();

		System.out.println("###### 3. IMPRIMIR ARREL BUIDA B" + System.lineSeparator());
		System.out.println(arrel.imprimir('B'));
		System.out.println();

		System.out.println("###### 4. AFEGIR FITXER \"proves.txt\" i IMPRIMIR ARREL B" + System.lineSeparator());
		Fitxer file1 = new Fitxer("proves.txt", 1048576);
		arrel.addElement(file1);

		System.out.println(arrel.imprimir('B'));
		System.out.println();

		System.out.println(
				"###### 5. AFEGIR FITXER \"virus_destruccio_total.exe\" i IMPRIMIR ARREL KB" + System.lineSeparator());
		Fitxer file2 = new Fitxer("virus_destruccio_total.exe", 5242880);
		arrel.addElement(file2);

		System.out.println(arrel.imprimir('K'));
		System.out.println();

		System.out.println(
				"###### 6. AFEGIR DIRECTORIS \"bin\" \"etc\" \"home\" \"lib\" \"usr\" \"var\" i IMPRIMIR SISTEMA FITXERS MB"
						+ System.lineSeparator());
		Directori dirBin = new Directori("bin");
		Directori dirEtc = new Directori("etc");
		Directori dirHome = new Directori("home");
		Directori dirLib = new Directori("lib");
		Directori dirUsr = new Directori("usr");
		Directori dirVar = new Directori("var");
		arrel.addElement(dirBin);
		arrel.addElement(dirEtc);
		arrel.addElement(dirHome);
		arrel.addElement(dirLib);
		arrel.addElement(dirUsr);
		arrel.addElement(dirVar);

		System.out.println(sistema.imprimir('M'));
		System.out.println();

		System.out.println(
				"###### 7. AFEGIR DIRECTORIS \"usuari/Escriptori\" DINS \"home\", AFEGIR FITXER \"usuari/.profile\""
						+ System.lineSeparator() + "######    i IMPRIMIR DIRECTORI \"/usuari\"  B"
						+ System.lineSeparator());
		Directori dirHomeUsuari = new Directori("usuari");
		Directori dirHomeUsuariDesktop = new Directori("Escriptori");
		Fitxer profile = new Fitxer(".profile", 3);

		dirHome.addElement(dirHomeUsuari);
		dirHomeUsuari.addElement(dirHomeUsuariDesktop);
		dirHomeUsuari.addElement(profile);

		System.out.println(dirHomeUsuari.imprimir('B'));
		System.out.println();

		System.out.println("###### 8. AFEGIR DIRECTORI \"bin\" DINS \"/usr\", AFEGIR FITXERS \"ifconfig\" \"netstat\""
				+ System.lineSeparator() + "######    i IMPRIMIR DIRECTORI \"/usr\" KB" + System.lineSeparator());
		Directori dirUsrBin = new Directori("bin");
		dirUsr.addElement(dirUsrBin);
		Fitxer ifconfig = new Fitxer("ifconfig", 68360);
		Fitxer netstat = new Fitxer("netstat", 120200);
		dirUsrBin.addElement(ifconfig);
		dirUsrBin.addElement(netstat);

		System.out.println(dirUsr.imprimir('K'));
		System.out.println();

		System.out.println("###### 9. CONSULTES DIRECTORI \"/usr\"" + System.lineSeparator());
		System.out.println("    ID (8): " + dirUsr.getId());
		System.out.println("    nom (\"usr\"): " + dirUsr.getNom());
		System.out.println("    nom (\"/usr\"): " + dirUsr.getPath());
		System.out.println("    elements (1): " + dirUsr.countElements());
		System.out.println("    depth (1): " + dirUsr.getDepth());
		System.out.println("    Mida (188572): " + dirUsr.getMida());
		System.out.println("    Arrel (\"/\"): " + dirUsr.getRoot().getNom());
		System.out.println();

		System.out.println("###### 10. CONSULTES DIRECTORI \"/usr/bin\"" + System.lineSeparator());
		System.out.println("    ID (13): " + dirUsrBin.getId());
		System.out.println("    nom (\"bin\"): " + dirUsrBin.getNom());
		System.out.println("    path (\"/usr/bin\"): " + dirUsrBin.getPath());
		System.out.println("    elements (2): " + dirUsrBin.countElements());
		System.out.println("    depth (2): " + dirUsrBin.getDepth());
		System.out.println("    Mida (188568): " + dirUsrBin.getMida());
		System.out.println("    Arrel (\"/\"): " + dirUsrBin.getRoot().getNom());
		System.out.println();

		System.out.println("###### 11. CONSULTES FITXER \"ifconfig\"" + System.lineSeparator());
		System.out.println("    ID (14): " + ifconfig.getId());
		System.out.println("    nom (\"ifconfig\"): " + ifconfig.getNom());
		System.out.println("    path (\"/usr/bin/ifconfig\"): " + ifconfig.getPath());
		System.out.println("    depth (3): " + ifconfig.getDepth());
		System.out.println("    Mida (68360): " + ifconfig.getMida());
		System.out.println();

		System.out.println(
				"###### 12. AFEGIR LINKS \"/bin/ifconfig\" que apunti a \"/usr/bin/ifconfig\", \"/bin/netstat\" que apunti a \"/usr/bin/netstat\""
						+ System.lineSeparator() + "######     i IMPRIMIR DIRECTORI \"/bin\" B"
						+ System.lineSeparator());

		Enllac linkIfconfig = new Enllac("ifconfig", ifconfig);
		Enllac linkNetstat = new Enllac("netstat", netstat);
		dirBin.addElement(linkIfconfig);
		dirBin.addElement(linkNetstat);

		System.out.println(dirBin.imprimir('B'));
		System.out.println();

		System.out.println(
				"###### 13. ESBORRAR DIRECTORI \"/home/usuari/Escriptori\", ESBORRAR FITXER \"/home/usuari/.profile\""
						+ System.lineSeparator() + "######     i IMPRIMIR DIRECTORI \"/home\"  MB"
						+ System.lineSeparator());

		dirHomeUsuari.removeElement(11);
		dirHomeUsuari.removeElement(12);

		System.out.println(dirHome.imprimir('B'));
		System.out.println();
	}

}
