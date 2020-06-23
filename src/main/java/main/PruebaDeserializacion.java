package main;

import modelo.Torneo;
import serializacion.DeserializeFromXML;

public class PruebaDeserializacion {

	public static void main(String[] args) {
		
		DeserializeFromXML.leer();
		
		System.out.println(Torneo.getInstance().getEntrenadores().get(1));
		System.out.println(Torneo.getInstance().getEntrenadores().get(1).getPokemones().get(0));
	}

}
