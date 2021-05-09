package tech.noetzold.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import tech.noetzold.springdata.orm.Funcionario;
import tech.noetzold.springdata.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de cargo voce deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca Funcionario Nome");
			System.out.println("2 - Busca Funcionario Nome, Salario Maior e Data");
			int action = scanner.nextInt();
			switch (action) {
				case 1:
					buscaFuncionarioNome(scanner);
					break;
				case 2:
					buscaFuncionarioNomeSalarioMaiorData(scanner);
					break;
				default:
					system = false;
					break;
			}
		}
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome: ");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual o nome: ");
		String nome = scanner.next();
		
		System.out.println("Qual a data: ");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);

		System.out.println("Qual o salario maior: ");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		list.forEach(System.out::println);
	}
}
