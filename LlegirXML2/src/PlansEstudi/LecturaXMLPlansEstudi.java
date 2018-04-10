package PlansEstudi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

import Personal.Personal;

// Programa per llegir un fitxer XML amb DOM

public class LecturaXMLPlansEstudi {
	final Gson gson = new Gson();

	public LecturaXMLPlansEstudi() {
	}

	public void LecturaXML(String fitxer) throws SAXException, IOException, ParserConfigurationException {
		// Obtenir fitxer a tractar
		File f = new File(fitxer + ".xml");
		ArrayList PlaEstudis = new ArrayList();
		ArrayList ContingutsPla = null;
		PlaEstudi pe = null;
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

					/*
					 * System.out.println("\n"); System.out.print("\nIDpla: " +
					 * element.getAttribute("id")); System.out.print("\nEtapa: "
					 * + element.getAttribute("etapa")); System.out.print(
					 * "\nSubetapa: " + element.getAttribute("subetapa"));
					 * System.out.println("\nNom: " +
					 * element.getAttribute("nom"));
					 */
					ContingutsPla = new ArrayList();

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
							/*
							 * System.out.println("IDcon: " +
							 * element2.getAttribute("id")); System.out.println(
							 * "Codi: " + element2.getAttribute("codi"));
							 * System.out.println("Nom: " +
							 * element2.getAttribute("nom"));
							 * System.out.println("Categoria: " +
							 * element2.getAttribute("categoria"));
							 * System.out.println("Tipus: " +
							 * element2.getAttribute("tipus"));
							 */
							ContingutPla cp = new ContingutPla(element2.getAttribute("id"),
									element2.getAttribute("codi"), element2.getAttribute("nom"),
									element2.getAttribute("categoria"), element2.getAttribute("tipus"));
							ContingutsPla.add(cp);
						}
					}
					pe = new PlaEstudi(element.getAttribute("id"), element.getAttribute("etapa"),
							element.getAttribute("subetapa"), element.getAttribute("nom"), ContingutsPla);
					PlaEstudis.add(pe);
					// pe.toString2();
				}
				ConvertiJson(PlaEstudis, ContingutsPla);
			}

		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}

	}

	public static void ConvertiJson(ArrayList listaPlaEstudis, ArrayList listaContingutsPla) {
		MongoClient mongoClient = ConnexioMongoDB();
		// Now connect to your databases
		DB db = mongoClient.getDB("Absencies");
		db.createCollection("PlaEstudis", null);

		PlaEstudi p;
		DBCollection coll = db.getCollection("PlaEstudis");
		BasicDBObject searchQuery1 = new BasicDBObject();

		for (int i = 0; i < listaPlaEstudis.size(); i++) {
			boolean trobat = false;
			p = (PlaEstudi) listaPlaEstudis.get(i);
			DBObject document = new BasicDBObject();
			document.put("ID", p.getID());
			document.put("Etapa", p.getEtapa());
			document.put("Subetapa", p.getSubetapa());
			document.put("Nom", p.getNom());

			String json = new Gson().toJson(listaContingutsPla);
			document.put("Contingut", json);

			searchQuery1.put("ID", p.getID());
			DBCursor cursor = coll.find(searchQuery1);
			while (cursor.hasNext()) {
				String ID = (String) cursor.next().get("ID");
				trobat = p.getID().equals(ID);
				if (trobat) {
					System.out.println("Ja exixteix el ID: " + p.getID());
				}
			}
			if (trobat == false) {
				System.out.println("Personal inserit amb ID: " + p.getID());
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