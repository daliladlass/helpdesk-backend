package com.dalila_jose.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalila_jose.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
