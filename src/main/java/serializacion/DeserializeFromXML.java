package serializacion;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import modelo.Torneo;
import modelo.TorneoSerializable;

public class DeserializeFromXML {

	private static final String SERIALIZED_FILE_NAME = "torneo.xml";

	public static void leer() throws FileNotFoundException {
		XMLDecoder decoder = null;

		decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
		
		Object torneo = (TorneoSerializable) decoder.readObject();
		TorneoSerializable torneoSerializable = (TorneoSerializable)torneo;
		Torneo.getInstance().setEnfrentamientos(torneoSerializable.getEnfrentamientos());
		Torneo.getInstance().setEntrenadores(torneoSerializable.getEntrenadores());
		Torneo.getInstance().setEtapa(torneoSerializable.getEtapa());
		Torneo.getInstance().setParticipantesActuales(torneoSerializable.getParticipantesActuales());

	}

}
