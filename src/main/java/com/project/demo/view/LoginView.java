package com.project.demo.view;


import com.project.demo.controller.Cliente;
import com.project.demo.controller.Login;
import com.project.demo.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("login/")
public class LoginView {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("cliente")
    public ResponseEntity<?> createAdmin(@Valid @RequestBody Login login) {

        Cliente cliente = clienteRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());

        if (cliente.getEmail().isEmpty() || cliente.getSenha().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(cliente);
    }
}
