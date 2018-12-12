package com.project.demo.view;

import com.project.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("limpar/")
public class LimparBaseFacadeView {

    @Autowired
    PedidosRepository pedidosRepository;

    @Autowired
    CardapioRepository cardapioRepository;

    @Autowired
    PizzariaRepository pizzariaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    AdminRepository adminRepository;



    @PostMapping("base")
    public void cleanbase(){
        pedidosRepository.deleteAll();
        cardapioRepository.deleteAll();
        pizzariaRepository.deleteAll();
        adminRepository.deleteAll();
        clienteRepository.deleteAll();
    }


}