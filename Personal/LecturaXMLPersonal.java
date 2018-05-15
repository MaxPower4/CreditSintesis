package Personal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import org.json.JSONException;
import org.json.JSONObject;

// Programa per llegir un fitxer XML amb DOM

public class LecturaXMLPersonal {
	public LecturaXMLPersonal() {
	}

	public void LecturaXML(String fitxer) throws SAXException, IOException, ParserConfigurationException {
		// Obtenir fitxer a tractar
		File f = new File(fitxer + ".xml");
		//Creem la lista de Personal
		ArrayList listaPersonal = new ArrayList();
		
		if (f.exists()) {
			// Creem el parser per podem llegir el document
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(f);

			// Llegim el node arrel
			doc.getDocumentElement().normalize();
			System.out.println("L'element arrel del document: " + doc.getDocumentElement().getNodeName());
			// llista de nodes treballadors
			NodeList llistaEstudiants = doc.getElementsByTagName("personal");
			// Recorrem la llista

			for (int i = 1; i < llistaEstudiants.getLength(); i++) {
				Node estudiant = llistaEstudiants.item(i);
				//System.out.println("Element: " + estudiant.getNodeName());
				if (estudiant.getNodeType() == Node.ELEMENT_NODE) { // Si es un
																	// element
					// Obtenir els elements del node
					Element element = (Element) estudiant;
					/*
					System.out.println("\n");
					System.out.print("\nID: " + element.getAttribute("id"));
					System.out.print("\nTipus: " + element.getAttribute("tipus"));
					System.out.print("\nNom: " + element.getAttribute("nom"));
					System.out.print("\nCognom1: " + element.getAttribute("cognom1"));
					System.out.print("\nCognom2: " + element.getAttribute("cognom2"));
					System.out.print("\nCognom2: " + element.getAttribute("documentidentitat"));
					*/
					Personal p = new Personal(element.getAttribute("id"),element.getAttribute("tipus"),element.getAttribute("nom"),element.getAttribute("cognom1"),element.getAttribute("cognom2"),element.getAttribute("documentidentitat"));
					listaPersonal.add(p);	
				}
			}
				ConvertiJson(listaPersonal);
				creaUserProfessor(listaPersonal);
		} else {
			System.out.println("No existeix el document que vols llegir\n");
		}
	}
	
	public static void ConvertiJson(ArrayList listaPersonal){
		MongoClient mongoClient = ConnexioMongoDB();
		 // Now connect to your databases
        DB db = mongoClient.getDB("Absencies");
        db.createCollection("Personal", null);
        
		Personal p;
		DBCollection coll = db.getCollection("Personal");
		BasicDBObject searchQuery1 = new BasicDBObject();
         
       
		for(int i=0; i< listaPersonal.size(); i++){
			boolean trobat = false;
			p = (Personal) listaPersonal.get(i);
			DBObject document = new BasicDBObject();
			document.put("ID", p.getId());
			document.put("Tipus", p.getTipus());
			document.put("Nom", p.getNom());
			document.put("Cognom1", p.getCognom1());
			document.put("Cognom2", p.getCognom2());
			document.put("DocumentIdentitat", p.getDocumentidentitat());
			
			searchQuery1.put("ID", p.getId());
			DBCursor cursor = coll.find(searchQuery1);
			while (cursor.hasNext()) {
				String ID = (String) cursor.next().get("ID");
				trobat = p.getId().equals(ID);
				if(trobat){
					System.out.println("Ja exixteix el ID: " + p.getId());
				}
            }
			if(trobat == false){
				System.out.println("Personal inserit amb ID: " + p.getId());
				coll.insert(document);
			}	
		}
	}
	
	public static MongoClient ConnexioMongoDB(){
		 // To connect to mongodb server
        MongoClient mongoClient = new MongoClient( "192.168.0.202" , 27017);

        // Now connect to your databases
        DB db = mongoClient.getDB("Absencies");
        DBCollection coll = db.getCollection("Login");

        if(db != null){
       	  System.out.println("Connect to database successfully");
        }
        
        return mongoClient;
	}
	
	public static void creaUserProfessor(ArrayList listaPersonal){
		MongoClient mongoClient = ConnexioMongoDB();
		 // Now connect to your databases
        DB db = mongoClient.getDB("Absencies");
        db.createCollection("Login", null);
        
		Personal p;
		DBCollection coll = db.getCollection("Login");
		BasicDBObject searchQuery1 = new BasicDBObject();
         
       
		for(int i=0; i< listaPersonal.size(); i++){
			boolean trobat = false;
			p = (Personal) listaPersonal.get(i);
			DBObject document = new BasicDBObject();
			document.put("User", p.getDocumentidentitat());
			String password = p.getCognom1()+generaContrasenaAlumne("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",3);
			//Reemplacem tots els espais amb blanc per res
			password = password.replaceAll("\\s","");
			
			document.put("Password", password);
			document.put("Tipus", "Professor");
			document.put("IDProfessor", p.getId());
			
			searchQuery1.put("IDProfessor", p.getId());
			DBCursor cursor = coll.find(searchQuery1);
			while (cursor.hasNext()) {
				String ID = (String) cursor.next().get("IDProfessor");
				trobat = p.getId().equals(ID);
				if(trobat){
					System.out.println("Ja exixteix el USER amb ID: " + p.getId());
				}
            }
			if(trobat == false){
				System.out.println("Usuari inserit correctament amb ID: " + p.getId());
				coll.insert(document);
			}	
		}
	}
	public static String generaContrasenaAlumne(String candidateChars, int length){
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }

	    return sb.toString();
}
}