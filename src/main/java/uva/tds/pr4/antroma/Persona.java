package uva.tds.pr4.antroma;

import java.util.ArrayList;

/**
 * Implementacion simple de una persona con amigos y conocidos
 * 
 * @author toso
 *
 */
public class Persona {

	private String nombre;
	private int id;
	private ArrayList<Persona> amigos = new ArrayList<>();
	private ArrayList<Persona> conocidos = new ArrayList<>();
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
	 *            Array de los amigos de la persona Debe ser correcto: No nulo,
	 *            no contener elmentos nulos
	 * @param conocidos
	 *            Array de los conocidos de la persona, los amigos tambien se
	 *            contarán como conocidos. Debe ser correcto: No nulo, no
	 *            contener elementos nulos
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
		if (hasElementosNulos(amigos))
			throw new IllegalArgumentException("Reservas debe ser 10 como mucho");
		if (hasElementosNulos(conocidos))
			throw new IllegalArgumentException("Reservas debe ser 10 como mucho");

		this.nombre = nombre;
		this.id = id;
		reservasIniciales = reservas;
		reservasActuales = reservas;
		for (int i = 0; i < conocidos.length; i++) {
			this.conocidos.add(conocidos[i]);
		}
		for (int i = 0; i < amigos.length; i++) {
			this.amigos.add(amigos[i]);
		}
	}

	private boolean hasElementosNulos(Persona[] datos) {
		for (int i = 0; i < datos.length; i++) {
			if (datos[0] == null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Devuelve los amigos de la persona
	 * 
	 * @return un array de Personas que serán los amigos.
	 */
	public Persona[] getAmigos() {
		Persona[] res = new Persona[amigos.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = amigos.get(i);
		}
		return res;
	}

	/**
	 * Devuelve los conocidos de la persona
	 * 
	 * @return un array de Personas que serán los conocidos.
	 */
	public Persona[] getConocidos() {
		Persona[] res = new Persona[conocidos.size()];
		for (int i = 0; i < conocidos.size(); i++) {
			res[i] = conocidos.get(i);
		}
		return res;
	}

	/**
	 * Devuelve el nombre de la persona
	 * 
	 * @return un string que será el nombre de la persona.
	 */
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	/**
	 * Devuelve el identificador de la persona
	 * 
	 * @return un entero que será el identificador de la persona.
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/**
	 * Devuelve las reservas actuales de la persona
	 * 
	 * @return un entero que será las reservas actuales.
	 */
	public int getReservasActuales() {
		return reservasActuales;
	}

	/**
	 * Devuelve las reservas iniciales de la persona
	 * 
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
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nulo");
        
		boolean res = false;
		if (amigos.size() != 0) {
			for (int i = 0; i < amigos.size(); i++) {
				if (amigos.get(i).equals(p)) {
					res = true;
				}
			}
		}
		return res;
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
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nulo");
		if (isConocido(p))
			throw new IllegalArgumentException("La persona no puede ser nulo");

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
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nulo");

		boolean res = false;
		if (conocidos.size() != 0) {
			for (int i = 0; i < conocidos.size(); i++) {
				if (conocidos.get(i).equals(p)) {
					res = true;
				}
			}
		}
		if (amigos.size() != 0) {
			for (int i = 0; i < amigos.size(); i++) {
				if (amigos.get(i).equals(p)) {
					res = true;
				}
			}
		}

		return res;
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
