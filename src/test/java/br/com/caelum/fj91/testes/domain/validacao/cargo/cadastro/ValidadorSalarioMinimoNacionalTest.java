package br.com.caelum.fj91.testes.domain.validacao.cargo.cadastro;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.fj91.testes.builders.CargoBuilder;
import br.com.caelum.fj91.testes.domain.Cargo;
import br.com.caelum.fj91.testes.exceptions.BusinessException;

public class ValidadorSalarioMinimoNacionalTest {

	private ValidadorSalarioMinimoNacional validador;
	private CargoBuilder builder;
	
	@Before
	public void setup() {
		validador = new ValidadorSalarioMinimoNacional();
		this.builder = new CargoBuilder();
	}
	
	@Test(expected = BusinessException.class)
	public void salarioMinimoNaoPodeSerMenorDoQueSalarioMinimoNacional() {
		Cargo gerente = builder.comSalarioMinimo(new BigDecimal("900.00")).build();
		validador.valida(gerente);
	}

	@Test
	public void salarioMinimoPodeSerIgualAoSalarioMinimoNacional() {
		Cargo gerente = builder.comSalarioMinimo(new BigDecimal("954.00")).build();
		validador.valida(gerente);
	}
	
	@Test
	public void salarioMinimoPodeSerMaiorDoQueSalarioMinimoNacional() {
		Cargo gerente = builder.comSalarioMinimo(new BigDecimal("1000.00")).build();
		validador.valida(gerente);
	}

}
