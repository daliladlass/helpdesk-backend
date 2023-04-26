package com.dalila_jose.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalila_jose.helpdesk.domain.Chamado;
import com.dalila_jose.helpdesk.domain.Cliente;
import com.dalila_jose.helpdesk.domain.Tecnico;
import com.dalila_jose.helpdesk.domain.enums.Perfil;
import com.dalila_jose.helpdesk.domain.enums.Prioridade;
import com.dalila_jose.helpdesk.domain.enums.Status;
import com.dalila_jose.helpdesk.repositories.ChamadoRepository;
import com.dalila_jose.helpdesk.repositories.ClienteRepository;
import com.dalila_jose.helpdesk.repositories.TecnicoRepository;

@Service // é um servico que consegue criar instancia, injetar instancias do DB service em outras
			// partes do nosso codigo, o spring que faz todo gerenciamento de criação,
			// destruição...
public class DBService {

	@Autowired // Utiliza injeção de dependencia, aqui o spring fica responsável de criar,
				// gerenciar e destruir a instancia da interface ou classe no tempo correto
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Maria Batista", "11014133017", "maria@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Felipe Maia", "75509688025", "felipe@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);
		
		Tecnico tec2 = new Tecnico(null, "Douglas Batista", "11014126441", "douglas@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli2 = new Cliente(null, "Jacinto Gomes", "75509235698", "jacinto@mail.com", "123");

		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2,
				cli2);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		clienteRepository.saveAll(Arrays.asList(cli2));
		chamadoRepository.saveAll(Arrays.asList(c2));

	}
}
