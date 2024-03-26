package com.pharmacymanage.controller;

import com.pharmacymanage.client.ViaCepClient;
import com.pharmacymanage.dto.EnderecoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private ViaCepClient viaCepClient;

    public EnderecoController(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    @GetMapping("{cep}/busca")
    public EnderecoResponse consultarCep(@PathVariable("cep") String cep) {
        return viaCepClient.consultarCep(cep);
    }
}
