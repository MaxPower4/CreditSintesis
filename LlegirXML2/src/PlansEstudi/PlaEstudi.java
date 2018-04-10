package PlansEstudi;

import java.util.ArrayList;
import java.util.List;

public class PlaEstudi {
	private String ID;
	private String etapa;
	private String subetapa;
	private String nom;
	List<ContingutPla> listaContinguts;
	
	public PlaEstudi(String iD, String etapa, String subetapa, String nom, List<ContingutPla> _listaContinguts) {
		ID = iD;
		this.etapa = etapa;
		this.subetapa = subetapa;
		this.nom = nom;
		listaContinguts = new ArrayList<>();
		listaContinguts.addAll(_listaContinguts);
	}
	
	public List<ContingutPla> getListaContinguts() {
		return listaContinguts;
	}

	public void setListaContinguts(ContingutPla contingutPla) {
		this.listaContinguts.add(contingutPla);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public void toString2() {
		 System.out.println("PlaEstudi [ID=" + ID + ", etapa=" + etapa + ", subetapa=" + subetapa + ", nom=" + nom
				+ ", listaContinguts=" + listaContinguts + "]\n");
		 
		 for(ContingutPla a : listaContinguts){
			 System.out.println(a.toString());
		 }
		 
	}
	
}
