package uva.tds.pr4.antroma;

import org.junit.Test;

import org.junit.experimental.categories.Category;

@Category(Sequence.class)
public class PersonaSeqTest {

	@Test
	public void personaSecuenciaTest() {
		Persona p1 = new Persona("Sergio Marcos", 18273645, new Persona[0], new Persona[0], 0);
		Persona p2 = new Persona("Esteban Santos", 23147658, new Persona[0], new Persona[0], 0);

		p1.addConocido(p2);
		p1.getConocidos();
		p1.addAmigo(p2);
		p1.addConocido(p1);
		p1.getConocidos();
		p1.getAmigos();
		p1.getReservasActuales();
		p1.getReservasIniciales();
		p1.removeAmigo(p2);
		p1.setReservasActuales(2);
	}

}
