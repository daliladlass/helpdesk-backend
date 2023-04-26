package com.dalila_jose.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalila_jose.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
