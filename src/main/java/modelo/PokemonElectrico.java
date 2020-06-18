package modelo;

/**
 * Es un tipo de {@link Pokemon}, que utiliza habilidades de tipo electrico<br>
 * No se puede clonar<br>
 */

public class PokemonElectrico extends Pokemon {
	
	/**
	 * Constructor de dos paramentros que setea el nombre y determina si puede usar recarga<br>
	 * Parametros inciales:<br>
	 * Vitalidad: 450<br>
	 * Escudo: 75<br>
	 * Fuerza:140<br>
	 * @param nombre: String que representa el nombre del Pokemon<br>
	 * @param puedeRecargar: Boolean que determina si el Pokemon puede utilizar recarga en su secuencia de ataques<br>
	 */

	public PokemonElectrico(String nombre, boolean puedeRecargar) {
		super(nombre, 450, 75, 140, puedeRecargar);
	}

	
	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Niebla}, su fuerza se reducira un 10%<br>
	 */
	@Override
	public void niebla() {
		this.fuerza *= 0.9;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Viento}, su vitalidad se reducira un 5%<br>
	 */
	@Override
	public void viento() {
		this.vitalidad *= 0.95;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Viento}, su fuerza se reducira un 1%<br>
	 */
	@Override
	public void tormenta() {
		this.fuerza *= 0.99;
	}

	/**
	 *Golpe final:
	 *Provoca al adversario un da�o igual a su fuerza mas un 50%<br>
	 */
	@Override
	public void golpeFinal(Pokemon otroPokemon) {
		otroPokemon.recibeDanio(this.fuerza * 1.5);
		System.out.println(this.getNombre() + " efectua un ataque final sobre " + otroPokemon.getNombre());
	}

	/**
	 *Al recibir da�o<br>
	 *Si su escudo es mayor al da�o recibido mas un 60%, el escudo y la vitalidad recibe este da�o
	 *A lo contrario, se le resta a la vitalidad el da�o recibido mas un 20%  sumado los puntos que tenga de escudo<br>
	 *
	 */
	@Override
	public void recibeDanio(double cantidad) {
		if (this.escudo > cantidad * 0.6) {
			this.escudo -= cantidad * 0.6;
			this.vitalidad -= cantidad * 0.6;
		} else {
			this.vitalidad -= cantidad * 1.2 - this.escudo;
			this.escudo = 0;
		}
		if (this.vitalidad < 0)
			this.vitalidad = 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	protected void recuperarse() {
		this.vitalidad = 450;
		this.escudo = 75;
		this.fuerza = 140;
	}

	@Override
	public String toString() {
		return "Electrico " + super.toString();
	}
	
	/**
	 *Recarga las estadisticas del Pokemon dependiendo de su categoria<br>
	 *Categoria 1: recarga su fuerza un 20% y su vitalidad un 10%<br>
	 *Categoria 2: recarga su fuerza un 70% y su vitalidad un 60%<br>
	 *Categoria 3: recarga su fuerza un 90% y su vitalidad un 80%<br>
	 */

	public void recargar() {
		int categoria = super.getCategoria();
		if (isPuedeRecargar()) {
			if (categoria == 1) {
				this.escudo *= 1.2;
				this.fuerza *= 1.1;
			} else if (categoria == 2) {
				this.fuerza *= 1.7;
				this.vitalidad *= 1.6;
			} else {
				this.fuerza *= 1.9;
				this.vitalidad *= 1.8;
			}
			System.out.println(this.getNombre() + " recarga su fuerza y escudo.");
		} else
			super.recargar();
	}

}