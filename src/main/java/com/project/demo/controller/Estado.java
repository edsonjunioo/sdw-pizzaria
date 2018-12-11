package com.project.demo.controller;

import com.project.demo.model.StatusBonus;

public abstract class Estado {

    Pedido pedido;

    public Estado(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void setEstadoBonus();


}
