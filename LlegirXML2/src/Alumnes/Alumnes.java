package Alumnes;

import java.util.ArrayList;
import java.util.List;

public class Alumnes {
	private String id;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String datanaixement;
	private String documentidentitat;
	private String tipusDocument;
	private String sexe;
	List<Contacte> listaConctacte;
	
	public Alumnes(String id, String nom, String cognom1, String cognom2, String datanaixement, String documentidentitat,
			String tipusDocument, String sexe,List<Contacte> _listaConctacte) {
		super();
		this.id = id;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.datanaixement = datanaixement;
		this.documentidentitat = documentidentitat;
		this.tipusDocument = tipusDocument;
		this.sexe = sexe;
		this.listaConctacte = new ArrayList<>();
		listaConctacte.addAll(_listaConctacte);
	}

	public List<Contacte> getListaConctacte() {
		return listaConctacte;
	}

	public void setListaConctacte(Contacte listaConctacte) {
		this.listaConctacte.add(listaConctacte);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public String getDatanaixement() {
		return datanaixement;
	}

	public void setDatanaixement(String datanaixement) {
		this.datanaixement = datanaixement;
	}

	public String getDocumentidentitat() {
		return documentidentitat;
	}

	public void setDocumentidentitat(String documentidentitat) {
		this.documentidentitat = documentidentitat;
	}

	public String getTipusDocument() {
		return tipusDocument;
	}

	public void setTipusDocument(String tipusDocument) {
		this.tipusDocument = tipusDocument;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Alumnes [id=" + id + ", nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2
				+ ", datanaixement=" + datanaixement + ", documentidentitat=" + documentidentitat + ", tipusDocument="
				+ tipusDocument + ", sexe=" + sexe + "]\n";
	}
	
	
	
	
}
