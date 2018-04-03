package SAX;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Programa per llegir un fitxer XML amb DOM

public class LecturaXMLPlansEstudi {

	public LecturaXMLPlansEstudi() {
	}

	public void LecturaXML(String fitxer) throws SAXException, IOException, ParserConfigurationException {
		// Obtenir fitxer a tractar
		File f = new File(fitxer + ".xml");
		if (f.exists()) {
			// Creem el parser per podem llegir el document
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(f);

			// Llegim el node arrel
			doc.getDocumentElement().normalize();
			System.out.println("L'element arrel del document: " + doc.getDocumentElement().getNodeName());
			// llista de nodes treballadors
			NodeList llistaEstudiants = doc.getElementsByTagName("pla-estudis");

			// Recorrem la llista

			for (int i = 0; i < llistaEstudiants.getLength(); i++) {
				Node estudiant = llistaEstudiants.item(i);
				System.out.println("Element: " + estudiant.getNodeName());
				if (estudiant.getNodeType() == Node.ELEMENT_NODE) { // Si es un
																	// element
					// Obtenir els elements del node
					Element element = (Element) estudiant;

					System.out.println("\n");
					System.out.print("\nIDpla: " + element.getAttribute("id"));
					System.out.print("\nEtapa: " + element.getAttribute("etapa"));
					System.out.print("\nSubetapa: " + element.getAttribute("subetapa"));
					System.out.println("\nNom: " + element.getAttribute("nom"));

					// llista de nodes de les assignatures
					NodeList llistaAssignatures = element.getChildNodes();
					for (int j = 0; j < llistaAssignatures.getLength(); j++) {
						Node estudiant2 = llistaAssignatures.item(j);
						if (estudiant2.getNodeType() == Node.ELEMENT_NODE) { // Si es un element
							System.out.println("\n");
							Element element2 = (Element) estudiant2;
							System.out.println("IDcon: " + element2.getAttribute("id"));
							System.out.println("Codi: " + element2.getAttribute("codi"));
							System.out.println("Nom: " + element2.getAttribute("nom"));
							System.out.println("Categoria: " + element2.getAttribute("categoria"));
							System.out.println("Tipus: " + element2.getAttribute("tipus"));
						}
					}
				}
			}
		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}

	}
}