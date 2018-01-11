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
		if (elmNulo(nombre, amigos, conocidos))
			throw new IllegalArgumentException("Ninguno de los atributos puede ser nulo");
		if (nombre == "")
			throw new IllegalArgumentException("El nombre no puede ser cadena vacia");
		if (id <= 0)
			throw new IllegalArgumentException("El id debe ser positivo");
		if (reservas < 0)
			throw new IllegalArgumentException("Reservas no puede ser negativo");
		if (reservas > 10)
			throw new IllegalArgumentException("Reservas debe ser 10 como mucho");
		if (hasElementosNulos(amigos))
			throw new IllegalArgumentException("Amigos no puede contener elementos nulos");
		if (hasElementosNulos(conocidos))
			throw new IllegalArgumentException("Conocidos no puede contener elementos nulos");

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

	private boolean elmNulo(String nombre, Persona[] amigos, Persona[] conocidos) {
		if (nombre == null) {
			return true;
		}
		if (amigos == null) {
			return true;
		}
		
		return conocidos == null;
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
	 * Asigna el valor que se le pasa a reservasIniciales.
	 * 
	 * @param numReservas
	 *            numero de reservas que se desean asignar. Debe ser correcto,
	 *            entre 0 y 10 ambos inclusive.
	 */
	public void setReservasIniciales(int reservasIniciales) {
		if (reservasIniciales < 0)
			throw new IllegalArgumentException("La reserva debe ser como minimo 0");
		if (reservasIniciales > 10)
			throw new IllegalArgumentException("La reserva debe ser como maximo 10");

		this.reservasIniciales = reservasIniciales;
	}

	/**
	 * Asigna el valor que se le pasa a reservasActuales.
	 * 
	 * @param numReservas
	 *            numero de reservas que se desean asignar. Debe ser correcto,
	 *            entre 0 y 10 ambos inclusive.
	 */
	public void setReservasActuales(int reservasActuales) {
		if (reservasActuales < 0)
			throw new IllegalArgumentException("La reserva debe ser como minimo 0");
		if (reservasActuales > 10)
			throw new IllegalArgumentException("La reserva debe ser como maximo 10");

		this.reservasActuales = reservasActuales;
	}

	/**
	 * Devuelve los amigos de la persona
	 * 
	 * @return un array de Personas que serán los amigos, null en caso de que no
	 *         haya ninguno.
	 */
	public Persona[] getAmigos() {
		Persona[] res = new Persona[amigos.size()];
		if (!amigos.isEmpty()) {
			for (int i = 0; i < res.length; i++) {
				res[i] = amigos.get(i);
			}
			return res;
		}
		return new Persona[0];
	}

	/**
	 * Devuelve los conocidos de la persona
	 * 
	 * @return un array de Personas que serán los conocidos, null en caso de que
	 *         no aya ninguno.
	 */
	public Persona[] getConocidos() {
		Persona[] res1 = new Persona[conocidos.size()];
		Persona[] res2 = new Persona[amigos.size()];
		if (!conocidos.isEmpty()) {
			for (int i = 0; i < conocidos.size(); i++) {
				res1[i] = conocidos.get(i);
			}
		}

		if (!amigos.isEmpty()) {
			for (int i = 0; i < amigos.size(); i++) {
				res2[i] = amigos.get(i);
			}
		}

		if (res1.length != 0 && res2.length != 0) {
			Persona[] res = new Persona[res1.length + res2.length];
			for (int i = 0; i < res1.length; i++) {
				res[i] = res1[i];
			}
			for (int i = res1.length; i < res.length; i++) {
				res[i] = res2[i - res1.length];
			}
			return res;
		} else if (res1.length != 0) {
			return res1;
		}else return res2;

	}

	/**
	 * Devuelve el nombre de la persona
	 * 
	 * @return un string que será el nombre de la persona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el identificador de la persona
	 * 
	 * @return un entero que será el identificador de la persona.
	 */
	public int getId() {
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
			throw new IllegalArgumentException("La persona proporcionada no puede ser nulo");

		boolean res = false;
		if (!amigos.isEmpty()) {
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
			throw new IllegalArgumentException("La persona introducida no puede ser nulo");
		if (isConocido(p))
			throw new IllegalArgumentException("La persona no puede ser conocido previamente");

		conocidos.add(p);
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
			throw new IllegalArgumentException("La persona proporcionada no puede ser nulo");

		boolean res = false;
		if (!conocidos.isEmpty()) {
			for (int i = 0; i < conocidos.size(); i++) {
				if (conocidos.get(i).equals(p)) {
					res = true;
				}
			}
		}
		if (!amigos.isEmpty()) {
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
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nulo");
		if (!isConocido(p))
			throw new IllegalArgumentException("La persona debe ser conocido previamente");
		if (isAmigo(p))
			throw new IllegalArgumentException("La persona no puede ser amigo previamente");

		conocidos.remove(conocidos.indexOf(p));
		amigos.add(p);
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
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nulo");
		if (!isAmigo(p))
			throw new IllegalArgumentException("La persona debe ser amigo previamente");

		amigos.remove(amigos.indexOf(p));
	}

	@Override
	public String toString() {
		return nombre;
	}

}
