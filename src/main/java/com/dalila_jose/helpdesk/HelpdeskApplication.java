package com.dalila_jose.helpdesk;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dalila_jose.helpdesk.domain.Chamado;
import com.dalila_jose.helpdesk.domain.Cliente;
import com.dalila_jose.helpdesk.domain.Tecnico;
import com.dalila_jose.helpdesk.domain.enums.Perfil;
import com.dalila_jose.helpdesk.domain.enums.Prioridade;
import com.dalila_jose.helpdesk.domain.enums.Status;
import com.dalila_jose.helpdesk.repositories.ChamadoRepository;
import com.dalila_jose.helpdesk.repositories.ClienteRepository;
import com.dalila_jose.helpdesk.repositories.TecnicoRepository;


@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired //Utiliza injeção de dependencia, aqui o spring fica responsável de criar, gerenciar e destruir a instancia da interface ou classe no tempo correto 
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {//Criação de instâncias de teste
		
		Tecnico tec1 = new Tecnico(null, "Dalila Silva", "11014133017", "dalila@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Hietor Maia", "75509688025", "heitor@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}
	

}
