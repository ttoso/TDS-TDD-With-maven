package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaDeAmigosTest {

	@Test
	public void ConstructorCorrectoTest() {
		Persona[] colaInicial = new Persona[5];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		
		assertArrayEquals(colaInicial, cola.getColaActual());
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorColaInicialNulaTest() {
		Persona[] colaInicial = new Persona[5];

		ColaDeAmigos cola = new ColaDeAmigos(null);
	}
	
	
	@Test
	public void getColaActualCorrectoTest() {
		Persona[] colaInicial = new Persona[5];

		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
		
		assertArrayEquals(colaInicial, cola.getColaActual());
	}

}
