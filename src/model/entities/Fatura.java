package model.entities;

public class Fatura {
	
	private Double pagamentoBase;
	private Double imposto;
	
	public Fatura() {
	}

	public Fatura(Double pagamentoBase, Double imposto) {
		this.pagamentoBase = pagamentoBase;
		this.imposto = imposto;
	}

	public Double getPagamentoBase() {
		return pagamentoBase;
	}

	public void setPagamentoBase(Double pagamentoBase) {
		this.pagamentoBase = pagamentoBase;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	public Double getPagamentoTotal() {
		return getPagamentoBase() + getImposto();
	}

}
