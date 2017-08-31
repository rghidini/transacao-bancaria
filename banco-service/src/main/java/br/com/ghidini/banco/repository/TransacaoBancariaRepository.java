package br.com.ghidini.banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ghidini.banco.model.TransacaoBancaria;

/**
 * @author raghidin
 *
 */
public interface TransacaoBancariaRepository extends MongoRepository<TransacaoBancaria, String>{

}
