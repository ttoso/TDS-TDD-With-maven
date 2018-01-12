package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Unit.class)
public class ColaDeAmigosUniTest {

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
	public void constructorCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		assertArrayEquals(new Persona[0], cola.getColaActual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorColaInicialNulaTest() {
		@SuppressWarnings("unused")
		ColaDeAmigos cola = new ColaDeAmigos(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorColaInicialConElementosNulosTest() {
		Persona[] colaInicial = new Persona[1];

		@SuppressWarnings("unused")
		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
	}

	@Test
	public void getColaActualCorrectoTest() {
		Persona[] colaInicial = new Persona[1];
		colaInicial[0] = p;

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		assertArrayEquals(colaInicial, cola.getColaActual());
	}

	@Test
	public void siguientePersonaQueSeAtenderaCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		cola.pedirVez(p, reserva);

		assertEquals(p, cola.siguientePersonaQueSeAtendera());
	}

	@Test
	public void atenderSiguienteCorrectoTest() {
		Persona[] colaInicial = new Persona[1];
		colaInicial[0] = p;

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		cola.atenderSiguiente();

		assertNotEquals(p, cola.siguientePersonaQueSeAtendera());
	}

	@Test
	public void isInColaCorrectoSiTest() {
		Persona[] colaInicial = new Persona[1];
		colaInicial[0] = p;

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		assertTrue(cola.isInCola(p));

	}

	@Test
	public void isInColaCorrectoNoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		assertFalse(cola.isInCola(p));

	}

	@Test(expected = IllegalArgumentException.class)
	public void isInColaPersonaNullTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		cola.isInCola(null);

	}

}
