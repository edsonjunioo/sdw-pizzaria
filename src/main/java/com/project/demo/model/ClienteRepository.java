package com.project.demo.model;

import com.project.demo.controller.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);

    Cliente findBySenha(String senha);

    Cliente findByEmailAndSenha(String email, String senha);

}
