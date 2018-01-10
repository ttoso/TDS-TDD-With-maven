package uva.tds.pr4.antroma;

import java.util.ArrayList;

/**
 * Implementación simple de una cola para amigos
 * 
 * @author toso
 *
 */
public class ColaDeAmigos {

	private ArrayList<Persona> colaActual = new ArrayList<>();

	/**
	 * Constructor de una cola de amigos
	 * 
	 * @param colaInicial
	 *            array que indicará la cola que se tiene actualmente. Debe ser
	 *            correcto. no nulo, no contener elemntos nulos.
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 */
	public ColaDeAmigos(Persona[] colaInicial) {
		if (colaInicial == null)
			throw new IllegalArgumentException("La cola inicial no puede ser nula");
		if (hasElementosNulos(colaInicial))
			throw new IllegalArgumentException("colaInicial no puede contener elmentos nulos");

		for (int i = 0; i < colaInicial.length; i++) {
			colaActual.add(colaInicial[i]);
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
	 * Devuelve la cola que hay actualmente
	 * 
	 * @return un array de personas cuyo orden será el de la cola, null en caso.
	 */
	public Persona[] getColaActual() {
		Persona[] res = new Persona[colaActual.size()];
		if (!colaActual.isEmpty()) {
			for (int i = 0; i < res.length; i++) {
				res[i] = colaActual.get(i);
			}
			return res;
		} else
			return new Persona[0];
	}

	/**
	 * Mete a una persona en la cola y anota la reserva que haga
	 * 
	 * @param p
	 *            persona que se añade a la cola. Debe ser correcta: no nula, no
	 *            estar previamente en la cola.
	 * @param reserva
	 *            numero de personas para las que reserva sitio. Debe ser
	 *            correcta: positiva o 0 si no se quiere reservar, menor que 11.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 */
	public void pedirVez(Persona p, int reserva) {
		if (p == null)
			throw new IllegalArgumentException("La persnna no puede ser nula");
		if (isInCola(p))
			throw new IllegalArgumentException("La persona no debe estar prevaimente en la cola");
		if (reserva < 0)
			throw new IllegalArgumentException("La reserva debe ser como minimo 0");
		if (reserva > 10)
			throw new IllegalArgumentException("La reserva debe ser como maximo 10");

		p.setReservasActuales(reserva);
		p.setReservasIniciales(reserva);
		colaActual.add(p);
	}

	/**
	 * Comprueba si la persona que se le pasa esta en la cola o no
	 * 
	 * @param p
	 *            Persona de la que se desea saber si se es amigo o no. Debe ser
	 *            correcta: no nula.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * 
	 * @return true en caso de que este en la cola, false en caso contrario.
	 */
	public boolean isInCola(Persona p) {
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nulo");

		boolean res = false;
		if (!colaActual.isEmpty()) {
			for (int i = 0; i < colaActual.size(); i++) {
				if (colaActual.get(i).equals(p)) {
					res = true;
				}
			}
		}
		return res;
	}

	/**
	 * Indica el numero de reservas que hizo la persona al llegar
	 * 
	 * @param p
	 *            persona de la que se desean conocer sus reservas. Debe ser
	 *            correcta. no nula, estar previamente en la cola.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * @return el numero de huecos reservados inicialmente
	 */
	public int reservaInicial(Persona p) {
		if (p == null)
			throw new IllegalArgumentException("La persona que se pasa no puede ser nula");
		if (!isInCola(p))
			throw new IllegalArgumentException("La persona proporcionada debe estar prevaimente en la cola");

		return p.getReservasIniciales();
	}

	/**
	 * Persona que será la siguiente en ser atendida
	 * 
	 * @return La persona que sera atendida primero, null en caso de que no
	 *         halla nadie.
	 */
	public Persona personaAAtender() {
		if (colaActual.isEmpty()) {
			return null;
		}
		return colaActual.get(0);
	}

	/**
	 * Atiende a la primera persona en la cola y la retira de ella.
	 */
	public void atenderSiguiente() {
		if (!colaActual.isEmpty()) {
			colaActual.remove(0);
		}

	}

	/**
	 * Numero de amigos que todavia puede colar la persona que se le pasa
	 * 
	 * @param p
	 *            persona de la que se desea saber el numero de amigos por
	 *            colar. Debe ser correcta: no nula, estar previamente en la
	 *            cola
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * @return un entero que es el numero de amigos por colar.
	 */
	public int amigosporColar(Persona p) {
		if (p == null)
			throw new IllegalArgumentException("La persona proporcionada no puede ser nula");
		if (!isInCola(p))
			throw new IllegalArgumentException("La persona debe estar prevaimente en la cola");

		return p.getReservasActuales();
	}

	/**
	 * Amigos que ha colado una persona
	 * 
	 * @param p
	 *            persona de la que se desea saber cuantos amigos ha colado.
	 *            Debe ser correcta: no nula, estar previamente en la cola.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * @return un array de personas que son los amigos que la persona ha colado,
	 *         null en el caso de que no haya ninguno.
	 */
	public Persona[] amigosColados(Persona p) {
		if (p == null)
			throw new IllegalArgumentException("La persona introducida no puede ser nula");
		if (!isInCola(p))
			throw new IllegalArgumentException("La persona debe estar prevaimente en la cola");

		int numeroAmigos = p.getReservasIniciales() - p.getReservasActuales();
		if (numeroAmigos > 0) {
			Persona[] resultado = new Persona[numeroAmigos];
			for (int i = colaActual.indexOf(p)-1; i > colaActual.indexOf(p)-numeroAmigos-1; i--) {
				resultado[i] = colaActual.get(colaActual.indexOf(p) - i - 1);
			}
			return resultado;
		}
		return new Persona[0];
	}

	/**
	 * Colarse delante de un amigo en la cola
	 * 
	 * @param p2
	 *            Persona que desea colarse. Debe ser correcta: No nula, no
	 *            estar previamente en la cola, tener un amigo en la cola que
	 *            pueda colarle, tener una persona que lo considere amigo en la
	 *            cola.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 */
	public void colarse(Persona p) {
		if (p == null)
			throw new IllegalArgumentException("La persona introducida no puede ser nula");
		if (isInCola(p))
			throw new IllegalArgumentException("La persona no debe estar prevaimente en la cola");
		if (!amigoParaColar(p))
			throw new IllegalArgumentException("La persona debe tener un amigo que pueda colar en la cola");
		if (!personaQueConsidereAmigoParaColar(p))
			throw new IllegalArgumentException(
					"La persona debe tener una persona que la considere amigo y que pueda colar en la cola");

		if (p.getAmigos() != null) {
			for (int i = 0; i < colaActual.size(); i++) {
				if (p.isAmigo(colaActual.get(i)) && colaActual.get(i).isAmigo(p)
						&& colaActual.get(i).getReservasActuales() > 0) {
					colaActual.add(colaActual.indexOf(colaActual.get(i)), p);
					p.setReservasActuales(0);
					p.setReservasIniciales(0);
					p.getAmigos()[i].setReservasActuales(p.getAmigos()[i].getReservasActuales() - 1);
					break;
				}
			}
		}

	}

	/**
	 * Indica si una persona tiene amigos en la cola que puedan colarlo
	 * 
	 * @param p
	 *            persona que se desea comprobar si tiene amigos. Debe ser
	 *            correcta: no nula.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * @return true en caso de que tenga al menos un amigo que pueda colarlo,
	 *         false en caso contrario.
	 */
	public boolean personaQueConsidereAmigoParaColar(Persona p) {
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nula");

		for (int i = 0; i < colaActual.size(); i++) {
			if (p.isAmigo(colaActual.get(i)) && colaActual.get(i).getReservasActuales() > 0)
				return true;
		}
		return false;
	}

	/**
	 * Indica si hay personas en la cola que consideren amigo a otra y puedan
	 * colarlo
	 * 
	 * @param p
	 *            persona que se desea comprobar si tiene personas que lo
	 *            consideran amigo. Debe ser correcta: no nula.
	 * 
	 * @throws IllegalArgumentException
	 *             En caso de incumplir alguna de las condiciones impuestas a
	 *             los argumentos del constructor.
	 * @return true en caso de que tenga al menos un amigo que pueda colarlo,
	 *         false en caso contrario.
	 */
	public boolean amigoParaColar(Persona p) {
		if (p == null)
			throw new IllegalArgumentException("La persona no puede ser nula");

		for (int i = 0; i < colaActual.size(); i++) {
			if (colaActual.get(i).isAmigo(p) && colaActual.get(i).getReservasActuales() > 0)
				return true;
		}
		return false;
	}

}
