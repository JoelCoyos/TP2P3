package serializacion;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import modelo.Torneo;
import modelo.TorneoSerializable;

public class SerializeToXML {
	
	private static final String SERIALIZED_FILE_NAME = "torneo.xml";
	
	/** 
	 * Método que al finalizar una etapa es invocado y realiza la serialización de los atributos de la clase Torneo 
	 * mediante una clase intermedia de nombre TorneoSerializable, siendo esta la que se almacena en el archivo XML.
	 * @throws FileNotFoundException
	 */
	public static void escribirXML() throws FileNotFoundException
	{
		XMLEncoder encoder = null;
		
        encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
        
        TorneoSerializable torneoSerializable = new TorneoSerializable();
        torneoSerializable.setEnfrentamientos(Torneo.getInstance().getEnfrentamientos());
        torneoSerializable.setEntrenadores(Torneo.getInstance().getEntrenadores());
        torneoSerializable.setEtapa(Torneo.getInstance().getEtapa());
        torneoSerializable.setParticipantesActuales(Torneo.getInstance().getParticipantesActuales());
        torneoSerializable.setArenas(Torneo.getInstance().getArenas());
        torneoSerializable.setBatallas(Torneo.getInstance().getBatallas());
        torneoSerializable.setHechizos(Torneo.getInstance().getHechizos());
		
		encoder.writeObject(torneoSerializable);
		encoder.close();
	}
	
	

}
