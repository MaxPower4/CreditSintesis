package PlansEstudi;

import java.lang.reflect.Type;

public class ContingutPla implements Type {
	private String ID;
	private String codi;
	private String nom;
	private String categoria;
	private String tipus;
	
	public ContingutPla(String iD, String codi, String nom, String categoria, String tipus) {
		super();
		ID = iD;
		this.codi = codi;
		this.nom = nom;
		this.categoria = categoria;
		this.tipus = tipus;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	@Override
	public String toString() {
		return "ContingutPla [ID=" + ID + ", codi=" + codi + ", nom=" + nom + ", categoria=" + categoria + ", tipus="
				+ tipus + "]";
	}
}
