package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest {

	@Test
	public void ConstructorCorrectoTest() {
		Persona[] amigos = new Persona[3];
		Persona[] conocidos = new Persona[3];
		
		Persona p = new Persona(amigos , conocidos);
	}

}
