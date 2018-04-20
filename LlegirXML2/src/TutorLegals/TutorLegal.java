package TutorLegals;

public class TutorLegal {
	
	private String ID;
	private String Nom;
	private String Cognom1;
	private String Cognom2;
	private String Adreca;
	private String CodiPostal;
	private String Localitat;
	private String NomLocalitat;
	private String Provincia;
	private String Sexe;
	private String DocumentIdentitat;
	private String TipusDocument;
	
	public TutorLegal(String id, String nom, String cognom1, String cognom2, String adreca, String codiPostal,
			String localitat, String nomlocalitat, String provincia, String sexe, String documentidentitat,
			String tipusDocument) {
		super();
		this.ID = id;
		this.Nom = nom;
		this.Cognom1 = cognom1;
		this.Cognom2 = cognom2;
		this.Adreca = adreca;
		this.CodiPostal = codiPostal;
		this.Localitat = localitat;
		this.NomLocalitat = nomlocalitat;
		this.Provincia = provincia;
		this.Sexe = sexe;
		this.DocumentIdentitat = documentidentitat;
		this.TipusDocument = tipusDocument;
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

	public String getAdreca() {
		return Adreca;
	}

	public void setAdreca(String adreca) {
		this.Adreca = adreca;
	}

	public String getCodiPostal() {
		return CodiPostal;
	}

	public void setCodiPostal(String codiPostal) {
		this.CodiPostal = codiPostal;
	}

	public String getLocalitat() {
		return Localitat;
	}

	public void setLocalitat(String localitat) {
		this.Localitat = localitat;
	}

	public String getNomlocalitat() {
		return NomLocalitat;
	}

	public void setNomlocalitat(String nomlocalitat) {
		this.NomLocalitat = nomlocalitat;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		this.Provincia = provincia;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		this.Sexe = sexe;
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

	@Override
	public String toString() {
		return "TutorLegal [id=" + ID + ", nom=" + Nom + ", cognom1=" + Cognom1 + ", cognom2=" + Cognom2 + ", adreca="
				+ Adreca + ", codiPostal=" + CodiPostal + ", localitat=" + Localitat + ", nomlocalitat=" + NomLocalitat
				+ ", provincia=" + Provincia + ", sexe=" + Sexe + ", documentidentitat=" + DocumentIdentitat
				+ ", tipusDocument=" + TipusDocument + "]";
	}
}
