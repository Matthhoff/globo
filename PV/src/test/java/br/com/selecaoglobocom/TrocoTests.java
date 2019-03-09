package br.com.selecaoglobocom;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrocoTests {

	@Test
	public void testVerificaValor5Reais() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		BigDecimal troco = Troco.verificaValor(BigDecimal.valueOf(10.22), BigDecimal.valueOf(5), " x R$ 5,00");
		assertEquals(BigDecimal.valueOf(0.22), troco);
		assertEquals("2 x R$ 5,00", outContent.toString().trim());
	}

	@Test
	public void testVerificaValo10Reais() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		BigDecimal troco = Troco.verificaValor(BigDecimal.valueOf(30.22), BigDecimal.valueOf(10), " x R$ 10,00");
		assertEquals(BigDecimal.valueOf(0.22), troco);
		assertEquals("3 x R$ 10,00", outContent.toString().trim());
	}

	@Test
	public void testVerificaValor5Centavos() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		BigDecimal troco = Troco.verificaValor(BigDecimal.valueOf(0.19),
				BigDecimal.valueOf(Double.parseDouble("05") / 100D), " x R$ 0,05");
		assertEquals(BigDecimal.valueOf(0.04), troco);
		assertEquals("3 x R$ 0,05", outContent.toString().trim());
	}

}
