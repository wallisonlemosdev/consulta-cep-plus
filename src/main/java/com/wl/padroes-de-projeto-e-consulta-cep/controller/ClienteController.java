package com.wl.padroes_de_projeto_spring.controller;

import com.wl.padroes_de_projeto_spring.dto.ClienteRequestDTO;
import com.wl.padroes_de_projeto_spring.model.Cliente;
import com.wl.padroes_de_projeto_spring.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>FACADE</b>, pois abstrai toda a complexidade
 * de integrações (Banco de dados H2 e API do ViaCep) em uma interface simples e coesa (API REST).
 */
@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody @Valid ClienteRequestDTO clienteDto) {
        return ResponseEntity.status(201).body(clienteService.inserir(clienteDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
