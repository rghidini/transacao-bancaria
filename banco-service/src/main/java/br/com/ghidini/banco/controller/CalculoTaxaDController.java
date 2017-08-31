package br.com.ghidini.banco.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ghidini.banco.model.TransacaoBancaria;
import br.com.ghidini.banco.repository.TaxaRepository;

/**
 * @author raghidin
 *
 */
@Component
public class CalculoTaxaDController implements TaxaRepository{

	@Autowired
	private CalculoTaxaAController calculoA;
	@Autowired
	private CalculoTaxaBController calculoB;
	@Autowired
	private CalculoTaxaCController calculoC;

	@Override
	public BigDecimal calculoTaxa(TransacaoBancaria transacaoBancaria) {

		//veirifica se o valor é maior que zero e menor ou igual a mil
		if(transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(0)) == 1
				&& (transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(1000))== -1
				|| transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(1000))== 0)){

			return calculoA.calculoTaxa(transacaoBancaria);

			//verifica se o valor é maior que mil e menor ou igual a dois mil 
		}else if(transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(1000)) == 1
				&& (transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(2000))== -1
				|| transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(2000))== 0)){

			return calculoB.calculoTaxa(transacaoBancaria);

			//veirifica se o valor é maior que dois mil
		}else if(transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(2000)) == 1){

			return calculoC.calculoTaxa(transacaoBancaria);

		}else{
			return new BigDecimal("0");
		}

	}

}
