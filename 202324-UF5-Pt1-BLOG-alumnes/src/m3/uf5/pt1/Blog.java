package m3.uf5.pt1;

import java.util.Collection;
import java.util.Date;

public class Blog {
	
	public static final int AMPLE_LEFT = 15;
	public static final int GAP = 3;
	public static final int AMPLE_CONTENT = 60;
	
	public Collection<Usuari> usuaris;
	public Collection<Entrada> entrades;
	
	public Blog() {
	}

	public void nouUsuari(String nick, String mail) {
		// TODO Auto-generated method stub
		
	}

	public void afegirEntrada(String mail, String text, String titol) {
		// TODO Auto-generated method stub
		
	}

	public void comentarEntrada(String mail, Date data, String titol, String text, int valoracio) {
		// TODO Auto-generated method stub
		
	}
	
	public String imprimirEntrada(Date data, String titol) {
		// TODO Auto-generated method stub
		return null;
	}

	public String imprimirBlog() {
		return null;
		// TODO Auto-generated method stub
	}
	
	public void desarDadesBlog(String fitxer) {
		// TODO Auto-generated method stub
	}
	
	public void carregarDadesBlog(String fitxer) {
		// TODO Auto-generated method stub
	}
	
	public Entrada cercarEntradaPerDataTitol(Date data,String titol) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuari cercarUsuariPerMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuari cercarUsuariPerNick(String nick) {
		// TODO Auto-generated method stub
		return null;
	}	
	

}
