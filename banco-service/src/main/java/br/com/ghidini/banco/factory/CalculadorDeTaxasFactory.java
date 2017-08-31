package br.com.ghidini.banco.factory;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ghidini.banco.controller.CalculadorDeTaxasController;
import br.com.ghidini.banco.controller.CalculoTaxaDController;
import br.com.ghidini.banco.model.TransacaoBancaria;

/**
 * @author raghidin
 *
 */
@Component
public class CalculadorDeTaxasFactory {
	@Autowired
	private CalculoTaxaDController calculoD;
	@Autowired
	private CalculadorDeTaxasController calculador;
	
	public BigDecimal calculadorDeTaxas(TransacaoBancaria transacaoBancaria){
		return calculador.realizaCalculo(transacaoBancaria, calculoD );
	}

}
