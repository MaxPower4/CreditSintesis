package Personal;
import com.mongodb.MongoClient;

import PlansEstudi.ContingutPla;

import java.util.ArrayList;

import org.bson.BSONObject;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class CreaObjectePersonal {
	public static void main( String args[] ) {
//		https://stackoverflow.com/questions/47047803/connecting-mongodb-java-via-eclipes
             // To connect to mongodb server
             MongoClient mongoClient = new MongoClient( "10.10.10.11" , 27017);

             // Now connect to your databases
             DB db = mongoClient.getDB("Absencies");
             DBCollection coll = db.getCollection("Personal");

             if(db != null){
            	  System.out.println("Connect to database successfully");
             }
             
             // find - search
             BasicDBObject searchQuery1 = new BasicDBObject();

            // searchQuery1.put("ID","138603698");
             //searchQuery1.put("Password", "1234");
             DBCursor cursor = coll.find(searchQuery1);
             
             System.out.println("Selection from Collection coll done successfully");
             String tipus = null;
             while (cursor.hasNext()) {
            	 tipus = (String) cursor.next().toString();
             }
             Gson gson = new Gson();
             System.out.println(tipus);
             Personal p = gson.fromJson(tipus, Personal.class);
         
             System.out.println( p.toString());
       }
}