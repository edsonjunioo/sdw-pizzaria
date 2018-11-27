package com.project.demo.model;

import com.project.demo.controller.Pizzaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzariaRepository extends JpaRepository<Pizzaria,Long> {
}
