package Alumnes;

import java.sql.Date;

public class Alumnes {
	private String id;
	private String nom;
	private String cognom1;
	private String cognom2;
	private Date datanaixement;
	private String documentidentitat;
	private char tipusDocument;
	private char sexe;
	
	public Alumnes(String id, String nom, String cognom1, String cognom2, Date datanaixement, String documentidentitat,
			char tipusDocument, char sexe) {
		super();
		this.id = id;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.datanaixement = datanaixement;
		this.documentidentitat = documentidentitat;
		this.tipusDocument = tipusDocument;
		this.sexe = sexe;
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

	public Date getDatanaixement() {
		return datanaixement;
	}

	public void setDatanaixement(Date datanaixement) {
		this.datanaixement = datanaixement;
	}

	public String getDocumentidentitat() {
		return documentidentitat;
	}

	public void setDocumentidentitat(String documentidentitat) {
		this.documentidentitat = documentidentitat;
	}

	public char getTipusDocument() {
		return tipusDocument;
	}

	public void setTipusDocument(char tipusDocument) {
		this.tipusDocument = tipusDocument;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Alumnes [id=" + id + ", nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2
				+ ", datanaixement=" + datanaixement + ", documentidentitat=" + documentidentitat + ", tipusDocument="
				+ tipusDocument + ", sexe=" + sexe + "]\n";
	}
	
	
	
	
}
