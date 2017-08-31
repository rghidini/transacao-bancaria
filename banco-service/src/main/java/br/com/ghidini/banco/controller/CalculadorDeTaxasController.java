package br.com.ghidini.banco.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.ghidini.banco.model.TransacaoBancaria;
import br.com.ghidini.banco.repository.TaxaRepository;

/**
 * @author raghidin
 *
 */
@Component
public class CalculadorDeTaxasController {
	
	public BigDecimal realizaCalculo(TransacaoBancaria transacaoBancaria, TaxaRepository taxa){
		return taxa.calculoTaxa(transacaoBancaria);
	}
}
