package com.wl.padroes_de_projeto_spring.service.impl;

import com.wl.padroes_de_projeto_spring.dto.ClienteRequestDTO;
import com.wl.padroes_de_projeto_spring.exception.ResourceNotFoundException;
import com.wl.padroes_de_projeto_spring.model.Cliente;
import com.wl.padroes_de_projeto_spring.model.ClienteRepository;
import com.wl.padroes_de_projeto_spring.model.Endereco;
import com.wl.padroes_de_projeto_spring.model.EnderecoRepository;
import com.wl.padroes_de_projeto_spring.service.ClienteService;
import com.wl.padroes_de_projeto_spring.service.ViaCepService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, que pode ser injetada pelo
 * Spring (via {@link Autowired}). Como essa classe é anotada como {@link Service},
 * ela será tratada como um <b>Singleton</b>, garantindo uma única instância.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    /**
     * Retorna todos os clientes cadastrados no banco de dados.
     *
     * @return um {@link Iterable} contendo todos os clientes.
     */
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Busca um cliente pelo ID. Se o cliente não for encontrado, lança uma exceção.
     *
     * @param id o ID do cliente a ser buscado.
     * @return o cliente encontrado.
     * @throws ResourceNotFoundException se o cliente não for encontrado.
     */
    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));
    }

    /**
     * Insere um novo cliente no banco de dados.
     * A inserção envolve a verificação e salvamento do endereço do cliente com base no CEP.
     *
     * @param clienteDto o cliente a ser inserido.
     */
    @Override
    public Cliente inserir(ClienteRequestDTO clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDto.nome());
        Endereco endereco = cliente.getEndereco();
        if (endereco == null) {
            endereco = new Endereco();
            cliente.setEndereco(endereco);
        }
        endereco.setCep(clienteDto.endereco().cep());
        return salvarClienteComCep(cliente);
    }

    /**
     * Atualiza um cliente existente com base no ID. Se o cliente não for encontrado, lança uma exceção.
     *
     * @param id o ID do cliente a ser atualizado.
     * @param cliente o cliente com os novos dados.
     * @throws ResourceNotFoundException se o cliente não for encontrado.
     */
    @Override
    public void atualizar(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            salvarClienteComCep(cliente);
        } else {
            throw new ResourceNotFoundException("Cliente não encontrado com ID: " + id);
        }
    }

    /**
     * Deleta um cliente com base no ID. Se o cliente não for encontrado, lança uma exceção.
     *
     * @param id o ID do cliente a ser deletado.
     * @throws ResourceNotFoundException se o cliente não for encontrado.
     */
    @Override
    public void deletar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Cliente não encontrado com ID: " + id);
        }
    }

    /**
     * Salva o cliente com o endereço associado, utilizando o CEP para buscar ou salvar o endereço no banco de dados.
     * Se o CEP não for encontrado, ele será consultado através de um serviço externo e salvo.
     *
     * @param cliente o cliente a ser salvo com seu endereço.
     */
    private Cliente salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            try {
                return enderecoRepository.save(viaCepService.consultarCep(cep));
            } catch (Exception e) {
                throw new RuntimeException("Erro ao consultar o CEP: " + cep, e);
            }
        });
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }
}