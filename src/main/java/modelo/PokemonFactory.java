package modelo;

import excepciones.TipoNoEncontradoException;

/**
 *Patron factory para crear Pokemon<br>
 */
public class PokemonFactory {
	/**
	 * @param nombre: nombre del Pokemon<br>
	 * @param tipo: Tipo del Pokemon<br>
	 * @param puedeRecargar: Capacidad del Pokemon de recargar<br>
	 * @return Un Pokemon con los parametros escepecificados<br>
	 * @throws TipoNoEncontradoException Cuando el tipo indicado no exista<br>
	 */
	public static Pokemon getPokemon(String nombre, String tipo, boolean puedeRecargar) throws TipoNoEncontradoException{
		return getPokemon(nombre, tipo, puedeRecargar, false);
	}
	
	public static Pokemon getPokemon(String nombre, String tipo, boolean puedeRecargar, boolean granRecarga) throws TipoNoEncontradoException {
		Pokemon respuesta = null;
		if (tipo.equalsIgnoreCase("agua"))
			respuesta = new PokemonAgua(nombre, puedeRecargar);
		else if (tipo.equalsIgnoreCase("fuego"))
			respuesta = new PokemonFuego(nombre, puedeRecargar);
		else if (tipo.equalsIgnoreCase("hielo"))
			respuesta = new PokemonHielo(nombre, puedeRecargar, granRecarga);
		else if (tipo.equalsIgnoreCase("tierra"))
			respuesta = new PokemonTierra(nombre, puedeRecargar);
		else if (tipo.equalsIgnoreCase("electrico"))
			respuesta = new PokemonElectrico(nombre, puedeRecargar);
		else throw new TipoNoEncontradoException("No fue posible crear al pokemon", nombre, tipo);
		return respuesta;
	}
}
