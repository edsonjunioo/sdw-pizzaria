package com.project.demo.model;

public enum StatusPagamento {
    PENDENTE("Seu pagamento está em análise"),
    NEGADO("seu pagamento foi negado"),
    CONFIRMADO("seu pagamento foi confirmado");

    private String status;

    StatusPagamento(String status) {
        this.status = status;
    }
}
