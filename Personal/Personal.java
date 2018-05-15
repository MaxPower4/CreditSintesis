package Personal;

public class Personal{
	private String ID;
	private String Tipus;
	private String Nom;
	private String Cognom1;
	private String Cognom2;
	private String DocumentIdentitat;
	
	public Personal(String id, String tipus, String nom, String cognom1, String cognom2, String documentidentitat) {
		super();
		this.ID = id;
		this.Tipus = tipus;
		this.Nom = nom;
		this.Cognom1 = cognom1;
		this.Cognom2 = cognom2;
		this.DocumentIdentitat = documentidentitat;
	}

	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public String getTipus() {
		return Tipus;
	}

	public void setTipus(String tipus) {
		this.Tipus = tipus;
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

	public String getDocumentidentitat() {
		return DocumentIdentitat;
	}

	public void setDocumentidentitat(String documentidentitat) {
		this.DocumentIdentitat = documentidentitat;
	}

	@Override
	public String toString() {
		return "Personal [id=" + ID + ", tipus=" + Tipus + ", nom=" + Nom + ", cognom1=" + Cognom1 + ", cognom2="
				+ Cognom2 + ", documentidentitat=" + DocumentIdentitat + "]\n";
	}
}
