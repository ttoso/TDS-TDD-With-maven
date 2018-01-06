package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest {

	@Test
	public void ConstructorCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);

		assertEquals(nombre, p.getNombre());
		assertEquals(id, p.getId());
		assertArrayEquals(amigos, p.getAmigos());
		assertArrayEquals(conocidos, p.getConocidos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorAmigosNuloTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, null, conocidos);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorConocidosNuloTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorNombreNuloTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(null, id, amigos, conocidos);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorNombreCadenaVaciaTest() {
		String nombre = "";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorIdNegativoTest() {
		String nombre = "Antonio Román";
		int id = 0;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
	}

	@Test
	public void getAmigosCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);

		assertArrayEquals(amigos, p.getAmigos());
	}

	@Test
	public void getConocidosCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[3];
		Persona[] amigos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);

		assertArrayEquals(conocidos, p.getConocidos());
	}
	
	@Test
	public void getNombreCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[3];
		Persona[] amigos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);

		assertEquals(nombre, p.getNombre());
	}
	
	@Test
	public void getIdCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[3];
		Persona[] amigos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);

		assertEquals(id, p.getId());
	}

}
