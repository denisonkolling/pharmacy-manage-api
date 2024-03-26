package com.pharmacymanage.model;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "TELEFONES")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoPais;

    private String codigoDDD;

    String numeroTelefone;

    @ManyToOne
    Farmacia farmacia;

}
