package com.project.demo.controller;

import com.project.demo.model.StatusBonus;

public class EstadoBonus1 extends Estado {

    public EstadoBonus1(Pedido pedido) {
        super(pedido);
    }

    public void setEstadoBonus(){
        pedido.setBonus(StatusBonus.BONUS1);

    }
}
