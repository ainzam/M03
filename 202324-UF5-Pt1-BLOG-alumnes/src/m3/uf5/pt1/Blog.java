package m3.uf5.pt1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
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
		try {
			if (mail == null || nick == null || mail.isEmpty() || nick.isEmpty()) {
				throw new Exception("Mail o nick no pueden ser nulos o vacíos.");
			}

			Iterator<Usuari> usuariIterator = usuaris.iterator();
			while (usuariIterator.hasNext()) {
				Usuari usuari = usuariIterator.next();
				if (usuari.getMail().equals(mail) || usuari.getNick().equals(nick)) {
					throw new Exception("Ya existe un usuario con este mismo mail o nick.");
				}
			}

			Usuari nouUsuari = new Usuari(nick, mail);
			usuaris.add(nouUsuari);
		} catch (Exception e) {
			System.err.println("Error al crear un nuevo usuario: " + e.getMessage());
		}
	}

	public void afegirEntrada(String mail, String titol, String text) {
		try {
			if (titol == null || titol.isEmpty()) {
				throw new Exception("El título no puede ser nulo o vacío.");
			}

			Usuari usuari = cercarUsuariPerMail(mail);
			if (usuari != null) {
				for (Entrada entrada : entrades) {
					if (entrada.getUsuario().equals(usuari) && entrada.getTitol().equals(titol)) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String fechaEntrada = dateFormat.format(entrada.getData());
						String fechaActual = dateFormat.format(new Date());
						if (fechaEntrada.equals(fechaActual)) {
							throw new Exception(
									"Ya existe una entrada con este mismo título para este usuario en el mismo día.");
						}
					}
				}
				Entrada novaEntrada = new Entrada(usuari, titol, text);
				entrades.add(novaEntrada);
			} else {
				throw new Exception("Usuario no encontrado.");
			}
		} catch (Exception e) {
			System.err.println("Error al agregar una nueva entrada: " + e.getMessage());
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

		String header = String.format("BLOG UF5 - PE1 (%d usuaris/es, %d entrades)", usuaris.size(), entrades.size());
		int totalWidth = AMPLE_LEFT + GAP + AMPLE_CONTENT;
		int headerWidth = header.length();
		int spacesCount = (totalWidth - headerWidth) / 2;

		sb.append(" ".repeat(spacesCount)).append(header).append(" ".repeat(spacesCount)).append("\n");
		sb.append("^".repeat(totalWidth)).append("\n");

		for (Entrada entrada : entrades) {
			String dateFormat = new SimpleDateFormat("MMM yyyy").format(entrada.getData()).toUpperCase();

			String valoraciones = String.format(
					"%s %s:\n%s\n" + "0-Stars : %d\n" + "1-Stars : %d\n" + "2-Stars : %d\n" + "3-Stars : %d\n"
							+ "Mitjana : %s",
					WordUtils.capitalize(dateFormat), entrada.getUsuario().getNick(),
					entrada.getUsuario().nivellUsuari(), entrada.totalValoracionsPerValor(0),
					entrada.totalValoracionsPerValor(1), entrada.totalValoracionsPerValor(2),
					entrada.totalValoracionsPerValor(3), entrada.valoracioMitjaEntrada());

			String[] linesValoraciones = valoraciones.split("\\r?\\n");
			String[] linesEntrada = entrada.imprimirPublicacio("", AMPLE_CONTENT).split("\\r?\\n");

			for (int i = 0; i < Math.max(linesValoraciones.length, linesEntrada.length); i++) {
				String lineValoraciones = (i < linesValoraciones.length)
						? StringUtils.rightPad(linesValoraciones[i], AMPLE_LEFT)
						: StringUtils.repeat(" ", AMPLE_LEFT);
				String lineEntrada = (i < linesEntrada.length) ? linesEntrada[i] : "";

				sb.append(lineValoraciones).append(Entrada.SEPARADOR + StringUtils.repeat(" ", GAP)).append(lineEntrada)
						.append("\n");
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
		try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fitxer)))) {
			encoder.writeObject(usuaris);
			encoder.writeObject(entrades);
		} catch (IOException e) {
			System.err.println("Error al guardar datos del blog en formato XML: " + e.getMessage());
		}
	}

	public void carregarDadesBlog(String fitxer) {
		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fitxer)))) {
			@SuppressWarnings("unchecked")
			Set<Usuari> usuarios = (Set<Usuari>) decoder.readObject();
			@SuppressWarnings("unchecked")
			Set<Entrada> entradas = (Set<Entrada>) decoder.readObject();

			this.usuaris = usuarios;
			this.entrades = entradas;
		} catch (IOException | ClassCastException e) {
			System.err.println("Error al cargar datos del blog desde el archivo XML: " + e.getMessage());
		}
	}

	public Entrada cercarEntradaPerDataTitol(Date data, String titol) {
		Iterator<Entrada> entradaIterator = entrades.iterator();
		while (entradaIterator.hasNext()) {
			Entrada entrada = entradaIterator.next();
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
		Iterator<Usuari> usuariIterator = usuaris.iterator();
		while (usuariIterator.hasNext()) {
			Usuari usuari = usuariIterator.next();
			if (usuari.getMail().equals(mail)) {
				return usuari;
			}
		}
		return null;
	}

	public Usuari cercarUsuariPerNick(String nick) {
		Iterator<Usuari> usuariIterator = usuaris.iterator();
		while (usuariIterator.hasNext()) {
			Usuari usuari = usuariIterator.next();
			if (usuari.getNick().equals(nick)) {
				return usuari;
			}
		}
		return null;
	}

}