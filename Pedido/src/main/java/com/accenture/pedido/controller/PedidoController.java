

package com.accenture.pedido.controller;

import com.accenture.pedido.model.Pedido;
import com.accenture.pedido.service.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pedido"})
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    public PedidoController() {
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return this.pedidoService.findAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Pedido> getPedidoById(@PathVariable Long id) {
        return this.pedidoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidoService.save(pedido));
    }
}
