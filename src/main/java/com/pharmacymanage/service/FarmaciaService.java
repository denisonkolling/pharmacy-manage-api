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
}