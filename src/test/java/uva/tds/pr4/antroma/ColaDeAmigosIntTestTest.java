package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.experimental.categories.Category;

@Category(Integration.class)
public class ColaDeAmigosIntTestTest {

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
	public void pedirVezCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		cola.pedirVez(p, reserva);

		assertEquals(p, cola.getColaActual()[cola.getColaActual().length - 1]);
		assertEquals(reserva, cola.reservaInicial(p));
	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		cola.pedirVez(null, reserva);

	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezPersonaYaEnLaColaTest() {
		Persona[] colaInicial = new Persona[1];
		colaInicial[0] = p;

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		cola.pedirVez(p, reserva);

	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezReservaNoPositivaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = -1;

		cola.pedirVez(p, reserva);

	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezReservaMayorQue10Test() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 11;

		cola.pedirVez(p, reserva);

	}

	@Test
	public void reservaInicialCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		cola.pedirVez(p, reserva);
		cola.reservaInicial(p);

		assertEquals(reserva, cola.reservaInicial(p));
	}

	@Test(expected = IllegalArgumentException.class)
	public void reservainicialPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		cola.pedirVez(p, reserva);
		cola.reservaInicial(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void reservainicialPersonaNoEnLacolaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		cola.reservaInicial(p);

	}

	@Test
	public void amigosPorColarCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertEquals(reserva, cola.amigosPorColar(p));
	}

	@Test(expected = IllegalArgumentException.class)
	public void amigosPorColarPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		cola.amigosPorColar(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void amigosPorColarPersonaNoPreviamenteEnLaColaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		cola.amigosPorColar(p);
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

	@Test(expected = IllegalArgumentException.class)
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

	@Test(expected = IllegalArgumentException.class)
	public void amigosColadosPersonaNulaAlgunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);
		p2.addConocido(p);
		p2.addAmigo(p);

		amigos = new Persona[] { p2 };
		p2 = new Persona(nombre, id, amigos, conocidos, 0);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

		cola.amigosColados(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void amigosColadosPersonaNoEnLaColaAlgunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);
		p2.addConocido(p);
		p2.addAmigo(p);

		amigos = new Persona[] { p2 };
		p2 = new Persona(nombre, id, amigos, conocidos, 0);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		cola.amigosColados(p);
	}

	@Test
	public void colarseCorrectoTest() {
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

		assertEquals(p2, cola.getColaActual()[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaNulaTest() {
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
		cola.colarse(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaYaEnLaColaTest() {
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
		cola.colarse(p);

	}

	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaSinAmigoEnLaColaTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);

		p.addConocido(p2);
		p.addAmigo(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

	}

	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaSinQueNadieloConsidereAmigoTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);
		p2.addConocido(p);
		p2.addAmigo(p);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

	}

	@Test
	public void amigoEnLaColaQuePuedaColarloCorrectoSiTest() {
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

		assertTrue(cola.amigoEnLaColaQuePuedaColarlo(p2));
	}

	@Test
	public void amigoEnLaColaQuePuedaColarloCorrectoNoTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);

		p.addConocido(p2);
		p.addAmigo(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertFalse(cola.amigoEnLaColaQuePuedaColarlo(p2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void amigoEnLaColaQuePuedaColarloPersonaNulaTest() {
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

		cola.amigoEnLaColaQuePuedaColarlo(null);
	}

	@Test
	public void personaPorLaQueSeEsConsideradoAmigoParaColarCorrectoSiTest() {
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

		assertTrue(cola.personaPorLaQueSeEsConsideradoAmigoParaColar(p2));
	}

	@Test
	public void personaPorLaQueSeEsConsideradoAmigoParaColarCorrectoNoTest() {
		Persona[] colaInicial = new Persona[0];

		String nombre2 = "Manuel Pino";
		int id2 = 87654321;
		Persona[] amigos2 = new Persona[0];
		Persona[] conocidos2 = new Persona[0];

		Persona p2 = new Persona(nombre2, id2, amigos2, conocidos2, 0);

		p2.addConocido(p);
		p2.addAmigo(p);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertFalse(cola.personaPorLaQueSeEsConsideradoAmigoParaColar(p2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void personaPorLaQueSeEsConsideradoAmigoParaColarPersonaNulaTest() {
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

		cola.personaPorLaQueSeEsConsideradoAmigoParaColar(null);
	}
}
