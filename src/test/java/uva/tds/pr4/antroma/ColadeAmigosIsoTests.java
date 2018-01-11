package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Isolation.class)
public class ColadeAmigosIsoTests {

	@Mock
	private Persona p;

	@Test
	public void pedirVezCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(1);
		replay(p);

		cola.pedirVez(p, reserva);

		assertEquals(p, cola.getColaActual()[cola.getColaActual().length - 1]);
		assertEquals(reserva, cola.reservaInicial(p));
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(1);
		replay(p);

		cola.pedirVez(null, reserva);
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezPersonaYaEnLaColaTest() {
		Persona[] colaInicial = new Persona[1];
		colaInicial[0] = p;

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(1);
		replay(p);

		cola.pedirVez(p, reserva);
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezReservaNoPositivaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = -1;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(1);
		replay(p);

		cola.pedirVez(p, reserva);
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void pedirVezReservaMayorQue10Test() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 11;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(1);
		replay(p);

		cola.pedirVez(p, reserva);
		verify(p);
	}

	@Test
	public void reservaInicialCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(2);
		replay(p);

		cola.pedirVez(p, reserva);
		cola.reservaInicial(p);

		assertEquals(reserva, cola.reservaInicial(p));
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void reservainicialPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(2);
		replay(p);

		cola.pedirVez(p, reserva);
		cola.reservaInicial(null);
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void reservainicialPersonaNoEnLacolaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).times(2);
		replay(p);

		cola.reservaInicial(p);
		verify(p);
	}

	@Test
	public void amigosPorColarCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasActuales()).andReturn((int) 3).once();
		replay(p);

		cola.pedirVez(p, reserva);

		assertEquals(reserva, cola.amigosporColar(p));
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void amigosPorColarPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasActuales()).andReturn((int) 3).once();
		replay(p);

		cola.pedirVez(p, reserva);

		cola.amigosporColar(null);
		verify(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void amigosPorColarPersonaNoPreviamenteEnLaColaTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasActuales()).andReturn((int) 3).once();
		replay(p);

		cola.amigosporColar(p);
		verify(p);
	}

	@Test
	public void amigosColadosCorrectoNingunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;

		p = createMock(Persona.class);
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.getReservasIniciales()).andReturn((int) 3).once();
		expect(p.getReservasActuales()).andReturn((int) 3).once();
		replay(p);

		cola.pedirVez(p, reserva);

		assertArrayEquals(new Persona[0], cola.amigosColados(p));
		verify(p);
	}

	@Test
	public void amigosColadosCorrectoAlgunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);

		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasIniciales()).andReturn((int) 3).once();
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		expect(p.getReservasActuales()).andReturn((int) 2).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

		assertArrayEquals(new Persona[] { p2 }, cola.amigosColados(p));
		verify(p);
		verify(p2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void amigosColadosPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];
		
		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);

		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasIniciales()).andReturn((int) 3).once();
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		expect(p.getReservasActuales()).andReturn((int) 2).times(1);
		replay(p);
		replay(p2);


		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

		cola.amigosColados(null);
		verify(p);
		verify(p2);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void amigosColadosPersonaNulaAlgunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasIniciales()).andReturn((int) 3).once();
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		expect(p.getReservasActuales()).andReturn((int) 2).times(1);
		replay(p);
		replay(p2);
	
		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

		cola.amigosColados(null);
		verify(p);
		verify(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void amigosColadosPersonaNoEnLaColaAlgunoColadoTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasIniciales()).andReturn((int) 3).once();
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		expect(p.getReservasActuales()).andReturn((int) 2).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);

		cola.amigosColados(p);
		verify(p);
		verify(p2);
	}
	
	@Test
	public void colarseCorrectoTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

		assertEquals(p2, cola.getColaActual()[0]);
		verify(p);
		verify(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(null);

		verify(p);
		verify(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaYaEnLaColaTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p);

		verify(p);
		verify(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaSinAmigoEnLaColaTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) false).times(2);
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);
		
		verify(p);
		verify(p2);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void colarsePersonaSinQueNadieloConsidereAmigoTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasActuales(2);
		EasyMock.expectLastCall();
		p2.setReservasActuales(0);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		p2.setReservasIniciales(0);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) false).times(2);
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(2);
		expect(p.getReservasActuales()).andReturn((int) 3).times(4);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);
		cola.colarse(p2);

		verify(p);
		verify(p2);
	}
	
	@Test
	public void personaQueConsidereAmigoParaColarCorrectoSiTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(1);
		expect(p.getReservasActuales()).andReturn((int) 3).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertTrue(cola.personaQueConsidereAmigoParaColar(p2));
		verify(p);
		verify(p2);
	}
	
	@Test
	public void personaQueConsidereAmigoParaColarCorrectoNoTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p2.isAmigo(p)).andReturn((boolean) false).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertFalse(cola.personaQueConsidereAmigoParaColar(p2));
		verify(p);
		verify(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void personaQueConsidereAmigoParaColarPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p2.isAmigo(p)).andReturn((boolean) true).times(1);
		expect(p.getReservasActuales()).andReturn((int) 3).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		cola.personaQueConsidereAmigoParaColar(null);
		verify(p);
		verify(p2);
	}
	
	@Test
	public void amigoParaColarCorrectoSiTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(1);
		expect(p.getReservasActuales()).andReturn((int) 3).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertTrue(cola.amigoParaColar(p2));
		verify(p);
		verify(p2);
	}
	
	@Test
	public void amigoParaColarCorrectoNoTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) false).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		assertFalse(cola.amigoParaColar(p2));
		verify(p);
		verify(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void amigoParaColarPersonaNulaTest() {
		Persona[] colaInicial = new Persona[0];

		p = createMock(Persona.class);
		Persona p2 = createMock(Persona.class);
		
		p.setReservasActuales(3);
		EasyMock.expectLastCall();
		p.setReservasIniciales(3);
		EasyMock.expectLastCall();
		expect(p.isAmigo(p2)).andReturn((boolean) true).times(1);
		expect(p.getReservasActuales()).andReturn((int) 3).times(1);
		replay(p);
		replay(p2);

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		int reserva = 3;
		cola.pedirVez(p, reserva);

		cola.amigoParaColar(null);
		verify(p);
		verify(p2);
	}
}
