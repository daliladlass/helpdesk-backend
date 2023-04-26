package com.dalila_jose.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalila_jose.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
