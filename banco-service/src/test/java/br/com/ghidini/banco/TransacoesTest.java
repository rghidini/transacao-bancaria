package br.com.ghidini.banco;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ghidini.banco.model.TransacaoBancaria;
import br.com.ghidini.banco.utils.DateUtils;

/**
 * @author raghidin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = BancoApplication.class)
public class TransacoesTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;

	private String URL = "http://localhost:3004/transacoes";
	private String URL_CADASTRO = "http://localhost:3004/cadastro-transacoes";
	private String URL_CALCULO_TAXA = "http://localhost:3004/taxa";

	@Test
	public void teste_lista_todas_transacoes() throws JsonParseException, JsonMappingException, IOException {		
		String response = restTemplate.getForObject(URL, String.class);
		List<TransacaoBancaria> transacoes = mapper.readValue(response, 
				mapper.getTypeFactory().constructCollectionType(List.class, TransacaoBancaria.class));
		Assert.assertNotNull(transacoes);
	}
	
	@Test
	public void teste_inserir_transacao_taxa_A() {
		TransacaoBancaria transacaoBancaria = gerarTransacao();
		transacaoBancaria.setDataTransferencia(new Date());
		transacaoBancaria.setValorTransferencia(new BigDecimal("1000"));
		TransacaoBancaria taxa = restTemplate.postForObject(URL_CALCULO_TAXA, transacaoBancaria, TransacaoBancaria.class);
		transacaoBancaria.setTaxa(taxa.getTaxa());
		TransacaoBancaria response = restTemplate.postForObject(URL_CADASTRO, transacaoBancaria, TransacaoBancaria.class);
		Assert.assertTrue(transacaoBancaria.getContaDestino() == response.getContaDestino());
	}
	
	@Test
	public void teste_inserir_transacao_taxa_B() {
		TransacaoBancaria transacaoBancaria = gerarTransacao();
		transacaoBancaria.setDataTransferencia(DateUtils.addDays(transacaoBancaria.getDataAgendamento(), 8));
		transacaoBancaria.setValorTransferencia(new BigDecimal("1100"));
		TransacaoBancaria taxa = restTemplate.postForObject(URL_CALCULO_TAXA, transacaoBancaria, TransacaoBancaria.class);
		transacaoBancaria.setTaxa(taxa.getTaxa());
		TransacaoBancaria response = restTemplate.postForObject(URL_CADASTRO, transacaoBancaria, TransacaoBancaria.class);
		Assert.assertTrue(transacaoBancaria.getContaDestino() == response.getContaDestino());
	}
	
	@Test
	public void teste_inserir_transacao_taxa_C_10() {
		TransacaoBancaria transacaoBancaria = gerarTransacao();
		transacaoBancaria.setDataTransferencia(DateUtils.addDays(transacaoBancaria.getDataAgendamento(), 12));
		transacaoBancaria.setValorTransferencia(new BigDecimal("2100"));
		TransacaoBancaria taxa = restTemplate.postForObject(URL_CALCULO_TAXA, transacaoBancaria, TransacaoBancaria.class);
		transacaoBancaria.setTaxa(taxa.getTaxa());
		TransacaoBancaria response = restTemplate.postForObject(URL_CADASTRO, transacaoBancaria, TransacaoBancaria.class);
		Assert.assertTrue(transacaoBancaria.getContaDestino() == response.getContaDestino());
	}
	
	@Test
	public void teste_inserir_transacao_taxa_C_20() {
		TransacaoBancaria transacaoBancaria = gerarTransacao();
		transacaoBancaria.setDataTransferencia(DateUtils.addDays(new Date(), 22));
		transacaoBancaria.setValorTransferencia(new BigDecimal("2100"));
		TransacaoBancaria taxa = restTemplate.postForObject(URL_CALCULO_TAXA, transacaoBancaria, TransacaoBancaria.class);
		transacaoBancaria.setTaxa(taxa.getTaxa());
		TransacaoBancaria response = restTemplate.postForObject(URL_CADASTRO, transacaoBancaria, TransacaoBancaria.class);
		Assert.assertTrue(transacaoBancaria.getContaDestino() == response.getContaDestino());
	}
	
	@Test
	public void teste_inserir_transacao_taxa_C_30() {
		TransacaoBancaria transacaoBancaria = gerarTransacao();
		transacaoBancaria.setDataTransferencia(DateUtils.addDays(transacaoBancaria.getDataAgendamento(), 32));
		transacaoBancaria.setValorTransferencia(new BigDecimal("2100"));
		TransacaoBancaria taxa = restTemplate.postForObject(URL_CALCULO_TAXA, transacaoBancaria, TransacaoBancaria.class);
		transacaoBancaria.setTaxa(taxa.getTaxa());
		TransacaoBancaria response = restTemplate.postForObject(URL_CADASTRO, transacaoBancaria, TransacaoBancaria.class);
		Assert.assertTrue(transacaoBancaria.getContaDestino() == response.getContaDestino());
	}
	
	@Test
	public void teste_inserir_transacao_taxa_C_40() {
		TransacaoBancaria transacaoBancaria = gerarTransacao();
		transacaoBancaria.setDataTransferencia(DateUtils.addDays(transacaoBancaria.getDataAgendamento(), 42));
		transacaoBancaria.setValorTransferencia(new BigDecimal("2100"));
		TransacaoBancaria taxa = restTemplate.postForObject(URL_CALCULO_TAXA, transacaoBancaria, TransacaoBancaria.class);
		transacaoBancaria.setTaxa(taxa.getTaxa());
		TransacaoBancaria response = restTemplate.postForObject(URL_CADASTRO, transacaoBancaria, TransacaoBancaria.class);
		Assert.assertTrue(transacaoBancaria.getContaDestino() == response.getContaDestino());
	}
	
	@Test
	public void teste_nao_existem_taxas_aplicaveis() {
		TransacaoBancaria transacaoBancaria = gerarTransacao();
		transacaoBancaria.setDataTransferencia(new Date());
		transacaoBancaria.setValorTransferencia(new BigDecimal("2100"));
		TransacaoBancaria taxa = restTemplate.postForObject(URL_CALCULO_TAXA, transacaoBancaria, TransacaoBancaria.class);
		transacaoBancaria.setTaxa(taxa.getTaxa());
		TransacaoBancaria response = restTemplate.postForObject(URL_CADASTRO, transacaoBancaria, TransacaoBancaria.class);
		Assert.assertTrue(transacaoBancaria.getContaDestino() == response.getContaDestino());
	}
	
	private TransacaoBancaria gerarTransacao() {
		TransacaoBancaria transacaoBancaria= new TransacaoBancaria();
		transacaoBancaria.setContaDestino(123456);
		transacaoBancaria.setContaOrigem(987654);
		transacaoBancaria.setDataAgendamento(new Date());
		return transacaoBancaria;
	}
}