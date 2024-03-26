package com.pharmacymanage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name = "TELEFONES")
public class Telefone {

    @Id
    private Long id;

    private String codigoPais;

    private String codigoDDD;

    String numeroTelefone;

    @ManyToOne
    Farmacia farmacia;

}
