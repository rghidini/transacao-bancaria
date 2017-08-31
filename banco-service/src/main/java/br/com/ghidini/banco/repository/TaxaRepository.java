package br.com.ghidini.banco.repository;

import java.math.BigDecimal;

import br.com.ghidini.banco.model.TransacaoBancaria;

/**
 * @author raghidin
 *
 */
public interface TaxaRepository {
	
	BigDecimal calculoTaxa(TransacaoBancaria transacaoBancaria);

}
