package br.com.ghidini.banco.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author raghidin
 *
 */
@Document
public class TransacaoBancaria {
	
	private int contaOrigem;
	private int contaDestino;
	private BigDecimal valorTransferencia;
	private BigDecimal taxa;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataAgendamento;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataTransferencia;
	
	public TransacaoBancaria(){}
	
	public TransacaoBancaria (int contaOrigem, int contaDestino, BigDecimal valorTransferencia, BigDecimal taxa, Date dataAgendamento, Date dataTransferencia){
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.taxa = taxa;
		this.dataAgendamento = dataAgendamento;
		this.dataTransferencia = dataTransferencia;
	}
	

	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public BigDecimal getTaxa() {
		return taxa;
	}
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Date getDataTransferencia() {
		return dataTransferencia;
	}
	public void setDataTransferencia(Date dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	public int getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(int contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public int getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	

}
