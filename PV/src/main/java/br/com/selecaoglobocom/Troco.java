package br.com.selecaoglobocom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;

public class Troco {
	private static final String SAIR = "sair";

	public static void main(String[] args) {
		SpringApplication.run(Troco.class, args);
		BufferedReader bufferReader = null;
		try {
			while (true) {
				showMenu();
				bufferReader = new BufferedReader(new InputStreamReader(System.in));
				String menu = bufferReader.readLine();
				if (StringUtils.isNumeric(menu.trim())) {
					switch (menu) {
					case ("1"):
						calculadora(bufferReader);
						break;
					case ("2"):
						System.out.println("Até logo!");
						System.exit(0);
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
				} else {
					System.out.println("Opção inválida.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferReader != null) {
				try {
					bufferReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void calculadora(BufferedReader bufferReader) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		while (BigDecimal.ZERO.compareTo(valorTotal) == 0) {
			valorTotal = solicitaValor(bufferReader, "valor total");
			if (valorTotal == null) {
				return;
			}
		}

		BigDecimal valorPago = BigDecimal.ZERO;
		while (BigDecimal.ZERO.compareTo(valorPago) == 0) {
			valorPago = solicitaValor(bufferReader, "valor pago");
			if (valorPago == null) {
				return;
			}
		}

		BigDecimal troco = BigDecimal.ZERO;
		if (valorTotal.compareTo(valorPago) <= 0) {
			troco = valorPago.subtract(valorTotal);
			System.out.println("O valor do troco é: R$" + (valorPago.subtract(valorTotal)));
		} else {
			System.out.println("Valor pago é menor que valor total");
		}

		distribuirTroco(troco);
	}

	public static void distribuirTroco(BigDecimal troco) {

		int[] notas = { 100, 50, 20, 10, 5, 2 };

		for (int nota : notas) {
			troco = verificaValor(troco, BigDecimal.valueOf(nota), " x R$ " + nota + ",00");
			if (troco.compareTo(BigDecimal.ZERO) == 0) {
				return;
			}
		}

		String[] moedas = { "100", "50", "25", "10", "05" };

		for (String moeda : moedas) {
			troco = verificaValor(troco, BigDecimal.valueOf(Double.parseDouble(moeda) / 100D), " x R$ 0," + moeda);
			if (troco.compareTo(BigDecimal.ZERO) == 0) {
				return;
			}
		}
	}

	public static BigDecimal verificaValor(BigDecimal troco, BigDecimal valor, String mensagem) {
		BigDecimal trocoValor = troco.divide(valor);
		if (trocoValor.compareTo(BigDecimal.ONE) >= 0) {
			troco = troco.subtract(valor.multiply(BigDecimal.valueOf(trocoValor.intValue())));
			System.out.println(trocoValor.intValue() + mensagem);
		}
		return troco;
	}

	public static BigDecimal solicitaValor(BufferedReader bufferReader, String tipoValor) {
		System.out.println("Digite \"sair\" para sair da calculadora.");
		System.out.println("Informe o " + tipoValor + ", conforme exemplo (R$ 40,10):");
		String input = null;
		try {
			input = bufferReader.readLine();
			if (SAIR.equals(input)) {
				return null;
			}
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			Number number = numberFormat.parse(input);
			return BigDecimal.valueOf(number.doubleValue());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			return BigDecimal.ZERO;
		}
	}

	private static void showMenu() {
		System.out.println("Menu:");
		System.out.println("Digite \"1\" para novo cálculo.");
		System.out.println("Digite \"2\" para sair.");
	}
}
