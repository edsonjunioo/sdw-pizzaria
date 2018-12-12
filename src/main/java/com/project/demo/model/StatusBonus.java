package com.project.demo.model;

public enum StatusBonus {
    BONUS0("sem bonus"),
    BONUS1("refrigerante gratis"),
    BONUS2("refrigerante e entrega gratis");

    private String status;

    StatusBonus(String status) {
        this.status = status;
    }

}
