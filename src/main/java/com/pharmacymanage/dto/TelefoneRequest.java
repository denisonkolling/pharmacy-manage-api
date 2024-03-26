package com.pharmacymanage.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TelefoneRequest {

    @NotNull(message = "Campo obrigatório")
    private String codigoPais;

    @NotNull(message = "Campo obrigatório")
    private String codigoDDD;

    @NotNull(message = "Campo obrigatório")
    private String numeroTelefone;
}
