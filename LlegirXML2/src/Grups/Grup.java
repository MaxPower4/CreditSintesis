package Grups;

public class Grup {
	private String id;
	private String codi;
	private String nom;
	private String etapa;
	private String subetapa;
	private int nivell;
	private int regim;
	
	public Grup(String id, String codi, String nom, String etapa, String subetapa, int nivell, int regim) {
		super();
		this.id = id;
		this.codi = codi;
		this.nom = nom;
		this.etapa = etapa;
		this.subetapa = subetapa;
		this.nivell = nivell;
		this.regim = regim;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getSubetapa() {
		return subetapa;
	}

	public void setSubetapa(String subetapa) {
		this.subetapa = subetapa;
	}

	public int getNivell() {
		return nivell;
	}

	public void setNivell(int nivell) {
		this.nivell = nivell;
	}

	public int getRegim() {
		return regim;
	}

	public void setRegim(int regim) {
		this.regim = regim;
	}

	@Override
	public String toString() {
		return "Grup [id=" + id + ", codi=" + codi + ", nom=" + nom + ", etapa=" + etapa + ", subetapa=" + subetapa
				+ ", nivell=" + nivell + ", regim=" + regim + "]\n";
	}
	
	
}
