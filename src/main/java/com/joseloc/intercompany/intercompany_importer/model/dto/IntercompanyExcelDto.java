package com.joseloc.intercompany.intercompany_importer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IntercompanyExcelDto {

    private String tipo;
    private String pep;
    private String kostl;
    private String concepto;
    private String racct;
    private String markup;
    private String ordenCompra;
    private String posicion;
    private String codServicio;
    private String habilitar;

}
