package Alumnes;

//Clase Contacte dels Alumnes
public class Contacte {
	private String contacte;
	private String tipus;
	private String Descripcio;
	
	public Contacte(String contacte, String tipus, String descripcio) {
		super();
		this.contacte = contacte;
		this.tipus = tipus;
		Descripcio = descripcio;
	}

	public String getContacte() {
		return contacte;
	}

	public void setContacte(String contacte) {
		this.contacte = contacte;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public String getDescripcio() {
		return Descripcio;
	}

	public void setDescripcio(String descripcio) {
		Descripcio = descripcio;
	}

	@Override
	public String toString() {
		return "Contacte [contacte=" + contacte + ", tipus=" + tipus + ", Descripcio=" + Descripcio + "]\n";
	}
	
	
	
}
