package com.acc.consumo.service;

import com.acc.consumo.model.PedidoComProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PedidoProdutoService {

        @Autowired
        private WebClient webClientProdutos;

        @Autowired
        private WebClient webClientPedidos;

        public PedidoComProduto obterPedidoComProduto(Long idPedido){

            Mono<PedidoComProduto> monoProduto = this.webClientProdutos.method(HttpMethod.GET)
            .uri("/produto/{id}", idPedido )
            .retrieve()
            .bodyToMono(PedidoComProduto.class);

            Mono<PedidoComProduto> monoPedido = this.webClientPedidos
            .method(HttpMethod.GET)
            .uri("/pedido/{id}", idPedido)
            .retrieve()
            .bodyToMono(PedidoComProduto.class);


            PedidoComProduto pedido = monoPedido.block();
            PedidoComProduto produto =  monoProduto.block();

            produto.setHora(pedido.getHora());
            produto.setValorTotal(pedido.getValorTotal());

            return produto;
        }





}
