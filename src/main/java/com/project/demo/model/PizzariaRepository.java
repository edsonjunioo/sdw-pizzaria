package com.project.demo.model;

import com.project.demo.controller.Pizzaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzariaRepository extends JpaRepository<Pizzaria,Long> {
}
