package com.project.demo.model;

public enum StatusPedido {
    SOLICITADO("pedido solicitado, aquardando confirmação do pagamento"),
    ANDAMENTO("pagamento confirmado, pedido em andamento"),
    ENTREGA("pedido a caminho do endereço de entrega"),
    CONCLUIDO("pedido entregue");


    private String status;

    StatusPedido(String status) {
        this.status = status;
    }
}
