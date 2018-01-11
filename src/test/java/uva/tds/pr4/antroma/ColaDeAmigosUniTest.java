package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Unit.class)
public class ColaDeAmigosUniTest{

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
	public void personaAAtenderCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		cola.pedirVez(p, reserva);

		assertEquals(p, cola.personaAAtender());
	}

	@Test
	public void atenderSiguienteCorrectoTest() {
		Persona[] colaInicial = new Persona[1];
		colaInicial[0] = p;

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		cola.atenderSiguiente();

		assertNotEquals(p, cola.personaAAtender());
	}

	@Test
	public void amigosColadosCorrectoNingunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertArrayEquals(new Persona[0], cola.amigosColados(p));
	}

	@Test
	public void amigosColadosCorrectoAlgunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);
		p2.addConocido(p);
		p2.addAmigo(p);

		p.addConocido(p2);
		p.addAmigo(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

		assertArrayEquals(new Persona[] { p2 }, cola.amigosColados(p));
	}
	
	@Test
	public void amigosColadosPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);
		p2.addConocido(p);
		p2.addAmigo(p);

		p.addConocido(p2);
		p.addAmigo(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);


	    cola.amigosColados(null);
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
