package serializacion;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import modelo.Torneo;

public class SerializeToXML {
	
	private static final String SERIALIZED_FILE_NAME = "torneo.xml";
	
	public static void escribirXML(Torneo torneo) throws FileNotFoundException
	{
		XMLEncoder encoder = null;
		
       encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
		
		encoder.writeObject(Torneo.getInstance());
		encoder.close();
	}
	
	

}
