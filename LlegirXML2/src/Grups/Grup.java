package Grups;

import java.util.ArrayList;

public class Grup {
	private String ID;
	private String Codi;
	private String Nom;
	private String Etapa;
	private String Subetapa;
	private String Nivell;
	private String Regim;
	ArrayList<Alumne> ListaAlumne = new ArrayList<Alumne>();
	
	public Grup(String id, String codi, String nom, String etapa, String subetapa, String nivell, String regim, ArrayList<Alumne> ListaAlumne) {
		super();
		this.ID = id;
		this.Codi = codi;
		this.Nom = nom;
		this.Etapa = etapa;
		this.Subetapa = subetapa;
		this.Nivell = nivell;
		this.Regim = regim;
		this.ListaAlumne.addAll(ListaAlumne);
	}

	public ArrayList<Alumne> getListaAlumne() {
		return ListaAlumne;
	}

	public void setListaAlumne(Alumne listaAlumne) {
		this.ListaAlumne.add(listaAlumne);
	}

	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public String getCodi() {
		return Codi;
	}

	public void setCodi(String codi) {
		this.Codi = codi;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public String getEtapa() {
		return Etapa;
	}

	public void setEtapa(String etapa) {
		this.Etapa = etapa;
	}

	public String getSubetapa() {
		return Subetapa;
	}

	public void setSubetapa(String subetapa) {
		this.Subetapa = subetapa;
	}

	public String getNivell() {
		return Nivell;
	}

	public void setNivell(String nivell) {
		this.Nivell = nivell;
	}

	public String getRegim() {
		return Regim;
	}

	public void setRegim(String regim) {
		this.Regim = regim;
	}

	@Override
	public String toString() {
		return "Grup [id=" + ID + ", codi=" + Codi + ", nom=" + Nom + ", etapa=" + Etapa + ", subetapa=" + Subetapa
				+ ", nivell=" + Nivell + ", regim=" + Regim + ", ListaAlumne=" + ListaAlumne + "]\n";
	}

	
	
}
