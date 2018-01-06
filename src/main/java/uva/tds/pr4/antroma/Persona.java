package uva.tds.pr4.antroma;

/**
 * Implementacion simple de una persona con amigos y conocidos
 * 
 * @author toso
 *
 */
public class Persona {

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
	public Persona(String nombre, int id, Persona[] amigos, Persona[] conocidos) {
		// TODO Auto-generated constructor stub

	}

	public Persona[] getAmigos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona[] getConocidos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
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
	 * Añade un unievo conocido
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

}
