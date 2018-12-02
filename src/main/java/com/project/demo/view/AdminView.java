package com.project.demo.view;


import com.project.demo.controller.Admin;
import com.project.demo.controller.ResourceNotFoundException;
import com.project.demo.model.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin/")
public class AdminView {

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("buscar")
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deleteAdimin(@PathVariable(value = "id") Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", adminId));

        adminRepository.delete(admin);

        return ResponseEntity.ok().build();
    }
}
