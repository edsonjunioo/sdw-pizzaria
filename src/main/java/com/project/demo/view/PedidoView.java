package com.project.demo.view;


import com.project.demo.controller.*;
import com.project.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoView {

    @Autowired
    PedidosRepository pedidosRepository;

    @Autowired
    CardapioRepository cardapioRepository;

    // Get All Notes
    @GetMapping("/buscar")
    public List<Pedido> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    // Create a new Note

    @PostMapping("/cadastrar")
    public Pedido createPedido(@Valid @RequestBody Pedido pedido){

        Float entrega = 10f;
        Float refrigerante = 8f;


        pedido.setStatusPedido(StatusPedido.SOLICITADO);
        pedido.setStatusPagamento(StatusPagamento.PENDENTE);
        pedido.setCreatedAt(LocalDateTime.now());
        pedido.setUpdatedAt(LocalDateTime.now());
        pedido.setTotal((cardapioRepository.findById(pedido.getIdCardapio()).get().getPreco() * pedido.getQuantidade()) + entrega);

        Estado estadoBonus0 = new EstadoBonus0(pedido);
        estadoBonus0.setEstadoBonus();

        if (cardapioRepository.findById(pedido.getIdCardapio()).get().getPreco() >= 20 && cardapioRepository.findById(pedido.getIdCardapio()).get().getPreco() < 50) {
            EstadoBonus1 estadoBonus1 = new EstadoBonus1(pedido);
            estadoBonus1.setEstadoBonus();
        }

        if (cardapioRepository.findById(pedido.getIdCardapio()).get().getPreco() >= 50) {
            EstadoBonus2 estadoBonus2 = new EstadoBonus2(pedido);
            estadoBonus2.setEstadoBonus();
            pedido.setTotal((cardapioRepository.findById(pedido.getIdCardapio()).get().getPreco() * pedido.getQuantidade()));
        }

        return pedidosRepository.save(pedido);

    }


    @GetMapping("/buscar/{id}")
    public Pedido getPedidoById(@PathVariable(value = "id") Long noteId) {
        return pedidosRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }


    @PutMapping("/atualizar/{id}")
    public Pedido updatePedido(@PathVariable(value = "id") Long pedidoId,
                               @Valid @RequestBody Pedido pedidoDetails) {

        Pedido pedido = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pedidoId));

        pedido.setIdCardapio(pedidoDetails.getIdCardapio());
        pedido.setQuantidade(pedidoDetails.getQuantidade());
        pedido.setUpdatedAt(LocalDateTime.now());

        Pedido updatedPedido = pedidosRepository.save(pedido);
        return updatedPedido;
    }


    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable(value = "id") Long pedidoId) {
        Pedido pedido = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pedidoId));

        pedidosRepository.delete(pedido);

        return ResponseEntity.ok().build();
    }


}
