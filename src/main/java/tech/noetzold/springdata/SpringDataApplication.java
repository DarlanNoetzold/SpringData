package tech.noetzold.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.noetzold.springdata.orm.Cargo;
import tech.noetzold.springdata.repository.CargoRepository;
import tech.noetzold.springdata.repository.FuncionarioRepository;
import tech.noetzold.springdata.service.CrudCargoService;
import tech.noetzold.springdata.service.CrudFuncionarioService;
import tech.noetzold.springdata.service.CrudUnidadeTrabalhoService;
import tech.noetzold.springdata.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;
	
	private Boolean system = true; 
	
	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatoriosService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade de Trabalho");
			System.out.println("4 - Relatorios");
			
			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.inicial(scanner);
			}else if(action == 2){
				funcionarioService.inicial(scanner);
			}else if(action == 3){
				unidadeTrabalhoService.inicial(scanner);
			}else if(action == 4){
				relatoriosService.inicial(scanner);
			}else {
				system = false;
			}
		}
		
	}

}
