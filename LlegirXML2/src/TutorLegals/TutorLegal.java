package TutorLegals;

public class TutorLegal {
	
	private String id;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String adreca;
	private String codiPostal;
	private String localitat;
	private String nomlocalitat;
	private String provincia;
	private String sexe;
	private String documentidentitat;
	private String tipusDocument;
	
	public TutorLegal(String id, String nom, String cognom1, String cognom2, String adreca, String codiPostal,
			String localitat, String nomlocalitat, String provincia, String sexe, String documentidentitat,
			String tipusDocument) {
		super();
		this.id = id;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.adreca = adreca;
		this.codiPostal = codiPostal;
		this.localitat = localitat;
		this.nomlocalitat = nomlocalitat;
		this.provincia = provincia;
		this.sexe = sexe;
		this.documentidentitat = documentidentitat;
		this.tipusDocument = tipusDocument;
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

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}

	public String getLocalitat() {
		return localitat;
	}

	public void setLocalitat(String localitat) {
		this.localitat = localitat;
	}

	public String getNomlocalitat() {
		return nomlocalitat;
	}

	public void setNomlocalitat(String nomlocalitat) {
		this.nomlocalitat = nomlocalitat;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	@Override
	public String toString() {
		return "TutorLegal [id=" + id + ", nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2 + ", adreca="
				+ adreca + ", codiPostal=" + codiPostal + ", localitat=" + localitat + ", nomlocalitat=" + nomlocalitat
				+ ", provincia=" + provincia + ", sexe=" + sexe + ", documentidentitat=" + documentidentitat
				+ ", tipusDocument=" + tipusDocument + "]";
	}
}
