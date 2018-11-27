package com.project.demo.view;


import com.project.demo.controller.Pizzaria;
import com.project.demo.model.PizzariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("request/")
public class GeneralViel {

    @Autowired
    PizzariaRepository pizzariaRepository;

    @GetMapping("pizzaria")
    public String getName(){
        return "SDW Pizzaria";
    }

    @GetMapping("cardapio")
    public List<Pizzaria> getAllPizzarias() {
        return pizzariaRepository.findAll();
    }
}
