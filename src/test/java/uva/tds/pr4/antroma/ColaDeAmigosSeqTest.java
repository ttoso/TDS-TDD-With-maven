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
	public void colaDeAmigosSecuencia1Test() {
		ColaDeAmigos c = new ColaDeAmigos(new Persona[0]);
		Persona p1 = new Persona("Sergio Marcos", 18273645, new Persona[0], new Persona[0], 0);
		Persona p2 = new Persona("Esteban Santos", 23147658, new Persona[0], new Persona[0], 0);
		p1.addConocido(p);
		p.addConocido(p1);
		p1.addAmigo(p);
		p.addAmigo(p1);
		p2.addConocido(p1);
		p2.addAmigo(p1);
		p1.addConocido(p2);
		p1.addAmigo(p2);

		c.atenderSiguiente();
		c.pedirVez(p, 2);
		c.personaAAtender();
		c.reservaInicial(p);
		c.colarse(p1);
		c.personaQueConsidereAmigoParaColar(p2);
		c.amigoParaColar(p2);
		c.atenderSiguiente();
		c.getColaActual();
	}

	@Test
	public void colaDeAmigosSecuencia2Test() {
		ColaDeAmigos c = new ColaDeAmigos(new Persona[0]);
		Persona p1 = new Persona("Sergio Marcos", 18273645, new Persona[0], new Persona[0], 0);
		Persona p2 = new Persona("Esteban Santos", 23147658, new Persona[0], new Persona[0], 0);
		Persona p3 = new Persona("Jose Romero", 11223344, new Persona[0], new Persona[0], 0);
		Persona p4 = new Persona("Jaime Velasco", 13132424, new Persona[0], new Persona[0], 0);

		p1.addConocido(p);
		p.addConocido(p1);
		p1.addAmigo(p);
		p.addAmigo(p1);
		p.addConocido(p3);
		p.addAmigo(p3);
		p4.addConocido(p1);
		p1.addConocido(p4);
		p4.addAmigo(p1);
		p1.addAmigo(p4);

		c.pedirVez(p2, 3);
		c.pedirVez(p3, 3);
		c.pedirVez(p, 1);
		c.pedirVez(p4, 3);
		c.colarse(p1);
	}
}
