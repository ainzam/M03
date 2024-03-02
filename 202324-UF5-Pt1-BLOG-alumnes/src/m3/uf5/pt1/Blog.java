package m3.uf5.pt1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

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


    public void nouUsuari(String mail, String nick) {
        for (Usuari usuari : usuaris) {
            if (usuari.getMail().equals(mail) || usuari.getNick().equals(nick)) {
                throw new IllegalArgumentException("Ja existeix un usuari amb aquest mateix mail o nick.");
            }
        }
        Usuari nouUsuari = new Usuari(nick, mail);
        usuaris.add(nouUsuari);
    }

    public void afegirEntrada(String mail, String titol, String text) {
        Usuari usuari = cercarUsuariPerMail(mail);
        if (usuari != null) {
            for (Entrada entrada : entrades) {
                if (entrada.getUsuario().equals(usuari) && entrada.getTitol().equals(titol)) {
                    throw new IllegalArgumentException("Ja existeix una entrada amb aquest mateix títol per a aquest usuari.");
                }
            }
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
        String header = String.format("BLOG UF5 - PE1 (%d usuaris/es, %d entrades)", usuaris.size(), entrades.size());
        int totalWidth = AMPLE_LEFT + GAP + AMPLE_CONTENT;
        int headerWidth = header.length();
        int spacesCount = (totalWidth - headerWidth) / 2;

        sb.append(" ".repeat(spacesCount)).append(header).append(" ".repeat(spacesCount)).append("\n");
        sb.append("^".repeat(totalWidth)).append("\n");

        for (Entrada entrada : entrades) {
            String dateFormat = new SimpleDateFormat("MMM yyyy").format(entrada.getData()).toUpperCase();

            String valoraciones = String.format(
                "%s %s:\n%s\n" +
                "0-Stars : %d\n" +
                "1-Stars : %d\n" +
                "2-Stars : %d\n" +
                "3-Stars : %d\n" +
                "Mitjana : %s",
                WordUtils.capitalize(dateFormat),
                entrada.getUsuario().getNick(),
                entrada.getUsuario().nivellUsuari(),
                entrada.totalValoracionsPerValor(0),
                entrada.totalValoracionsPerValor(1),
                entrada.totalValoracionsPerValor(2),
                entrada.totalValoracionsPerValor(3),
                entrada.valoracioMitjaEntrada());


            String[] linesValoraciones = valoraciones.split("\\r?\\n");
            String[] linesEntrada = entrada.imprimirPublicacio("", AMPLE_CONTENT).split("\\r?\\n");

            for (int i = 0; i < Math.max(linesValoraciones.length, linesEntrada.length); i++) {
                String lineValoraciones = (i < linesValoraciones.length) ? StringUtils.rightPad(linesValoraciones[i], AMPLE_LEFT) : StringUtils.repeat(" ", AMPLE_LEFT);
                String lineEntrada = (i < linesEntrada.length) ? linesEntrada[i] : "";

                sb.append(lineValoraciones).append(Entrada.SEPARADOR + StringUtils.repeat(" ", GAP)).append(lineEntrada).append("\n");
            }
            sb.append("\n");
            for (Comentari comentario : entrada.getComentaris()) {
                sb.append(comentario.imprimirPublicacio("", AMPLE_CONTENT)).append("\n");
            }

            sb.append("\n");
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
            if (entrada.getTitol().equals(titol)) {
                return entrada;
            }
        }
        return null;
    }
	
    public Set<Entrada> getEntrades() {
		return entrades;
	}


	public Set<Usuari> getUsuaris() {
		return usuaris;
	}


	public void setUsuaris(Set<Usuari> usuaris) {
		this.usuaris = usuaris;
	}


	public void setEntrades(Set<Entrada> entrades) {
		this.entrades = entrades;
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