package com.project.demo.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AdminTest {

    @Test
    public void admincreateTest(){
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setCnpj("123");
        admin.setEmail("email");
        admin.setNome("Name");
        admin.setSenha("123");
        admin.setNome_estabelecimento("teste");
        Assertions.assertThat(admin.getId()).isNotNull();
        Assertions.assertThat(admin.getEmail()).isEqualTo("email");
    }
}
