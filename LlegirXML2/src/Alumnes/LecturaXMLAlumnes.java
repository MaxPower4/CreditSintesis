package Alumnes;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

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

public class LecturaXMLAlumnes {

	public LecturaXMLAlumnes() {
	}

	public void LecturaXML(String fitxer) throws SAXException, IOException, ParserConfigurationException {
		// Obtenir fitxer a tractar
		File f = new File(fitxer + ".xml");
		ArrayList listaAlumnes = new ArrayList();
		ArrayList listaContactes = null;
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
//						System.out.println("\n");
//						System.out.print("\nID: " + element.getAttribute("id"));
//						System.out.print("\nNom: " + element.getAttribute("nom"));
//						System.out.print("\nCognom1: " + element.getAttribute("cognom1"));
//						System.out.print("\nCognom2: " + element.getAttribute("cognom2"));
//						System.out.print("\nData-naixament: " + element.getAttribute("datanaixament"));
//						System.out.print("\nDocument-identitat: " + element.getAttribute("documentidentitat"));
//						System.out.print("\nTipus-document: " + element.getAttribute("tipusdocument"));
//						System.out.println("\nSexe: " + element.getAttribute("sexe"));
						
					listaContactes = new ArrayList<>();
					// llista de nodes de les assignatures
					NodeList llistaAssignatures = element.getChildNodes();
					for (int j = 0; j < llistaAssignatures.getLength(); j++) {
						Node estudiant2 = llistaAssignatures.item(j);
						if (estudiant2.getNodeType() == Node.ELEMENT_NODE) { // Si
																				// es
																				// un
																				// element
//							System.out.println("\n");
							Element element2 = (Element) estudiant2;
//							System.out.println("Contacte: " + element2.getAttribute("contacte"));
//							System.out.println("Tipus: " + element2.getAttribute("tipus"));
//							System.out.println("Descripcio: " + element2.getAttribute("descripcio"));
							Contacte c = new Contacte(element2.getAttribute("contacte"), element2.getAttribute("tipus"), element2.getAttribute("descripcio"));
							listaContactes.add(c);
						}
					}
					
					Alumnes a = new Alumnes(element.getAttribute("id"),element.getAttribute("nom"),element.getAttribute("cognom1"),element.getAttribute("cognom2"),element.getAttribute("datanaixament"),element.getAttribute("documentidentitat"),element.getAttribute("tipusdocument"),element.getAttribute("sexe"),listaContactes);
					listaAlumnes.add(a);
					
					}
				}
				ConvertiJson(listaAlumnes, listaContactes);
				creaUserAlumne(listaAlumnes);
			}
		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}

	}
	
	public static void ConvertiJson(ArrayList listaAlumnes, ArrayList listaContactes) {
		MongoClient mongoClient = ConnexioMongoDB();
		// Now connect to your databases
		DB db = mongoClient.getDB("Absencies");
		db.createCollection("Alumnes", null);

		Alumnes a;
		DBCollection coll = db.getCollection("Alumnes");
		BasicDBObject searchQuery1 = new BasicDBObject();

		for (int i = 0; i < listaAlumnes.size(); i++) {
			boolean trobat = false;
			a = (Alumnes) listaAlumnes.get(i);
			DBObject document = new BasicDBObject();
			document.put("ID", a.getId());
			document.put("Nom", a.getNom());
			document.put("Cognom1", a.getCognom1());
			document.put("Cognom2", a.getCognom2());
			document.put("DataNaixament", a.getDatanaixement());
			document.put("DocumentIdentitat", a.getDocumentidentitat());
			document.put("TipusDocument", a.getTipusDocument());
			document.put("Sexe", a.getSexe());

			String json = new Gson().toJson(listaContactes);
			document.put("Contacte", json);

			searchQuery1.put("ID", a.getId());
			DBCursor cursor = coll.find(searchQuery1);
			while (cursor.hasNext()) {
				String ID = (String) cursor.next().get("ID");
				trobat = a.getId().equals(ID);
				if (trobat) {
					System.out.println("Ja exixteix el ID: " + a.getId());
				}
			}
			if (trobat == false) {
				System.out.println("Personal inserit amb ID: " + a.getId());
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
	
	public static void creaUserAlumne(ArrayList listaAlumnes){
		MongoClient mongoClient = ConnexioMongoDB();
		// Now connect to your databases
		DB db = mongoClient.getDB("Absencies");
		db.createCollection("Login", null);

		Alumnes a;
		DBCollection coll = db.getCollection("Login");
		BasicDBObject searchQuery1 = new BasicDBObject();

		for (int i = 0; i < listaAlumnes.size(); i++) {
			boolean trobat = false;
			a = (Alumnes) listaAlumnes.get(i);
			DBObject document = new BasicDBObject();
			document.put("User", a.getDocumentidentitat());
			String password = a.getCognom1()+generaContraseñaAlumne("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",3);
			
			password = password.replaceAll("\\s","");
			
			document.put("Password", password);
			document.put("Tipus", "Alumne");
			document.put("IDAlumne", a.getId());

			searchQuery1.put("IDAlumne", a.getId());
			DBCursor cursor = coll.find(searchQuery1);
			while (cursor.hasNext()) {
				String ID = (String) cursor.next().get("IDAlumne");
				trobat = a.getId().equals(ID);
				if (trobat) {
					System.out.println("Ja exixteix el USER amb ID: " + a.getId());
				}
			}
			if (trobat == false) {
				System.out.println("Usuari inserit correctament amb ID: " + a.getId());
				coll.insert(document);
			}

		}
	}
	
	public static String generaContraseñaAlumne(String candidateChars, int length){
		    StringBuilder sb = new StringBuilder();
		    Random random = new Random();
		    for (int i = 0; i < length; i++) {
		        sb.append(candidateChars.charAt(random.nextInt(candidateChars
		                .length())));
		    }

		    return sb.toString();
	}
}