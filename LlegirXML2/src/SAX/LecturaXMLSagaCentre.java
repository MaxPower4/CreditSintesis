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

public class LecturaXMLSagaCentre {

	public LecturaXMLSagaCentre() {
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
			NodeList llistaEstudiants = doc.getElementsByTagName("saga-centre");

			// Recorrem la llista

			for (int i = 0; i < llistaEstudiants.getLength(); i++) {
				Node estudiant = llistaEstudiants.item(i);
				System.out.println("Element: " + estudiant.getNodeName());
				if (estudiant.getNodeType() == Node.ELEMENT_NODE) { // Si es un
																	// element
					// Obtenir els elements del node
					Element element = (Element) estudiant;

					System.out.println("\n");
					System.out.print("\nVersio: " + element.getAttribute("versio"));
					System.out.print("\nCodi-exportacio: " + element.getAttribute("codi-exportacio"));
					System.out.print("\nData-exportacio: " + element.getAttribute("data-exportacio"));
					System.out.println("\nData-importacio: " + element.getAttribute("data-importacio"));

					// llista de nodes de les assignatures
					NodeList llistaAssignatures = element.getChildNodes();

					Node estudiant2 = llistaAssignatures.item(1);
					if (estudiant2.getNodeType() == Node.ELEMENT_NODE) { // Si
																			// es
																			// un
																			// element
						System.out.println("\n");
						Element element2 = (Element) estudiant2;
						System.out.println("Codi: " + element2.getAttribute("codi"));
						System.out.println("Nom: " + element2.getAttribute("nom"));
						System.out.println("Adreca: " + element2.getAttribute("adreca"));
						System.out.println("Telefon: " + element2.getAttribute("telefon"));
						System.out.println("Curs: " + element2.getAttribute("curs"));
					}

				}
			}
		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}

	}
}