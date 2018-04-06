package Alumnes;

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

public class LecturaXMLAlumnes {

	public LecturaXMLAlumnes() {
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
			NodeList llistaEstudiants = doc.getElementsByTagName("alumne");

			// Recorrem la llista

			for (int i = 0; i < llistaEstudiants.getLength(); i++) {
				Node estudiant = llistaEstudiants.item(i);
				//System.out.println("Element: " + estudiant.getNodeName());

				if (estudiant.getNodeType() == Node.ELEMENT_NODE) { // Si es un
					// Obtenir els elements del node
					Element element = (Element) estudiant; // element
					if (element.getAttribute("nom").isEmpty()) {
						
					}else{
						System.out.println("\n");
						System.out.print("\nID: " + element.getAttribute("id"));
						System.out.print("\nNom: " + element.getAttribute("nom"));
						System.out.print("\nCognom1: " + element.getAttribute("cognom1"));
						System.out.print("\nCognom2: " + element.getAttribute("cognom2"));
						System.out.print("\nData-naixament: " + element.getAttribute("datanaixament"));
						System.out.print("\nDocument-identitat: " + element.getAttribute("documentidentitat"));
						System.out.print("\nTipus-document: " + element.getAttribute("tipusdocument"));
						System.out.println("\nSexe: " + element.getAttribute("sexe"));
					}
					// llista de nodes de les assignatures
					NodeList llistaAssignatures = element.getChildNodes();
					for (int j = 0; j < llistaAssignatures.getLength(); j++) {
						Node estudiant2 = llistaAssignatures.item(j);
						if (estudiant2.getNodeType() == Node.ELEMENT_NODE) { // Si
																				// es
																				// un
																				// element
							System.out.println("\n");
							Element element2 = (Element) estudiant2;
							System.out.println("Contacte: " + element2.getAttribute("contacte"));
							System.out.println("Tipus: " + element2.getAttribute("tipus"));
							System.out.println("Descripcio: " + element2.getAttribute("descripcio"));
						}
					}
				}
			}
		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}

	}
}