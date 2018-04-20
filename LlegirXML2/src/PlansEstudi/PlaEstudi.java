package PlansEstudi;

import java.util.ArrayList;
import java.util.List;

public class PlaEstudi {
	private String ID;
	private String Etapa;
	private String Subetapa;
	private String Nom;
	List<ContingutPla> listaContinguts;
	
	public PlaEstudi(String iD, String etapa, String subetapa, String nom, List<ContingutPla> _listaContinguts) {
		ID = iD;
		this.Etapa = etapa;
		this.Subetapa = subetapa;
		this.Nom = nom;
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

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	
	public void toString2() {
		 System.out.println("PlaEstudi [ID=" + ID + ", etapa=" + Etapa + ", subetapa=" + Subetapa + ", nom=" + Nom
				+ ", listaContinguts=" + listaContinguts + "]\n");
		 
		 for(ContingutPla a : listaContinguts){
			 System.out.println(a.toString());
		 }
		 
	}
	
}
