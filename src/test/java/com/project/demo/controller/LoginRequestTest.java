package com.project.demo.controller;

import com.project.demo.controller.Login;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoginRequestTest {

    @Test
    public void loginRequestTest(){
        Login login = new Login();
        login.setEmail("teste");
        login.setSenha("1234");
        Assertions.assertThat(login.getEmail()).isEqualTo("teste");
        Assertions.assertThat(login.getSenha()).isEqualTo("1234");
    }
}
