package br.com.ghidini.banco.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghidini.banco.factory.CalculadorDeTaxasFactory;
import br.com.ghidini.banco.model.TransacaoBancaria;
import br.com.ghidini.banco.repository.TransacaoBancariaRepository;

/**
 * @author raghidin
 *
 */
@RestController
public class TransacaoBancariaController {

	@Autowired
	private TransacaoBancariaRepository transacaoBancariaRepository;
	@Autowired
	CalculadorDeTaxasFactory calculador;

	@CrossOrigin
	@GetMapping("/transacoes")
	public List<TransacaoBancaria> listAll(){
		return transacaoBancariaRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/delete")
	public void delete(){
		transacaoBancariaRepository.deleteAll();
	}

	@CrossOrigin
	@PostMapping("/cadastro-transacoes")
	public TransacaoBancaria insert(@RequestBody TransacaoBancaria transacaoBancaria){
		return transacaoBancariaRepository.insert(transacaoBancaria);
	}

	@CrossOrigin
	@PostMapping("/taxa")
	public TransacaoBancaria calcularTaxa(@RequestBody TransacaoBancaria transacaoBancaria){
		BigDecimal taxa = calculador.calculadorDeTaxas(transacaoBancaria);
		transacaoBancaria.setTaxa(taxa);
		return transacaoBancaria;
	}

}
