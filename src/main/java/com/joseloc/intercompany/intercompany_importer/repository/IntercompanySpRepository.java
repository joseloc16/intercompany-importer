package com.joseloc.intercompany.intercompany_importer.repository;

import com.joseloc.intercompany.intercompany_importer.model.dto.IntercompanyExcelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class IntercompanySpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertFromExcelRow( IntercompanyExcelDto dto ) {

        System.out.println(
                "SP -> Tipo: " + dto.getTipo() +
                        " | PEP: " + dto.getPep() +
                        " | KOSTL: " + dto.getKostl() +
                        " | Concepto: " + dto.getConcepto() +
                        " | RACCT: " + dto.getRacct() +
                        " | Markup: " + dto.getMarkup() +
                        " | OrdenCompra: " + dto.getOrdenCompra() +
                        " | Posicion: " + dto.getPosicion() +
                        " | Habilitar: " + dto.getHabilitar() +
                        " | CodServicio: " + dto.getCodServicio()
        );

        jdbcTemplate.update(
                "CALL APPARKA_DEV.SP_INSERT_INTERCOMPANY_CONCEPT(?, ?, ?,?, ?, ?,?, ?, ?, ?)",
                dto.getTipo( ),
                dto.getPep( ),
                dto.getKostl( ),
                dto.getConcepto( ),
                dto.getRacct( ),
                new BigDecimal( dto.getMarkup( ) ),
                dto.getOrdenCompra( ),
                dto.getPosicion( ),
                "X".equals( dto.getHabilitar( ) ) ? Boolean.TRUE : Boolean.FALSE,
                dto.getCodServicio( )
        );
    }

}
