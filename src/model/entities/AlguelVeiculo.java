package model.entities;

import java.time.LocalDateTime;

public class AlguelVeiculo {
	
	private LocalDateTime retirada;
	private LocalDateTime devolucao;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public AlguelVeiculo() {
	}

	public AlguelVeiculo(Veiculo veiculo, LocalDateTime retirada, LocalDateTime devolucao) {
		this.veiculo = veiculo;
		this.retirada = retirada;
		this.devolucao = devolucao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getRetirada() {
		return retirada;
	}

	public void setRetirada(LocalDateTime retirada) {
		this.retirada = retirada;
	}

	public LocalDateTime getDevolucao() {
		return devolucao;
	}

	public Fatura getFatura() {
		return fatura;
	}
	
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public void setDevolucao(LocalDateTime devolucao) {
		this.devolucao = devolucao;
	}
	
	
	
	
}
