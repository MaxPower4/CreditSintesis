package TutorLegals;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class testXMLTutorLegal {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {
		Scanner lector = new Scanner(System.in);
		
		boolean entra = false;
		System.out.println("Introdueix el nom del document: ");
		String nomdoc = lector.nextLine();
	
		LecturaXMLTutorLegal lxml = new LecturaXMLTutorLegal();
		lxml.LecturaXML(nomdoc);
	}


}
