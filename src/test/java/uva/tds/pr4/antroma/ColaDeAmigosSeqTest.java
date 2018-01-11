package uva.tds.pr4.antroma;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.omg.Messaging.SyncScopeHelper;

@Category(Sequence.class)
public class ColaDeAmigosSeqTest {

	private String nombre;
	private int id;
	private Persona[] amigos;
	private Persona[] conocidos;

	private Persona p;

	@Before
	public void setUp() throws Exception {
		nombre = "Antonio Román";
		id = 12345678;
		amigos = new Persona[0];
		conocidos = new Persona[0];

		p = new Persona(nombre, id, amigos, conocidos, 0);
	}

	@After
	public void tearDown() throws Exception {
		nombre = null;
		id = 0;
		amigos = null;
		conocidos = null;

		p = null;
	}
	
	@Test
	public void colaDeAmigosSecuenciaTest() {
		ColaDeAmigos c = new ColaDeAmigos(new Persona[0]);
		Persona p1 = new Persona("Sergio Marcos", 18273645, new Persona[0], new Persona[0], 0);
		Persona p2 = new Persona("Esteban Santos", 23147658, new Persona[0], new Persona[0], 0);
		p1.addConocido(p);
		p.addConocido(p1);
		p1.addAmigo(p);
		p.addAmigo(p1);
		
		c.pedirVez(p2, 0);
		c.atenderSiguiente();
		c.pedirVez(p, 2);
		c.personaAAtender();
		c.reservaInicial(p);
		c.colarse(p1);
		c.atenderSiguiente();
		c.getColaActual();
	}
}
