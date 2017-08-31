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
public class CalculoTaxaCController implements TaxaRepository {

	@Override
	public BigDecimal calculoTaxa(TransacaoBancaria transacaoBancaria) {
		//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 10 e menor que 20 dias
		if(DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) > 10
				&& DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) <= 20){
			return transacaoBancaria.getValorTransferencia().multiply(new BigDecimal("0.082"));
		
			//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 20 e menor que 30 dias
		}else if(DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) > 20
				&& DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) <= 30){
			return transacaoBancaria.getValorTransferencia().multiply(new BigDecimal("0.069"));
		
			//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 30 e menor que 40 dias
		}else if(DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) > 30
				&& DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) <= 40){
			return transacaoBancaria.getValorTransferencia().multiply(new BigDecimal("0.047"));
			
			//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 40 dias
		}else if(DateUtils.differenceInDays(transacaoBancaria.getDataAgendamento(),transacaoBancaria.getDataTransferencia()) > 40){
			return transacaoBancaria.getValorTransferencia().multiply(new BigDecimal("0.017"));
		}else{
			return new BigDecimal("0");
		}
	}

}
