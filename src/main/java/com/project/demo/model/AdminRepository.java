package com.project.demo.model;

import com.project.demo.controller.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmailAndSenha(String email, String senha);
}
