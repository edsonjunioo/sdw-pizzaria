package com.project.demo.model;

import com.project.demo.controller.Cardapio;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CardapioRepositoryTest {

    @Autowired
    CardapioRepository cardapioRepository;

    @Test
    public void createCardapioTest(){
        Cardapio cardapio = new Cardapio("Teste1","Realizando Teste", 20f);
        this.cardapioRepository.save(cardapio);
        Assertions.assertThat(cardapio.getId()).isNotNull();
        Assertions.assertThat(cardapio.getDescricao()).isEqualTo("Realizando Teste");
        Assertions.assertThat(cardapio.getTitle()).isEqualTo("Teste1");
        Assertions.assertThat(cardapio.getPreco()).isEqualTo(20f);
    }


}
