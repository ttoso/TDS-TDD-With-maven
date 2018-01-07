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

		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		assertEquals(nombre, p.getNombre());
		assertEquals(id, p.getId());
		assertArrayEquals(amigos, p.getAmigos());
		assertArrayEquals(conocidos, p.getConocidos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorAmigosNuloTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, null, conocidos,3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ConstructorConocidosNuloTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, null,3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorNombreNuloTest() {
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(null, id, amigos, conocidos,3);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorNombreCadenaVaciaTest() {
		String nombre = "";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorIdNegativoTest() {
		String nombre = "Antonio Román";
		int id = 0;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorReservasNegativasTest() {
		String nombre = "Antonio Román";
		int id = 1;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos,-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorReservasMayoresA10Test() {
		String nombre = "Antonio Román";
		int id = 1;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		@SuppressWarnings("unused")
		Persona p = new Persona(nombre, id, amigos, conocidos,11);
	}

	@Test
	public void getAmigosCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		assertArrayEquals(amigos, p.getAmigos());
	}

	@Test
	public void getConocidosCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];
		Persona[] amigos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		assertArrayEquals(conocidos, p.getConocidos());
	}
	
	@Test
	public void getNombreCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];
		Persona[] amigos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		assertEquals(nombre, p.getNombre());
	}
	
	@Test
	public void getIdCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] conocidos = new Persona[0];
		Persona[] amigos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		assertEquals(id, p.getId());
	}
	
	@Test
	public void getReservasActualesCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		assertEquals(3, p.getReservasActuales());
	}
	
	@Test
	public void getReservasInicialesCorrectoTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		assertEquals(3, p.getReservasIniciales());
	}
	
	@Test
	public void isAmigoCorrectoSiTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[1];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		amigos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		

		assertTrue(p.isAmigo(p2));
		
		
	}
	
	@Test
	public void isAmigoCorrectoNoTest() {
		fail("Quitar en implementación");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		
		
		assertFalse(p.isAmigo(p2));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isAmigoPersonaNullTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		
		p.isAmigo(null);
		
		
	}
	
	@Test
	public void isConocidoCorrectoSiTest() {

		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[1];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		conocidos[0] = p2;  
		Persona p = new Persona(nombre, id, amigos, conocidos,3);

		

		assertTrue(p.isConocido(p2));
		
		
	}
	
	@Test
	public void isConocidoCorrectoNoTest() {
		fail("Quitar en implementación");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		
		
		assertFalse(p.isConocido(p2));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isConocidoPersonaNullTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		
		p.isConocido(null);
		
		
	}
	
	@Test
	public void addConocidoCorrectoTest() {
		fail("Quitar en implementacion");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.addConocido(p2);
		
		assertEquals(p2, p.getConocidos()[0]);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addConocidoPersonaNulaTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		
		p.addConocido(null);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addConocidoPersonaConocidaPreviamenteTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[1];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		conocidos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.addConocido(p2);	
	}
	
	
	@Test
	public void addAmigoCorrectoTest() {
		fail("Quitar en implementacion");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[1];

		
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		conocidos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.addAmigo(p2);
		
		assertEquals(p2, p.getAmigos()[0]);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addAmigoPersonaNulaTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[1];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		conocidos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.addAmigo(null);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addAmigoPersonaAmigaPreviamenteTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[1];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		conocidos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.addAmigo(p2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addAmigoPersonaNoEnConocidosTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.addAmigo(p2);	
	}

	@Test
	public void removeAmigoCorrectoTest() {
		fail("Quitar en implementacion");
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[1];
		Persona[] conocidos = new Persona[0];

		
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		amigos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.removeAmigo(p2);
		
		assertNotEquals(p2, p.getAmigos()[0]);
		
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void removeAmigoPersonaNulaTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[1];
		Persona[] conocidos = new Persona[0];

		
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		amigos[0] = p2;
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.removeAmigo(null);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void removeAmigoPersonaNoEnAmigosTest() {
		String nombre = "Antonio Román";
		int id = 12345678;
		Persona[] amigos = new Persona[0];
		Persona[] conocidos = new Persona[0];

		
		Persona p2 = new Persona("Manuel pino", 87654321, amigos, conocidos,3);
		Persona p = new Persona(nombre, id, amigos, conocidos,3);
		
		p.removeAmigo(p2);
		
	}
	
	

}
