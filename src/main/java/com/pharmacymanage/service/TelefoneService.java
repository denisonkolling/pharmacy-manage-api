package com.pharmacymanage.service;

import com.pharmacymanage.model.Telefone;
import com.pharmacymanage.repository.TelefoneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }


    public Telefone cadastrarTelefone(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public void removerTelefone(Long cnpj, Long id) {

        Optional<Telefone> optionalTelefone = telefoneRepository.findById(id);

        if (optionalTelefone.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Telefone não encontrado com o ID: " + id);
        }

        Telefone telefone = optionalTelefone.get();

        if (!telefone.getFarmacia().getCnpj().equals(cnpj)) {
            throw new RuntimeException("O CNPJ da farmácia não confere com o telefone fornecido.");
        }

        telefoneRepository.delete(telefone);
    }
}
