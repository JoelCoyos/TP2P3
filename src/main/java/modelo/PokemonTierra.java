package modelo;

/**
 * Es un tipo de {@link Pokemon}, que utiliza habilidades de tipo tierra<br>
 * Se puede clonar<br>
 */

public class PokemonTierra extends Pokemon implements Cloneable {
	
	/**
	 * Constructor de dos paramentros que setea el nombre y determina si puede usar recarga<br>
	 * Parametros inciales:<br>
	 * Vitalidad: 530<br>
	 * Escudo: 200<br>
	 * Fuerza:80<br>
	 * @param nombre: String que representa el nombre del Pokemon<br>
	 * @param puedeRecargar: Boolean que determina si el Pokemon puede utilizar recarga en su secuencia de ataques
	 */

	public PokemonTierra(String nombre, boolean puedeRecargar) {
		super(nombre, 700, 100, 50, puedeRecargar);
	}
	
	public PokemonTierra() {
	}

	/**
	 *Recarga las estadisticas del Pokemon dependiendo de su categoria<br>
	 *Categoria 1: recarga su escudo un 10% y su vitalidad un 20%
	 *Categoria 2: recarga su fuerza un 60% y su vitalidad un 70%
	 *Categoria 3: recarga su fuerza un 80% y su vitalidad un 90%
	 */
	public void recargar() {
		int categoria = super.getCategoria();
		if (isPuedeRecargar()) {
			if (categoria == 1) {
				this.escudo *= 1.1;
				this.vitalidad *= 1.2;
			} else if (categoria == 2) {
				this.fuerza *= 1.6;
				this.vitalidad *= 1.7;
			} else {
				this.fuerza *= 1.8;
				this.vitalidad *= 1.9;
			}
		} else
			super.recargar();
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Niebla}, su fuerza se reduce un 15%
	 */
	@Override
	public void niebla() {
		this.fuerza *= 0.85;
	}


	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Viento}, si su escudo es mayor a 20, se reduce en 20 puntos. De lo contrario, este se agota
	 */
	@Override
	public void viento() {
		if (this.escudo > 20)
			this.escudo -= 20;
		else
			this.escudo = 0;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Tormenta}, su vitalidad se reduce un 15%
	 */
	@Override
	public void tormenta() {
		this.vitalidad *= 0.85;
	}
	
	protected void recuperarse() {
		this.vitalidad = 700;
		this.escudo = 100;
		this.fuerza = 50;
	}

	@Override
	public void golpeFinal(Pokemon otroPokemon) {
		otroPokemon.recibeDanio(this.fuerza * 0.5 + this.vitalidad * 0.2); // ataque escala con la vitalidad
		this.vitalidad *= 0.9;
	}

	@Override
	public Object clone() {
		Object respuesta = null;
		try {
			respuesta = super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return respuesta;
	}
	
	/**
	 *Si el escudo es mayor al 15% del da�o recibido, se resta esta cantidad al escudo. A la vitalidad se le resta el 65% del da�o
	 *De lo contrario, se le resta a la vitalidad el 80% del da�o y el valor del escudo. Ademas el escudo se agota
	 */
	@Override
	public void recibeDanio(double cantidad) { // recibe menos daño que otros tipos
		if (this.escudo > cantidad * 0.15) {
			this.escudo -= cantidad * 0.15;
			this.vitalidad -= cantidad * 0.65;
		} else {
			this.vitalidad -= cantidad * 0.8 - this.escudo;
			this.escudo = 0;
		}
		if (this.vitalidad < 0)
			this.vitalidad = 0;
	}

	@Override
	public String toString() {
		return "Tierra " + super.toString();
	}

}
