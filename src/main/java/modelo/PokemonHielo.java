package modelo;

/**
 * Es un tipo de {@link Pokemon}, que utiliza habilidades de tipo hielo<br>
 * No se puede clonar<br>
 */

public class PokemonHielo extends Pokemon {
	private boolean superRecarga;
	
	/**
	 * Constructor de dos paramentros que setea el nombre y determina si puede usar recarga<br>
	 * Parametros inciales:<br>
	 * Vitalidad: 500<br>
	 * Escudo: 120<br>
	 * Fuerza:100<br>
	 * @param nombre: String que representa el nombre del Pokemon<br>
	 * @param puedeRecargar: Boolean que determina si el Pokemon puede utilizar recarga en su secuencia de ataques<br>
	 * @param superRecarga: Boolean que determina si el Pokemon puede hacer una superRecarga cuando recargue<br>
	 */

	public PokemonHielo(String nombre, boolean puedeRecargar, boolean superRecarga) {
		super(nombre, 500, 120, 100, puedeRecargar);
		this.superRecarga = superRecarga;
	}
	
	public PokemonHielo() {
		// TODO Auto-generated constructor stub
	}

	protected void recuperarse() {
		this.vitalidad = 500;
		this.escudo = 120;
		this.fuerza = 100;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Niebla}, su fuerza se reduce un 20%
	 */
	@Override
	public void niebla() {
		this.fuerza *= 0.8;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Viento}, su vitalidad de reduce un 10%
	 */
	@Override
	public void viento() {
		this.vitalidad *= 0.9;
	}

	/**
	 *Al recibir un {@link Hechizo} de tipo {@link Tormenta}, si su escudo es mayor a 5
	 *, se reduce 5 puntos. De lo contrario se agota el escudo
	 */
	@Override
	public void tormenta() {
		if (this.escudo > 5)
			this.escudo -= 5;
		else
			this.escudo = 0;
	}

	/**
	 *Recarga las estadisticas del Pokemon dependiendo de su categoria<br>
	 *Categoria 1: recarga su fuerza un 20% y su vitalidad un 10%<br>
	 *Categoria 2: recarga su fuerza un 70% y su vitalidad un 60%<br>
	 *Categoria 3: recarga su fuerza un 80% y su vitalidad un 80%<br>
	 *En el caso se que se haga una super recarga<br>
	 *Categoria 1: Setea su fuerza en 400<br>
	 *Categoria 2: Setea su fuerza en 430<br>
	 *Categoria 3: Setea su fuerza en 460<br>
	 */
	@Override
	public void recargar() {
		int categoria = super.getCategoria();
		if (superRecarga) {
			if (categoria == 1) {
				this.fuerza = 400;
			} else if (categoria == 2) {
				this.fuerza = 430;
				
			} else
				this.fuerza = 460;
			System.out.println(this.getNombre() + " utiliza gran recarga y aumenta su fuerza");
		} else if (this.isPuedeRecargar()) {
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
			System.out.println(this.getNombre() + " recarga su fuerza y vitalidad");
		} else
			super.recargar();
	}

	/**
	 *Golpe final: Provoca al adversario un da�o igual a su fuerza menos un 10%
	 *pero conserva la misma fuerza
	 */
	@Override
	public void golpeFinal(Pokemon otroPokemon) {
		otroPokemon.recibeDanio(this.fuerza * 0.9);
		System.out.println(this.getNombre() + " efectua un ataque final sobre " + otroPokemon.getNombre());
	}

	/**
	 *El escudo absorbe el 75% del da�o y la vitalidad el otro 25%
	 */
	@Override
	public void recibeDanio(double cant) {
		if (this.escudo > 0.75 * cant) {
			this.escudo -= 0.75 * cant;
			this.vitalidad -= 0.25 * cant;
		} else {
			this.vitalidad -= cant - this.escudo;
			this.escudo = 0;
		}
		if (this.vitalidad < 0)
			this.vitalidad = 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public String toString() {
		return "Hielo " + super.toString() + " [superRecarga=" + superRecarga + "]";
	}

	public boolean isSuperRecarga() {
		return superRecarga;
	}

	public void setSuperRecarga(boolean superRecarga) {
		this.superRecarga = superRecarga;
	}
	
	
}
