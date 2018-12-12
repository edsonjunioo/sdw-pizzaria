package com.project.demo.controller;

import com.project.demo.model.StatusBonus;

public class EstadoBonus0 extends Estado {

    public EstadoBonus0(Pedido pedido) {
        super(pedido);
    }

    public void setEstadoBonus(){
        pedido.setBonus(StatusBonus.BONUS0);
    }
}