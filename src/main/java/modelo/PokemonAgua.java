package modelo;

/**
 * Es un tipo de {@link Pokemon}, que utiliza habilidades de tipo agua<br>
 * Se puede clonar<br>
 */
public class PokemonAgua extends Pokemon implements Cloneable {

	/**
	 * Parametros iniciales:<br>
	 * Vitalidad: 500<br>
	 * Escudo: 100<br>
	 * Fuerza:120<br>
	 * 
	 * @param nombre:        String que representa el nombre del Pokemon<br>
	 * @param puedeRecargar: Boolean que determina si el Pokemon puede utilizar
	 *                       recarga en su secuencia de ataques<br>
	 */
	public PokemonAgua(String nombre, boolean puedeRecargar) {
		super(nombre, 500, 100, 120, puedeRecargar);
	}

	public PokemonAgua() {
	}

	/**
	 * Recarga las estadisticas del Pokemon dependiendo de su categoria<br>
	 * Categoria 1: recarga su fuerza y su vitalidad un 10%<br>
	 * Categoria 2: recarga su fuerza y su vitalidad un 60%<br>
	 * Categoria 3: recarga su fuerza y su vitalidad un 80%<br>
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
		} else
			super.recargar();
	}

	/**
	 * Golpe final del {@link Pokemon}<br>
	 * Provoca al Pokemon adversario un da�o igual a su fuerza mas un 25% y luego la
	 * fuerza se agota por completo<br>
	 */
	@Override
	public void golpeFinal(Pokemon otroPokemon) {
		otroPokemon.recibeDanio(this.fuerza * 1.25);
		this.fuerza *= 0.5;
	}

	/**
	 * Al recibir da�o, el escudo y la vitalidad absorben la mitad del da�o cada
	 * uno<br>
	 * En el caso de no tener escudo, se resta el da�o a la vitalidad<br>
	 */
	@Override
	public void recibeDanio(double cantidad) {
		if (cantidad < this.escudo) {
			this.escudo -= cantidad;
		} else {
			this.vitalidad -= cantidad - this.escudo;
			this.escudo = 0;
		}
		if (this.vitalidad < 0)
			this.vitalidad = 0;
	}

	/**
	 * Al recibir un {@link Hechizo} {@link Niebla}, su vitalidad se reduce un
	 * 5%<br>
	 */
	@Override
	public void niebla() {
		this.vitalidad *= 0.95;
	}

	/**
	 * Al recibir un {@link Hechizo} de tipo {@link Viento}, si su escudo es mayor a
	 * 10 puntos, se le restara 10 a este. En caso contrario el escudo se
	 * agotara<br>
	 */
	@Override
	public void viento() {
		if (this.escudo > 10)
			this.escudo -= 10;
		else
			this.escudo = 0;
	}

	/**
	 * Al recibir un {@link Hechizo} de tipo {@link Tormenta}, su fuerza se reducira
	 * un 1%<br>
	 */
	@Override
	public void tormenta() {
		this.fuerza *= 0.99;
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

	@Override
	protected void recuperarse() {
		this.vitalidad = 500;
		this.escudo = 100;
		this.fuerza = 120;
	}

	@Override
	public String toString() {
		return "Agua " + super.toString();
	}

}
