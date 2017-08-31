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
public class CalculoTaxaBController implements TaxaRepository{

	@Override
	public BigDecimal calculoTaxa(TransacaoBancaria transacaoBancaria) {
		if(DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) > 0
				&& DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) <= 10){
			return new BigDecimal("12");			
		}else{
			return new BigDecimal("0");
		}
	}
}
