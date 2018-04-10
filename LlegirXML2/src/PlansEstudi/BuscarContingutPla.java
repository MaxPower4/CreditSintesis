package PlansEstudi;
import com.mongodb.MongoClient;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class BuscarContingutPla {
	public static void main( String args[] ) {
//		https://stackoverflow.com/questions/47047803/connecting-mongodb-java-via-eclipes
             // To connect to mongodb server
             MongoClient mongoClient = new MongoClient( "10.10.10.11" , 27017);

             // Now connect to your databases
             DB db = mongoClient.getDB("Absencies");
             DBCollection coll = db.getCollection("PlaEstudis");

             if(db != null){
            	  System.out.println("Connect to database successfully");
             }
             
             // find - search
             BasicDBObject searchQuery1 = new BasicDBObject();
             
             searchQuery1.put("Etapa","CFPM");
             //searchQuery1.put("Password", "1234");
             DBCursor cursor = coll.find(searchQuery1);
             
             System.out.println("Selection from Collection coll done successfully");
             String tipus = null;
             while (cursor.hasNext()) {
            	 tipus = (String) cursor.next().get("Contingut");
             }
             Gson gson = new Gson();
             System.out.println(tipus);
             String ads ="[{'ID':'355900718','codi':'001','nom':'MP1. Gestió administrativa del comerç internacional','categoria':'Mòdul','tipus':'Lectiu'},{'ID':'355900718','codi':'001','nom':'MP1. Gestió administrativa del comerç internacional','categoria':'Mòdul','tipus':'Lectiu'}]";
             ContingutPla[] myTypes = gson.fromJson(tipus, ContingutPla[].class);
             for(int i = 0; i< myTypes.length;i++){
            	 System.out.println(myTypes[i]);
             }    
       }
}