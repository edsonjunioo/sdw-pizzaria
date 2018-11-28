package com.project.demo.view;


import com.project.demo.controller.Cardapio;
import com.project.demo.controller.Pizzaria;
import com.project.demo.model.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cardapio/")
public class CardapioView {

    @Autowired
    CardapioRepository cardapioRepository;

    @GetMapping("buscar")
    public List<Cardapio> getAllPizzarias() {
        return cardapioRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Cardapio createPizzaria(@Valid @RequestBody Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }
}
