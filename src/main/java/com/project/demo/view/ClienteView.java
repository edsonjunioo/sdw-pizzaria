package com.project.demo.view;


import com.project.demo.controller.Admin;
import com.project.demo.controller.Cliente;
import com.project.demo.controller.Pedido;
import com.project.demo.controller.ResourceNotFoundException;
import com.project.demo.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cliente/")
public class ClienteView {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("buscar")
    public List<Cliente> getAllAdmin() {
        return clienteRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Cliente createAdmin(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/buscar/{id}")
    public Cliente getPedidoById(@PathVariable(value = "id") Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", clienteRepository));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", clienteRepository));

        clienteRepository.delete(cliente);

        return ResponseEntity.ok().build();
    }
}
