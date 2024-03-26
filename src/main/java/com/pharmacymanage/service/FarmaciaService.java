package com.pharmacymanage.service;

import com.pharmacymanage.model.Farmacia;
import com.pharmacymanage.repository.FarmaciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaService {

    private FarmaciaRepository farmaciaRepository;

    public FarmaciaService(FarmaciaRepository farmaciaRepository) {
        this.farmaciaRepository = farmaciaRepository;
    }

    public List<Farmacia> listarTodasFarmacias() {
        return farmaciaRepository.findAll();
    }

    public Farmacia consultarFarmaciaPorCnpj(Long cnpj) {
        return farmaciaRepository.findById(cnpj).orElseThrow(() -> new RuntimeException());
    }

    public Farmacia cadastrarFarmacia(Farmacia farmacia) {

        if (farmaciaRepository.findById(farmacia.getCnpj()).isPresent()) {
            throw new RuntimeException("CNPJ já cadastrado");
        }

        return farmaciaRepository.save(farmacia);
    }
}
