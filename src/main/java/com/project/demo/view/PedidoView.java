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
@RequestMapping("/api")
public class PedidoView {

    @Autowired
    PedidosRepository pedidosRepository;

    // Get All Notes
    @GetMapping("/pedidos")
    public List<Pedido> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    // Create a new Note

    @PostMapping("/pedidos")
    public Pedido createPedido(@Valid @RequestBody Pedido note) {
        return pedidosRepository.save(note);
    }


    @GetMapping("/pedidos/{id}")
    public Pedido getNoteById(@PathVariable(value = "id") Long noteId) {
        return pedidosRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }


    @PutMapping("/pedidos/{id}")
    public Pedido updatePedido(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Pedido noteDetails) {

        Pedido note = pedidosRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setSabor(noteDetails.getSabor());
        note.setQuantidade(noteDetails.getQuantidade());

        Pedido updatedNote = pedidosRepository.save(note);
        return updatedNote;
    }


    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable(value = "id") Long noteId) {
        Pedido note = pedidosRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        pedidosRepository.delete(note);

        return ResponseEntity.ok().build();
    }


}
