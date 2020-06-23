package serializacion;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import modelo.Torneo;

public class DeserializeFromXML {
	
	private static final String SERIALIZED_FILE_NAME = "torneo.xml";
	
	public static void leer()
	{
		XMLDecoder decoder = null;
		
		try
        {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("No se encontro el archivo torneo.xml");
        }
		
		Torneo.setInstance((Torneo)decoder.readObject());
		
	}

}
