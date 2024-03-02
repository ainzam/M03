package m3.uf5.pt1;

import java.util.LinkedList;
import java.util.Queue; // Importar Queue en lugar de List
import java.util.Objects;

public class Usuari implements Comparable<Usuari>{
    
    public static final int JUNIOR_LIMIT = 2;
    public static final int SENIOR_LIMIT = 5;
    
    private String nick;
    private String mail;
    public Queue<Publicacio> publicacions;

    public Usuari(String nick, String mail) {
        this.nick = nick;
        this.mail = mail;
        this.publicacions = new LinkedList<>();
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public void afegirPublicacio(Publicacio publicacio) {
        if (publicacio != null) {
            publicacions.offer(publicacio);
        }
    }
    
    public String nivellUsuari() {
        int numPublicacions = publicacions.size();
        if (numPublicacions <= JUNIOR_LIMIT) {
            return "Júnior";
        } else if (numPublicacions <= SENIOR_LIMIT) {
            return "Sènior";
        } else {
            return "Màster";
        }
    }
    
    @Override
    public int compareTo(Usuari other) {
        return this.mail.compareTo(other.mail);
    }

	@Override
	public int hashCode() {
		return Objects.hash(mail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuari other = (Usuari) obj;
		return Objects.equals(mail, other.mail);
	}


}
