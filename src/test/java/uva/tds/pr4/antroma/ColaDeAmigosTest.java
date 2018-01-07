package uva.tds.pr4.antroma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaDeAmigosTest {

	@Test
	public void ConstructorCorrectoTest() {
		Persona[] colaInicial = new Persona[5];
		
		ColaDeAmigos cola = new ColaDeAmigos(colaInicial);
	}

}
