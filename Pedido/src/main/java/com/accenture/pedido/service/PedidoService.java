

package com.accenture.pedido.service;

import com.accenture.pedido.model.Pedido;
import com.accenture.pedido.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoService() {
    }

    public Pedido save(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return this.pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return this.pedidoRepository.findById(id);
    }
}
