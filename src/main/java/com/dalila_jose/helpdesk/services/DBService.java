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
		Tecnico tec1 = new Tecnico(null, "Maria Batista", "110.141.330-17", "maria@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Douglas Batista", "110.141.264-41", "douglas@mail.com", "123");
		Tecnico tec3 = new Tecnico(null, "Lucas Santos", "110.141.264-58", "lucas@mail.com", "123");
		

		Cliente cli1 = new Cliente(null, "Felipe Maia", "755.096.880-25", "felipe@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Jacinto Gomes", "755.092.356-98", "jacinto@mail.com", "123");
		Cliente cli3 = new Cliente(null, "Amanda Felipe", "793.092.356-71", "amanda@mail.com", "123");
		
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2,
				cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 03", "|Terceiro Chamado", tec3,
				cli3);
		
		
		

		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2, tec3));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
}
