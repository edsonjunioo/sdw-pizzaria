package com.project.demo.view;


import com.project.demo.controller.Pedido;
import com.project.demo.controller.ResourceNotFoundException;
import com.project.demo.model.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public Pedido createPedido(@Valid @RequestBody Pedido note) {
        return pedidosRepository.save(note);
    }


    @GetMapping("/buscar/{id}")
    public Pedido getNoteById(@PathVariable(value = "id") Long noteId) {
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
