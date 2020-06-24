package main;

import java.io.FileNotFoundException;

import modelo.Torneo;
import serializacion.DeserializeFromXML;

public class PruebaDeserializacion {

	public static void main(String[] args) {
		
		try {
			DeserializeFromXML.leer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Torneo.getInstance().getEntrenadores().get(1));
		System.out.println(Torneo.getInstance().getEntrenadores().get(1).getPokemones().get(0));
	}

}
