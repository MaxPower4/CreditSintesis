package SAX;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Programa per llegir un fitxer XML amb DOM

public class LecturaXMLGrups {

	public LecturaXMLGrups() {
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
			NodeList llistaEstudiants = doc.getElementsByTagName("grup");

			// Recorrem la llista

			for (int i = 0; i < llistaEstudiants.getLength(); i++) {
				Node estudiant = llistaEstudiants.item(i);
				System.out.println("Element: " + estudiant.getNodeName());
				if (estudiant.getNodeType() == Node.ELEMENT_NODE) { // Si es un
																	// element
					// Obtenir els elements del node
					Element element = (Element) estudiant;

					System.out.println("\n");
					System.out.print("\nIDgrup: " + element.getAttribute("id"));
					System.out.print("\nCodi: " + element.getAttribute("codi"));
					System.out.print("\nNom: " + element.getAttribute("nom"));
					System.out.print("\nEtapa: " + element.getAttribute("etapa"));
					System.out.print("\nSubetapa: " + element.getAttribute("subetapa"));
					System.out.print("\nNivell: " + element.getAttribute("nivell"));
					System.out.print("\nRegim: " + element.getAttribute("regim"));

					// llista de nodes de les assignatures

					NodeList llistaAssignatures = element.getChildNodes();
					
					for (int j = 0; j < llistaAssignatures.getLength(); j++) {
						Node estudiant2 = llistaAssignatures.item(j);
						if (estudiant2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println("\n");
							Element element2 = (Element) estudiant2;

							NodeList llistaAssignatures2 = element2.getChildNodes();

							for (int k = 0; k < llistaAssignatures2.getLength(); k++) {

								Node estudiant3 = llistaAssignatures2.item(k);
								if (estudiant3.getNodeType() == Node.ELEMENT_NODE) {
									// Obtenir els elements del node
									Element element3 = (Element) estudiant3;
									System.out.println(element3.getNodeName());
									System.out.println("IDalum: " + element3.getAttribute("id"));
								}
							}
						}
					}
					Scanner lector = new Scanner(System.in);
					lector.nextLine();

				}
			}
		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}

	}
}