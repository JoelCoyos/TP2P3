package modelo;

/**
 * Es un tipo de {@link Pokemon}, que utiliza habilidades de tipo fuego<br>
 * Se puede clonar<br>
 */

public class PokemonFuego extends Pokemon implements Cloneable {
	
	/**
	 * Constructor de dos paramentros que setea el nombre y determina si puede usar recarga<br>
	 * Parametros inciales:<br>
	 * Vitalidad: 530<br>
	 * Escudo: 200<br>
	 * Fuerza:80<br>
	 * @param nombre: String que representa el nombre del Pokemon<br>
	 * @param tieneRecarga: Boolean que determina si el Pokemon puede utilizar recarga en su secuencia de ataques<br>
	 */

	public PokemonFuego(String nombre, boolean tieneRecarga) {
		super(nombre, 530, 200, 80, tieneRecarga);
	}
	
	public PokemonFuego() {
	}
	
	protected void recuperarse() {
		this.vitalidad = 530;
		this.escudo = 200;
		this.fuerza = 80;
	}

	/**
	 *Recarga las estadisticas del Pokemon dependiendo de su categoria<br>
	 *Categoria 1: recarga su fuerza y su vitalidad un 10%<br>
	 *Categoria 2: recarga su fuerza y su vitalidad un 60%<br>
	 *Categoria 3: recarga su fuerza y su vitalidad un 80%<br>
	 */
	@Override
	public void recargar() {
		int categoria = super.getCategoria();
		if (isPuedeRecargar()) {
			if (categoria == 1) {
				this.fuerza *= 1.1;
				this.vitalidad *= 1.1;
			} else if (categoria == 2) {
				this.fuerza *= 1.6;
				this.vitalidad *= 1.6;
			} else {
				this.fuerza *= 1.8;
				this.vitalidad *= 1.8;
			}
		}
		else
			super.recargar();
	}

	/**
	 *Golpe final: <br>
	 *Provoca al adversario un da�o igual a su fuerza mas un 25% y luego la fuerza
	 *se agota por completo (queda en cero)<br>
	 */
	@Override
	public void golpeFinal(Pokemon otroPokemon) {
		otroPokemon.recibeDanio(this.fuerza * 1.25);
		this.fuerza = 0;
	}

	/**
	 *El escudo y la vitalidad absorben la mitad del da�o cada uno<br>
	 */
	@Override
	public void recibeDanio(double cant) {
		if (this.escudo > cant * 0.5) {
			this.escudo -= cant * 0.5;
			this.vitalidad -= cant * 0.5;
		} else {
			this.vitalidad -= cant - this.escudo;
			this.escudo = 0;
		}
		if (this.vitalidad < 0)
			this.vitalidad = 0;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Niebla}, su fuerza se reduce un 15%<br>
	 */
	@Override
	public void niebla() {
		this.fuerza *= 0.85;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Viento}, si su escudo es mayor a 15<br>
	 *se le restan 15 puntos, a lo contrario el escudo se agota
	 */
	@Override
	public void viento() {
		if (this.escudo > 15)
			this.escudo -= 15;
		else
			this.escudo = 0;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Tormenta}, su vitalidad se reduce un 10%<br>
	 */
	@Override
	public void tormenta() {
		this.vitalidad *= 0.9; 
	}
	
	@Override
	public Object clone() {
		Object respuesta=null;
		try {
			respuesta=super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return respuesta;
	}

	@Override
	public String toString() {
		return "Fuego " + super.toString();
	}

	
}
