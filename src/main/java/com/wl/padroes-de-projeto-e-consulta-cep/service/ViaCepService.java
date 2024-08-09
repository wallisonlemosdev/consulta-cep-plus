package com.wl.padroes_de_projeto_spring.service;

import com.wl.padroes_de_projeto_spring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    /**
     * Consulta o CEP fornecido na API ViaCep.
     * @param cep CEP a ser consultado.
     * @return Endereço correspondente ao CEP.
     */
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep) throws Exception;
}