package uva.tds.pr4.antroma;

/**
 * Implementacion simple de una persona con amigos y conocidos
 * 
 * @author toso
 *
 */
public class Persona {

	private String nombre;
	private int id;
	private Persona[] amigos;
	private Persona[] conocidos;
	private int reservasIniciales;
	private int reservasActuales;
	
	
	/**
	 * Constructor de una Persona
	 * 
	 * @param nombre
	 *            Nombre de la persona. Debe ser correcto: No null y no cadena
	 *            vacia
	 * @param id
	 *            Numero identificador de la persona. Debe ser correto: Positivo
	 * @param amigos
	 *            Array de los amigos de la persona Debe ser correcto: No nulo
	 * @param conocidos
	 *            Array de los conocidos de la persona, los amigos tambien se
	 *            contarán como conocidos. Debe ser correcto: No nulo
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 */
	public Persona(String nombre, int id, Persona[] amigos, Persona[] conocidos, int reservas) {
		if (nombre == null)
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		if (nombre == "")
			throw new IllegalArgumentException("El nombre no puede ser cadena vacia");
		if (id <= 0)
			throw new IllegalArgumentException("El id debe ser positivo");
		if (amigos == null)
			throw new IllegalArgumentException("Amigos no puede ser nulo");
		if (conocidos == null)
			throw new IllegalArgumentException("Conocidos no puede ser nulo");
		if (reservas < 0)
			throw new IllegalArgumentException("Reservas no puede ser negativo");
		if (reservas > 10)
			throw new IllegalArgumentException("Reservas debe ser 10 como mucho");
		
		this.nombre = nombre;
		this.id = id;
		this.amigos = amigos;
		this.conocidos = conocidos;
		reservasIniciales = reservas;
		reservasActuales = reservas;
	}
	/**
	 * Devuelve los amigos de la persona
	 * @return un array de Personas que serán los amigos.
	 */
	public Persona[] getAmigos() {
		return amigos;
	}

	/**
	 * Devuelve los conocidos de la persona
	 * @return un array de Personas que serán los conocidos.
	 */
	public Persona[] getConocidos() {
		return conocidos;
	}

	/**
	 * Devuelve el nombre de la persona
	 * @return un string que será el nombre de la persona.
	 */
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	/**
	 * Devuelve el identificador de la persona
	 * @return un entero que será el identificador de la persona.
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	/**
	 * Devuelve las reservas actuales de la persona
	 * @return un entero que será las reservas actuales.
	 */
	public int getReservasActuales() {
		return reservasActuales;
	}
	
	/**
	 * Devuelve las reservas iniciales de la persona
	 * @return un entero que será las reservas iniciales.
	 */
	public int getReservasIniciales() {
		return reservasIniciales;
	}


	/**
	 * Comprueba si la persona que se le pasa es amigo o no
	 * 
	 * @param p
	 *            Persona de la que se desea saber si se es amigo o no. Debe ser
	 *            correcta: no nula.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * 
	 * @return true en caso de que sea su amiga, false en caso de que no lo sea
	 */
	public boolean isAmigo(Persona p) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Añade un nuevo conocido
	 * 
	 * @param p
	 *            persona que pasará a ser un conocido. Debe ser correcta, no
	 *            nulo, no ser ya conocido.
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 */
	public void addConocido(Persona p) {
		// TODO Auto-generated method stub

	}

	/**
	 * Comprueba si la parsona que se le pasa es conocido o no
	 * 
	 * @param p
	 *            Persona de la que se desea saber si se es conocido o no. Debe
	 *            ser correcta: no nula.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * 
	 * @return true en caso de que sea conocido, false en caso de que no lo sea
	 */
	public boolean isConocido(Persona p) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Añade un nuevo amigo
	 * 
	 * @param p
	 *            persona que pasará a ser un amigo. Debe ser correcta, no nulo,
	 *            no ser ya amigo, ser conocido.
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 */
	public void addAmigo(Persona p) {
		// TODO Auto-generated method stub

	}

	/**
	 * Elimina la persona que se le pasa de ser amigo y pasa a ser conocido
	 * 
	 * @param p
	 *            persona que dejará de ser amigo. Debe ser correcta: No nula,
	 *            ser previamente amiga.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 */
	public void removeAmigo(Persona p) {
		// TODO Auto-generated method stub

	}

}
