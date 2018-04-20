package Alumnes;

import java.util.ArrayList;
import java.util.List;

//Clase Alumne
public class Alumnes {
	private String ID;
	private String Nom;
	private String Cognom1;
	private String Cognom2;
	private String DataNaixement;
	private String DocumentIdentitat;
	private String TipusDocument;
	private String Sexe;
	//Lista dels contanctes dels alumnes
	List<Contacte> listaConctacte;
	
	//Constructor amb tots els parametres
	public Alumnes(String id, String nom, String cognom1, String cognom2, String datanaixement, String documentidentitat,
			String tipusDocument, String sexe,List<Contacte> _listaConctacte) {
		super();
		this.ID = id;
		this.Nom = nom;
		this.Cognom1 = cognom1;
		this.Cognom2 = cognom2;
		this.DataNaixement = datanaixement;
		this.DocumentIdentitat = documentidentitat;
		this.TipusDocument = tipusDocument;
		this.Sexe = sexe;
		this.listaConctacte = new ArrayList<>();
		listaConctacte.addAll(_listaConctacte);
	}

	//Setters i Getters
	public List<Contacte> getListaConctacte() {
		return listaConctacte;
	}

	public void setListaConctacte(Contacte listaConctacte) {
		this.listaConctacte.add(listaConctacte);
	}

	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public String getCognom1() {
		return Cognom1;
	}

	public void setCognom1(String cognom1) {
		this.Cognom1 = cognom1;
	}

	public String getCognom2() {
		return Cognom2;
	}

	public void setCognom2(String cognom2) {
		this.Cognom2 = cognom2;
	}

	public String getDatanaixement() {
		return DataNaixement;
	}

	public void setDatanaixement(String datanaixement) {
		this.DataNaixement = datanaixement;
	}

	public String getDocumentidentitat() {
		return DocumentIdentitat;
	}

	public void setDocumentidentitat(String documentidentitat) {
		this.DocumentIdentitat = documentidentitat;
	}

	public String getTipusDocument() {
		return TipusDocument;
	}

	public void setTipusDocument(String tipusDocument) {
		this.TipusDocument = tipusDocument;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		this.Sexe = sexe;
	}

	@Override
	public String toString() {
		return "Alumnes [id=" + ID + ", nom=" + Nom + ", cognom1=" + Cognom1 + ", cognom2=" + Cognom2
				+ ", datanaixement=" + DataNaixement + ", documentidentitat=" + DocumentIdentitat + ", tipusDocument="
				+ TipusDocument + ", sexe=" + Sexe + "]\n";
	}
}
