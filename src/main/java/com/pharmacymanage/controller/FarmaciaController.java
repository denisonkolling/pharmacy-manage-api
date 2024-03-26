package com.pharmacymanage.controller;

import com.pharmacymanage.model.Farmacia;
import com.pharmacymanage.service.FarmaciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Farmacia> cadastrarFarmacia(@RequestBody @Valid Farmacia farmacia) {
        farmacia = farmaciaService.cadastrarFarmacia(farmacia);
        return new ResponseEntity<>(farmacia, HttpStatus.CREATED);
    }
}
