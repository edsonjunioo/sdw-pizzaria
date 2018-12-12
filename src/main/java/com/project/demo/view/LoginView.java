package com.project.demo.view;


import com.project.demo.controller.*;
import com.project.demo.model.AdminRepository;
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

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("cliente")
    public ResponseEntity<?> loginCliente(@Valid @RequestBody Login login) {

        Cliente cliente = clienteRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());

        if (cliente.getEmail().isEmpty() || cliente.getSenha().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("admin")
    public ResponseEntity<?> loginAdmin(@Valid @RequestBody Login login) {

        Admin admin = adminRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());

        if (admin.getEmail().isEmpty() || admin.getSenha().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(admin);
    }



}
