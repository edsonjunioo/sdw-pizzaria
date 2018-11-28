package com.project.demo.view;


import com.project.demo.controller.Pedido;
import com.project.demo.controller.Pizzaria;
import com.project.demo.controller.ResourceNotFoundException;
import com.project.demo.model.PizzariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pizzaria/")
public class GeneralView {

    @Autowired
    PizzariaRepository pizzariaRepository;

    @GetMapping("buscar")
    public List<Pizzaria> getAllPizzarias() {
        return pizzariaRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Pizzaria createPizzaria(@Valid @RequestBody Pizzaria pizzaria) {
        return pizzariaRepository.save(pizzaria);
    }

    @PutMapping("/atualizar/{id}")
    public Pizzaria updatePedido(@PathVariable(value = "id") Long pizzariaId,
                               @Valid @RequestBody Pizzaria pizzariaDetails) {

        Pizzaria pizzaria = pizzariaRepository.findById(pizzariaId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pizzariaId));

        pizzaria.setTitle(pizzariaDetails.getTitle());
        pizzaria.setDescricao(pizzariaDetails.getDescricao());

        Pizzaria updatedPizzaria = pizzariaRepository.save(pizzaria);
        return updatedPizzaria;
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable(value = "id") Long pizzariaId) {
        Pizzaria pizzaria = pizzariaRepository.findById(pizzariaId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pizzariaId));

        pizzariaRepository.delete(pizzaria);

        return ResponseEntity.ok().build();
    }
}
