package SAX;

public class Personal {
	private String id;
	private String tipus;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String documentidentitat;
	
	public Personal(String id, String tipus, String nom, String cognom1, String cognom2, String documentidentitat) {
		super();
		this.id = id;
		this.tipus = tipus;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.documentidentitat = documentidentitat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
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

	public String getDocumentidentitat() {
		return documentidentitat;
	}

	public void setDocumentidentitat(String documentidentitat) {
		this.documentidentitat = documentidentitat;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", tipus=" + tipus + ", nom=" + nom + ", cognom1=" + cognom1 + ", cognom2="
				+ cognom2 + ", documentidentitat=" + documentidentitat + "]\n";
	}
}
