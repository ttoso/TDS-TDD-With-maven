package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest {

	@Test
	public void ConstructorCorrectoTest() {
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];
		
		Persona p = new Persona(amigos ,conocidos);
		
		assertArrayEquals(amigos, p.getAmigos());
		assertArrayEquals(conocidos, p.getConocidos());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void ConstructorAmigosNuloTest(){
		Persona[] conocidos = new Persona[3];
		
		Persona p = new Persona(null ,conocidos);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void ConstructorConocidosNuloTest(){
		Persona[] amigos = new Persona[3];
		
		Persona p = new Persona(amigos ,null);
	}
	
	@Test
	public void getAmigosCorrecto(){
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];
		
		Persona p = new Persona(amigos ,conocidos);
		
		assertArrayEquals(amigos, p.getAmigos());
	}
	
	@Test
	public void getConocidosCorrecto(){
		Persona[] conocidos = new Persona[3];
		Persona[] amigos = new Persona[3];
		
		Persona p = new Persona(amigos ,conocidos);
		
		assertArrayEquals(conocidos, p.getConocidos());
	}

}
