package serializacion;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import excepciones.TipoNoEncontradoException;
import modelo.Entrenador;
import modelo.PokemonFactory;
import modelo.Torneo;
import modelo.TorneoSerializable;

public class SerializeToXML {
	
	private static final String SERIALIZED_FILE_NAME = "torneo.xml";
	
	public static void escribirXML(Torneo torneo) throws FileNotFoundException
	{
		XMLEncoder encoder = null;
		
        encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
        
        TorneoSerializable torneoSerializable = new TorneoSerializable();
        torneoSerializable.setEnfrentamientos(torneo.getEnfrentamientos());
        torneoSerializable.setEntrenadores(torneo.getEntrenadores());
        torneoSerializable.setEtapa(torneo.getEtapa());
        torneoSerializable.setParticipantesActuales(torneo.getParticipantesActuales());
		
		encoder.writeObject(torneoSerializable);
		encoder.close();
	}
	
	

}
