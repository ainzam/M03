package m3.uf5.pt1;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Blog {
	
	public static final int AMPLE_LEFT = 15;
    public static final int GAP = 3;
    public static final int AMPLE_CONTENT = 60;

    public Set<Usuari> usuaris; 
    public Set<Entrada> entrades; 

    public Blog() {
        usuaris = new TreeSet<>(); 
        entrades = new TreeSet<>();
    }


    public void nouUsuari(String nick, String mail) {
        for (Usuari usuari : usuaris) {
            if (usuari.getMail().equals(mail) || usuari.getNick().equals(nick)) {
                throw new IllegalArgumentException("Ja existeix un usuari amb aquest mateix mail o nick.");
            }
        }
        Usuari nouUsuari = new Usuari(nick, mail);
        usuaris.add(nouUsuari);
    }

    public void afegirEntrada(String mail, String text, String titol) {
        Date dataActual = new Date();
        for (Entrada entrada : entrades) {
            if (entrada.getData().equals(dataActual) && entrada.getTitol().equals(titol)) {
                throw new IllegalArgumentException("Ja existeix una entrada per la data actual amb aquest mateix títol.");
            }
        }
        Usuari usuari = cercarUsuariPerMail(mail);
        if (usuari != null) {
            Entrada novaEntrada = new Entrada(usuari, titol, text);
            entrades.add(novaEntrada);
        } else {
            throw new IllegalArgumentException("Usuari no trobat.");
        }
    }

    public void comentarEntrada(String mail, Date data, String titol, String text, int valoracio) {
        Entrada entrada = cercarEntradaPerDataTitol(data, titol);
        if (entrada != null) {
            entrada.afegirComentari(cercarUsuariPerMail(mail), text, valoracio);
        } else {
            throw new IllegalArgumentException("Entrada no trobada.");
        }
    }
	
    public String imprimirEntrada(Date data, String titol) {
        Entrada entrada = cercarEntradaPerDataTitol(data, titol);
        if (entrada != null) {
            return entrada.imprimirPublicacio("", AMPLE_CONTENT);
        } else {
            throw new IllegalArgumentException("No s'ha trobat cap entrada per la data i el títol especificats.");
        }
    }

    public String imprimirBlog() {
        StringBuilder sb = new StringBuilder();

        // Cabecera
        String header = String.format("^ Usuaris: %d | Entrades: %d ^", usuaris.size(), entrades.size());
        String underline = "^".repeat((AMPLE_LEFT + GAP + AMPLE_CONTENT - header.length()) / 2);
        sb.append(underline).append(header).append(underline).append("\n");

        // Imprimir entradas
        for (Entrada entrada : entrades) {
            sb.append(entrada.imprimirPublicacio("", AMPLE_CONTENT)).append("\n");
        }

        return sb.toString();
    }

	
	public void desarDadesBlog(String fitxer) {
		// TODO Auto-generated method stub
	}
	
	public void carregarDadesBlog(String fitxer) {
		// TODO Auto-generated method stub
	}
	
    public Entrada cercarEntradaPerDataTitol(Date data, String titol) {
        for (Entrada entrada : entrades) {
            if (entrada.getData().equals(data) && entrada.getTitol().equals(titol)) {
                return entrada;
            }
        }
        return null;
    }
	
    public Usuari cercarUsuariPerMail(String mail) {
        for (Usuari usuari : usuaris) {
            if (usuari.getMail().equals(mail)) {
                return usuari;
            }
        }
        return null; 
    }
	
    public Usuari cercarUsuariPerNick(String nick) {
        for (Usuari usuari : usuaris) {
            if (usuari.getNick().equals(nick)) {
                return usuari;
            }
        }
        return null; 
    }	
	

}