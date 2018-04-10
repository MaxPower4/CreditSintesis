package Grups;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import PlansEstudi.PlaEstudi;

// Programa per llegir un fitxer XML amb DOM

public class LecturaXMLGrups {

	public LecturaXMLGrups() {
	}

	public void LecturaXML(String fitxer) throws SAXException, IOException, ParserConfigurationException {
		// Obtenir fitxer a tractar
		File f = new File(fitxer + ".xml");
		ArrayList ListaGrup = new ArrayList();
		ArrayList ListaAlumne = null;
		
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

					/*System.out.println("\n");
					System.out.print("\nIDListaGrup: " + element.getAttribute("id"));
					System.out.print("\nCodi: " + element.getAttribute("codi"));
					System.out.print("\nNom: " + element.getAttribute("nom"));
					System.out.print("\nEtapa: " + element.getAttribute("etapa"));
					System.out.print("\nSubetapa: " + element.getAttribute("subetapa"));
					System.out.print("\nNivell: " + element.getAttribute("nivell"));
					System.out.print("\nRegim: " + element.getAttribute("regim"));*/

					ListaAlumne = new ArrayList();
					
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
									/*System.out.println(element3.getNodeName());
									System.out.println("IDalum: " + element3.getAttribute("id"));*/
									Alumne a = new Alumne(element3.getAttribute("id"));
									ListaAlumne.add(a);	
								}
							}
						}
					}

					Grup gr = new Grup(element.getAttribute("id"), element.getAttribute("codi"), element.getAttribute("nom"), element.getAttribute("etapa"), element.getAttribute("subetapa"), element.getAttribute("nivell"), element.getAttribute("regim"), ListaAlumne);
					ListaGrup.add(gr);
				}
				ConvertiJson(ListaGrup, ListaAlumne);
			}
		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}
	}
	
	public static void ConvertiJson(ArrayList ListaGrup, ArrayList ListaAlumne) {
		MongoClient mongoClient = ConnexioMongoDB();
		// Now connect to your databases
		DB db = mongoClient.getDB("Absencies");
		db.createCollection("Grup", null);

		Grup p;
		DBCollection coll = db.getCollection("Grup");
		BasicDBObject searchQuery1 = new BasicDBObject();

		for (int i = 0; i < ListaGrup.size(); i++) {
			boolean trobat = false;
			p = (Grup) ListaGrup.get(i);
			DBObject document = new BasicDBObject();
			document.put("ID", p.getId());
			document.put("Codi", p.getCodi());
			document.put("Nom", p.getNom());
			document.put("Etapa", p.getEtapa());
			document.put("Subetapa", p.getSubetapa());
			document.put("Nivell", p.getNivell());
			document.put("Regim", p.getRegim());
			
			String json = new Gson().toJson(ListaAlumne);
			document.put("Contingut", json);

			searchQuery1.put("ID", p.getId());
			DBCursor cursor = coll.find(searchQuery1);
			while (cursor.hasNext()) {
				String ID = (String) cursor.next().get("ID");
				trobat = p.getId().equals(ID);
				if (trobat) {
					System.out.println("Ja exixteix el ID: " + p.getId());
				}
			}
			if (trobat == false) {
				System.out.println("Personal inserit amb ID: " + p.getId());
				coll.insert(document);
			}

		}
	}
	
	public static MongoClient ConnexioMongoDB() {
		// To connect to mongodb server
		MongoClient mongoClient = new MongoClient("10.10.10.11", 27017);

		// Now connect to your databases
		DB db = mongoClient.getDB("Absencies");
		DBCollection coll = db.getCollection("Login");

		if (db != null) {
			System.out.println("Connect to database successfully");
		}

		return mongoClient;
	}
	
}