package com.project.demo.view;


import com.project.demo.controller.Pedido;
import com.project.demo.controller.ResourceNotFoundException;
import com.project.demo.model.PedidosRepository;
import com.project.demo.model.StatusPagamento;
import com.project.demo.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TemporalType;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoView {

    @Autowired
    PedidosRepository pedidosRepository;

    // Get All Notes
    @GetMapping("/buscar")
    public List<Pedido> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    // Create a new Note

    @PostMapping("/cadastrar")
    public Pedido createPedido(@Valid @RequestBody Pedido pedido) {
        pedido.setStatusPedido(StatusPedido.SOLICITADO);
        pedido.setStatusPagamento(StatusPagamento.PENDENTE);
        pedido.setCreatedAt(LocalDateTime.now());
        pedido.setUpdatedAt(LocalDateTime.now());
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
