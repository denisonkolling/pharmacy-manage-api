package com.pharmacymanage.controller;

import com.pharmacymanage.model.Farmacia;
import com.pharmacymanage.service.FarmaciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    private FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @GetMapping
    public ResponseEntity<List<Farmacia>> listarTodasFarmacias() {
        List<Farmacia> farmacias = farmaciaService.listarTodasFarmacias();
        return ResponseEntity.ok(farmacias);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Farmacia> consultarFarmaciaPorCnpj(@PathVariable("cnpj") Long cnpj) {
        Farmacia farmacia = farmaciaService.consultarFarmaciaPorCnpj(cnpj);
        return ResponseEntity.ok(farmacia);
    }
}
