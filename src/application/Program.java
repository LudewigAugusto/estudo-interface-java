package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AlguelVeiculo;
import model.entities.Veiculo;
import model.services.AluguelService;
import model.services.ImpostoBrasilService;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		// INFORMANDO DADOS PARA A LOCAÇÃO DO VEÍCULO
		System.out.println("Entre com os dados do carro:");
		System.out.print("Modelo do carro: ");
		String modelo = sc.nextLine();
		try {
			System.out.print("Retirtada (dd/MM/yyyy hh:mm): ");
			LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), dtf);
			System.out.print("Devolução (dd/MM/yyyy hh:mm): ");
			LocalDateTime devolucao = LocalDateTime.parse(sc.nextLine(), dtf);
		
		// INSTANCIANDO O ALUGUEL
		AlguelVeiculo locacao = new AlguelVeiculo(new Veiculo(modelo), retirada, devolucao);		

		// INFORMANDO DADOS PARA GERAR A FATURA
		System.out.print("Entre com o preço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double precoDia = sc.nextDouble();
		
		AluguelService aluguelService = new AluguelService(precoHora, precoDia, new ImpostoBrasilService());
		
		aluguelService.processarFatura(locacao);
		
		System.out.println("\nFATURA:");
		System.out.println("Pagamento base: " + String.format("R$ %.2f",locacao.getFatura().getPagamentoBase()));
		System.out.println("Imposto: " + String.format("R$ %.2f", locacao.getFatura().getImposto()) );
		System.out.println("Pagamento Total: " + String.format("R$ %.2f",locacao.getFatura().getPagamentoTotal()));
		
		} catch (Exception e) {
			System.out.println("Valor inválido: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
