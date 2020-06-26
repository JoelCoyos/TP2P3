package modelo;

/**
 * Clase que representa a un Pokemon dentro de un juego de estrategia por
 * turnos<br>
 */
public abstract class Pokemon implements Hechizable, Clasificable {

	private String nombre;
	private int exp = 0;
	protected double escudo, vitalidad, fuerza;
	private boolean puedeRecargar;

	/**
	 * @param nombre:        Nombre del Pokemon<br>
	 * @param vitalidad:     Puntos de vitalidad<br>
	 * @param escudo:        Puntos de escudo. <br>
	 * @param fuerza:        Puntos de fuerza de ataque<br>
	 * @param puedeRecargar: Boolean que determina si un Pokemon puede hacer una
	 *                       recarga en la secuencia de ataque<br>
	 */
	public Pokemon(String nombre, double vitalidad, double escudo, double fuerza, boolean puedeRecargar) {
		super();
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.escudo = escudo;
		this.fuerza = fuerza;
		this.puedeRecargar = puedeRecargar;
	}

	public Pokemon() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Ejecuta la secuencia de ataque a un {@link Pokemon} adversario<br>
	 * <b>Pre: </b> El parametro otroPokemon debe ser distinto de null<br>
	 * 
	 * @param otroPokemon: {@link Pokemon} al que se atacara<br>
	 * 
	 */
	public void ataque(Pokemon otroPokemon) {
		golpeInicial(otroPokemon);
		recargar();
		golpeFinal(otroPokemon);
	}

	/**
	 * Ataca a un {@link Pokemon} con un da�o igual a su fuerza de ataque<br>
	 * 
	 * @param otroPokemon: Pokemon al que se aplicara el golpe incial<br>
	 *                     Pre: otroPokemon distinto de nulo<br>
	 */
	private void golpeInicial(Pokemon otroPokemon) {
		otroPokemon.recibeDanio(fuerza);
		fuerza *= 0.5;
	}

	protected void recargar() {
	}

	/**
	 * Ataca a un {@link Pokemon} adversario con el golpe final, que sera diferente
	 * para cada tipo de Pokemon<br>
	 * 
	 * @param otroPokemon: {@link Pokemon} al que se aplicara el golpe final<br>
	 *                     Pre: otroPokemon distinto de nulo<br>
	 */
	protected abstract void golpeFinal(Pokemon otroPokemon);

	/**
	 * @param cantidad da�o recibido<br>
	 *                 Pre: cantidad mayor a 0<br>
	 */
	protected abstract void recibeDanio(double cantidad);

	public int getExp() {
		return exp;
	}

	public double getEscudo() {
		return escudo;
	}

	public double getVitalidad() {
		return vitalidad;
	}

	public double getFuerza() {
		return fuerza;
	}

	/**
	 * Dependiendo de la experiencia del {@link Pokemon},tendra una de las tres
	 * categorias existentes<br>
	 */
	@Override
	public int getCategoria() {
		int categoria;
		if (exp < 3)
			categoria = 1;
		else if (exp < 9)
			categoria = 2;
		else
			categoria = 3;
		return categoria;
	}

	public boolean isPuedeRecargar() {
		return puedeRecargar;
	}

	/**
	 * Al ganar se aumenta la experiencia 3 puntos<br>
	 */
	protected void ganar() {
		this.exp += 3;
	}

	/**
	 * Al ganar se aumenta la experencia 1 punto<br>
	 */
	protected void perder() {
		this.exp += 1;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", exp=" + exp + ", escudo=" + escudo + ", vitalidad=" + vitalidad + ", fuerza="
				+ fuerza + ", puedeRecargar=" + puedeRecargar + ", categoria=" + this.getCategoria() + "]";
	}

	/**
	 * Al ejecutarse el Pokemon recuperar� sus estadisticas iniciales<br>
	 */
	protected abstract void recuperarse();

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setEscudo(double escudo) {
		this.escudo = escudo;
	}

	public void setVitalidad(double vitalidad) {
		this.vitalidad = vitalidad;
	}

	public void setFuerza(double fuerza) {
		this.fuerza = fuerza;
	}

	public void setPuedeRecargar(boolean puedeRecargar) {
		this.puedeRecargar = puedeRecargar;
	}

}
