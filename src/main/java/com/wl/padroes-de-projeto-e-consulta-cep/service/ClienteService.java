package com.wl.padroes_de_projeto_spring.service;

import com.wl.padroes_de_projeto_spring.dto.ClienteRequestDTO;
import com.wl.padroes_de_projeto_spring.model.Cliente;

/**
 *Interface que define o padrão de projeto <b>Strategy</b> no domínio de cliente.
 * Com isso, se necessário, podemos ter múltiplas implementações dessa mesma interface.
 */
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    Cliente inserir(ClienteRequestDTO clienteDto);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
