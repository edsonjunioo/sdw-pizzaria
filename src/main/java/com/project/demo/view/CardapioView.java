package com.project.demo.view;


import com.project.demo.controller.Cardapio;
import com.project.demo.controller.Pedido;
import com.project.demo.controller.Pizzaria;
import com.project.demo.controller.ResourceNotFoundException;
import com.project.demo.model.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cardapio/")
public class CardapioView {

    @Autowired
    CardapioRepository cardapioRepository;

    @GetMapping("buscar")
    public List<Cardapio> getAllCardapio() {
        return cardapioRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Cardapio createCardapio(@Valid @RequestBody Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    @PutMapping("/atualizar/{id}")
    public Cardapio updateCardapio(@PathVariable(value = "id") Long pizzariaId,
                                 @Valid @RequestBody Cardapio cardapioDetails) {

        Cardapio cardapio = cardapioRepository.findById(pizzariaId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pizzariaId));

        cardapio.setTitle(cardapioDetails.getTitle());
        cardapio.setDescricao(cardapioDetails.getDescricao());
        cardapio.setPreco(cardapio.getPreco());

        Cardapio updatedCardapio = cardapioRepository.save(cardapio);
        return updatedCardapio;
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deleteCardapio(@PathVariable(value = "id") Long cardapioId) {
        Cardapio cardapio = cardapioRepository.findById(cardapioId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", cardapioId));

        cardapioRepository.delete(cardapio);

        return ResponseEntity.ok().build();
    }
}
