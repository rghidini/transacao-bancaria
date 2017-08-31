package br.com.ghidini.banco.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.ghidini.banco.model.TransacaoBancaria;
import br.com.ghidini.banco.repository.TaxaRepository;
import br.com.ghidini.banco.utils.DateUtils;

/**
 * @author raghidin
 *
 */
@Component
public class CalculoTaxaAController implements TaxaRepository {

	@Override
	public BigDecimal calculoTaxa(TransacaoBancaria transacaoBancaria) {
		if(DateUtils.dateEquals(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia())){
			return ((transacaoBancaria.getValorTransferencia().multiply(new BigDecimal("0.03"))).add(new BigDecimal("3"))); 
		}else{
			return new BigDecimal("0");
		}
	}	
}
