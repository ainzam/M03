package m3.uf4.pe1.reserves;

import java.util.Date;

public interface Reservable {

	public boolean afegirReserva(Date dia);

	public boolean consultaReserva(Date dia);

	public boolean anullarReserva(Date dia);

}
