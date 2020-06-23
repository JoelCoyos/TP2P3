package serializacion;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import modelo.Torneo;

public class SerializeToXML {
	
	private static final String SERIALIZED_FILE_NAME = "torneo.xml";
	
	public static void escribirXML(Torneo torneo)
	{
		XMLEncoder encoder = null;
		
		try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
        }
        catch (FileNotFoundException fileNotFound)
        {
            System.out.println("No se puede abrir o crear el archivo dvd.xml");
        }
		
		encoder.writeObject(Torneo.getInstance());
		encoder.close();
	}
	
	

}
