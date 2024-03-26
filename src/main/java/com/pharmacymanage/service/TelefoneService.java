package com.pharmacymanage.service;

import com.pharmacymanage.model.Telefone;
import com.pharmacymanage.repository.TelefoneRepository;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }


    public Telefone cadastrarTelefone(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

}
