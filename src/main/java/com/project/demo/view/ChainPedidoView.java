package com.project.demo.view;

import com.project.demo.controller.Pedido;
import com.project.demo.controller.ResourceNotFoundException;
import com.project.demo.model.PedidosRepository;
import com.project.demo.model.StatusPagamento;
import com.project.demo.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fluxo/")
public class ChainPedidoView {

    @Autowired
    PedidosRepository pedidosRepository;

    @PostMapping("start/{id}")
    public Pedido start(@PathVariable(value = "id") Long pedidoId){

        Pedido pedido = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pedidoId));

        pedido.setStatusPedido(StatusPedido.ANDAMENTO);
        pedido.setStatusPagamento(StatusPagamento.CONFIRMADO);

        return pedidosRepository.save(pedido);
    }


    @PostMapping("andamento/completo/{id}")
    public Pedido andamentoCompleto(@PathVariable(value = "id") Long pedidoId){

        Pedido pedido = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pedidoId));

        pedido.setStatusPedido(StatusPedido.ENTREGA);

        return pedidosRepository.save(pedido);

    }

    @PostMapping("entrega/completo/{id}")
    public Pedido entregaCompleto(@PathVariable(value = "id") Long pedidoId){

        Pedido pedido = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", pedidoId));

        pedido.setStatusPedido(StatusPedido.CONCLUIDO);

        return pedidosRepository.save(pedido);

    }

}
