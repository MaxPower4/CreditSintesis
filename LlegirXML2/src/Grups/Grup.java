package Grups;

import java.util.ArrayList;

public class Grup {
	private String id;
	private String codi;
	private String nom;
	private String etapa;
	private String subetapa;
	private String nivell;
	private String regim;
	ArrayList<Alumne> ListaAlumne = new ArrayList<Alumne>();
	
	public Grup(String id, String codi, String nom, String etapa, String subetapa, String nivell, String regim, ArrayList<Alumne> ListaAlumne) {
		super();
		this.id = id;
		this.codi = codi;
		this.nom = nom;
		this.etapa = etapa;
		this.subetapa = subetapa;
		this.nivell = nivell;
		this.regim = regim;
		this.ListaAlumne.addAll(ListaAlumne);
	}

	public ArrayList<Alumne> getListaAlumne() {
		return ListaAlumne;
	}

	public void setListaAlumne(Alumne listaAlumne) {
		this.ListaAlumne.add(listaAlumne);
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

	public String getNivell() {
		return nivell;
	}

	public void setNivell(String nivell) {
		this.nivell = nivell;
	}

	public String getRegim() {
		return regim;
	}

	public void setRegim(String regim) {
		this.regim = regim;
	}

	@Override
	public String toString() {
		return "Grup [id=" + id + ", codi=" + codi + ", nom=" + nom + ", etapa=" + etapa + ", subetapa=" + subetapa
				+ ", nivell=" + nivell + ", regim=" + regim + ", ListaAlumne=" + ListaAlumne + "]\n";
	}

	
	
}
