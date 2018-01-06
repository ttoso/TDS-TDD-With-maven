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
	
	@Test
	public void isAmigoCorrectoSiTest() {
		fail("Quitar en implementación");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		

		assertTrue(p.isAmigo(p2));
		assertNotNull(p2);
		
		
	}
	
	@Test
	public void isAmigoCorrectoNoTest() {
		fail("Quitar en implementación");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		
		
		assertFalse(p.isAmigo(p2));
		assertNotNull(p2);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isAmigoPersonaNullTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		
		p.isAmigo(null);
		
		
	}
	
	@Test
	public void isConocidoCorrectoSiTest() {
		fail("Quitar en implementación");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		

		assertTrue(p.isConocido(p2));
		assertNotNull(p2);
		
		
	}
	
	@Test
	public void isConocidoCorrectoNoTest() {
		fail("Quitar en implementación");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		
		
		assertFalse(p.isConocido(p2));
		assertNotNull(p2);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isConocidoPersonaNullTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		
		p.isConocido(null);
		
		
	}
	
	@Test
	public void addConocidoCorrectoTest() {
		fail("Quitar en implementacion");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		Persona p = new Persona(nombre, id, amigos, conocidos);
		
		p.addConocido(p2);
		
		assertNotNull(p2);
		assertTrue(!p.isConocido(p2));
		assertEquals(p2, p.getConocidos()[0]);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addConocidoPersonaNulaTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p = new Persona(nombre, id, amigos, conocidos);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		
		p.addConocido(null);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addConocidoPersonaConocidaPreviamenteTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		conocidos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos);
		
		p.addConocido(p2);	
	}
	
	
	@Test
	public void addAmigoCorrectoTest() {
		fail("Quitar en implementacion");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];

		
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos);
		Persona p = new Persona(nombre, id, amigos, conocidos);
		
		p.addAmigo(p2);
		
		assertNotNull(p2);
		assertTrue(!p.isAmigo(p2));
		assertEquals(p2, p.getConocidos()[0]);
		
	}
	

	
	

}
