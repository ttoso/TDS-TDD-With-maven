package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Unit.class)
public class PersonaTest {

	@Test
	public void ConstructorCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertEquals(nombre, p.getNombre());
		assertEquals(id, p.getId());
		assertArrayEquals(new Persona[0], p.getAmigos());
		assertArrayEquals(new Persona[0], p.getConocidos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorAmigosNuloTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, null, conocidos, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorAmigosContieneNulosTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];
		Persona[] amigos = new Persona[1];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorConocidosNuloTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, null, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorConocidosContieneNulosTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[1];
		Persona[] amigos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorNombreNuloTest() {
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(null, id, amigos, conocidos, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorNombreCadenaVaciaTest() {
		String nombre = "";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorIdNegativoTest() {
		String nombre = "Antonio Román";
		int id = 0;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorReservasNegativasTest() {
		String nombre = "Antonio Román";
		int id = 1;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorReservasMayoresA10Test() {
		String nombre = "Antonio Román";
		int id = 1;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos, 11);
	}

	@Test
	public void getAmigosCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona(nombre, 87654321, amigos, conocidos, 3);
		amigos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertArrayEquals(amigos, p.getAmigos());
	}

	@Test
	public void getConocidosCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];
		Persona[] amigos = new Persona[0];

		Persona p2 = new Persona(nombre, 87654321, amigos, conocidos, 3);
		conocidos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertArrayEquals(conocidos, p.getConocidos());
	}

	@Test
	public void getNombreCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];
		Persona[] amigos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertEquals(nombre, p.getNombre());
	}

	@Test
	public void getIdCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];
		Persona[] amigos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertEquals(id, p.getId());
	}

	@Test
	public void getReservasActualesCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertEquals(3, p.getReservasActuales());
	}

	@Test
	public void getReservasInicialesCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertEquals(3, p.getReservasIniciales());
	}

	@Test
	public void setReservasInicialesCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		p.setReservasIniciales(5);

		assertEquals(5, p.getReservasIniciales());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setReservasInicialesReservasMayorQue10Test() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		p.setReservasIniciales(11);

	}

	@Test(expected = IllegalArgumentException.class)
	public void setReservasInicialesReservasNegativoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		p.setReservasIniciales(-1);

	}
	
	@Test
	public void setReservasActualesCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		p.setReservasActuales(5);

		assertEquals(5, p.getReservasActuales());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setReservasActualesReservasMayorQue10Test() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		p.setReservasActuales(11);

	}

	@Test(expected = IllegalArgumentException.class)
	public void setReservasActualesReservasNegativoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		p.setReservasActuales(-1);

	}

	@Test
	public void isAmigoCorrectoSiTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		amigos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertTrue(p.isAmigo(p2));

	}

	@Test
	public void isAmigoCorrectoNoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);

		assertFalse(p.isAmigo(p2));

	}

	@Test(expected = IllegalArgumentException.class)
	public void isAmigoPersonaNullTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);

		p.isAmigo(null);

	}

	@Test
	public void isConocidoCorrectoSiTest() {

		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		conocidos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		assertTrue(p.isConocido(p2));

	}

	@Test
	public void isConocidoCorrectoNoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);

		assertFalse(p.isConocido(p2));

	}

	@Test(expected = IllegalArgumentException.class)
	public void isConocidoPersonaNullTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);

		p.isConocido(null);

	}

	@Test
	public void addConocidoCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.addConocido(p2);

		assertEquals(p2, p.getConocidos()[0]);

	}

	@Test(expected = IllegalArgumentException.class)
	public void addConocidoPersonaNulaTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos, 3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);

		p.addConocido(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addConocidoPersonaConocidaPreviamenteTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		conocidos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.addConocido(p2);
	}

	@Test
	public void addAmigoCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		conocidos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.addAmigo(p2);

		assertEquals(p2, p.getAmigos()[0]);

	}

	@Test(expected = IllegalArgumentException.class)
	public void addAmigoPersonaNulaTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		conocidos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.addAmigo(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addAmigoPersonaAmigaPreviamenteTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		amigos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.addAmigo(p2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addAmigoPersonaNoEnConocidosTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.addAmigo(p2);
	}

	@Test
	public void removeAmigoCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		Persona p3 = new Persona("Jose Romero", 51324331, amigos, conocidos, 3);
		amigos = new Persona[] { p2, p3 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.removeAmigo(p2);

		assertNotEquals(p2, p.getAmigos()[0]);

	}

	@Test(expected = IllegalArgumentException.class)
	public void removeAmigoPersonaNulaTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		amigos = new Persona[] { p2 };
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.removeAmigo(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void removeAmigoPersonaNoEnAmigosTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos, 3);
		Persona p = new Persona(nombre, id, amigos, conocidos, 3);

		p.removeAmigo(p2);

	}

}
