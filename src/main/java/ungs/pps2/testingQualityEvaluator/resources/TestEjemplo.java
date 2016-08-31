package ungs.pps2.testingQualityEvaluator.resources;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestEjemplo {
	@Test
	public void test() {
		int dato=Ejemplo.sumaTresYCincoDosVeces();
		assertTrue(dato==8);
	}
	public void multiplicaDosNumeros() {
		Ejemplo ejemplo=new Ejemplo();
		int dato=ejemplo.multiplicaDosNumero(3, 2);
		assertTrue(dato==6);
		dato=ejemplo.multiplicaDosNumero(2, 9);
		assertTrue(dato==18);
	}
}
