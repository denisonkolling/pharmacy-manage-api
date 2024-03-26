package com.pharmacymanage.controller;

import com.pharmacymanage.dto.TelefoneRequest;
import com.pharmacymanage.model.Farmacia;
import com.pharmacymanage.model.Telefone;
import com.pharmacymanage.service.FarmaciaService;
import com.pharmacymanage.service.TelefoneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    private FarmaciaService farmaciaService;
    private TelefoneService telefoneService;

    public FarmaciaController(FarmaciaService farmaciaService, TelefoneService telefoneService) {
        this.farmaciaService = farmaciaService;
        this.telefoneService = telefoneService;
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

    @PostMapping("{cnpj}/telefones")
    public ResponseEntity<Telefone> cadastrarTelefone(@PathVariable("cnpj") Long cnpj, @RequestBody TelefoneRequest telefoneRequest) {

        Telefone telefone = new Telefone();

        telefone.setFarmacia(farmaciaService.consultarFarmaciaPorCnpj(cnpj));
        telefone.setCodigoPais(telefoneRequest.getCodigoPais());
        telefone.setCodigoDDD(telefoneRequest.getCodigoDDD());
        telefone.setNumeroTelefone(telefoneRequest.getNumeroTelefone());

        telefoneService.cadastrarTelefone(telefone);
        return new ResponseEntity<>(telefone, HttpStatus.CREATED);
    }

    @DeleteMapping("{cnpj}/telefones/{id}")
    public ResponseEntity<?> removerTelefone(@PathVariable("cnpj") Long cnpj, @PathVariable("id") Long id) {
        telefoneService.removerTelefone(cnpj, id);
        return ResponseEntity.noContent().build();
    }
}
