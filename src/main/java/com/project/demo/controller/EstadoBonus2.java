package com.project.demo.controller;

import com.project.demo.model.StatusBonus;

public class EstadoBonus2 extends Estado {

    public EstadoBonus2(Pedido pedido) {
        super(pedido);
    }

    public void setEstadoBonus(){
        pedido.setBonus(StatusBonus.BONUS2);
    }
}
