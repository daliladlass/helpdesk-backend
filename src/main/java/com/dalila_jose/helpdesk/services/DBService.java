package com.dalila_jose.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Maria Batista", "910.556.790-49", "maria@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Douglas Batista", "735.345.210-21", "douglas@mail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Lucas Santos", "839.015.230-49", "lucas@mail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "José Ricardo", "032.990.481-71", "jose@mail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Cinthia Santos", "548.795.620-09", "cinthia@mail.com", encoder.encode("123"));
		

		Cliente cli1 = new Cliente(null, "Felipe Maia", "076.220.800-71", "felipe@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Jacinto Gomes", "689.850.000-71", "jacinto@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Amanda Felipe", "845.563.800-14", "amanda@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Dalila Silva", "376.278.510-41", "dalila@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Cássio Elias Maia", "632.897.590-24", "cassio@mail.com", encoder.encode("123"));
		
		
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2,
				cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 03", "Terceiro Chamado", tec3,
				cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 04", "Quarto Chamado", tec4,
				cli4);
		
		
		

		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2, tec3, tec4, tec5));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
	}
}
