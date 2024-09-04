package model.services;

import java.time.Duration;

import model.entities.AlguelVeiculo;
import model.entities.Fatura;

public class AluguelService {
	
	private Double precoHora;
	private Double precoDia;
	
	private ImpostoService impostoCalculado;

	public AluguelService(Double precoHora, Double precoDia, ImpostoBrasilService impostoBrasilCalculado) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.impostoCalculado = impostoBrasilCalculado;
	}
	
	public void processarFatura(AlguelVeiculo alguelVeiculo) {
		double minutes = Duration.between(alguelVeiculo.getRetirada(), alguelVeiculo.getDevolucao()).toMinutes();
		double hours = minutes/60;
		
		double pagamentoBase;
		
		if(hours <= 12) {
			pagamentoBase = precoHora * Math.ceil(hours); //Math.ceil FAZ O ARREDONDAMENTO PARA CIMA
		} else {
			pagamentoBase = precoDia * Math.ceil(hours/24);
		}
		
		double imposto = impostoCalculado.imposto(pagamentoBase);
		
		alguelVeiculo.setFatura(new Fatura(pagamentoBase, imposto));
		
	}
	

}
