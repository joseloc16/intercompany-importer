package com.joseloc.intercompany.intercompany_importer.repository;

import com.joseloc.intercompany.intercompany_importer.model.dto.IntercompanyExcelDto;
import com.joseloc.intercompany.intercompany_importer.model.records.ResultadoSpDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Slf4j
@Repository
public class IntercompanySpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResultadoSpDto insertFromExcelRow( IntercompanyExcelDto dto ) {
        log.info( "SP -> Tipo: {} | PEP: {} | KOSTL: {} | Concepto: {} | RACCT: {} | Markup: {} | OrdenCompra: {} | Posicion: {} | Habilitar: {} | CodServicio: {}",
                dto.getTipo( ), dto.getPep( ), dto.getKostl( ), dto.getConcepto( ), dto.getRacct( ),
                dto.getMarkup( ), dto.getOrdenCompra( ), dto.getPosicion( ), dto.getHabilitar( ), dto.getCodServicio( ) );

        try {
            return jdbcTemplate.execute( ( Connection conn ) -> {
                try( CallableStatement stmt = conn.prepareCall(
                        "{CALL APPARKA_DEV.SP_INSERT_INTERCOMPANY_CONCEPT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}" ) ) {

                    // Parámetros de entrada
                    stmt.setString( 1, dto.getTipo( ) );
                    stmt.setString( 2, dto.getPep( ) );
                    stmt.setString( 3, dto.getKostl( ) );
                    stmt.setString( 4, dto.getConcepto( ) );
                    stmt.setString( 5, dto.getRacct( ) );
                    stmt.setBigDecimal( 6, new BigDecimal( dto.getMarkup( ) ) );
                    stmt.setString( 7, dto.getOrdenCompra( ) );
                    stmt.setString( 8, dto.getPosicion( ) );
                    stmt.setBoolean( 9, "X".equals( dto.getHabilitar( ) ) );
                    stmt.setString( 10, dto.getCodServicio( ) );

                    // Parámetros de salida
                    stmt.registerOutParameter( 11, Types.VARCHAR ); // O_CODIGO
                    stmt.registerOutParameter( 12, Types.VARCHAR ); // O_MENSAJE

                    stmt.execute( );

                    String codigo = stmt.getString( 11 );
                    String mensaje = stmt.getString( 12 );

                    if( !"00".equals( codigo ) ) {
                        log.warn( "Fila con errores en datos: {}", mensaje );
                    } else {
                        log.info( "Insert exitoso" );
                    }

                    return new ResultadoSpDto( codigo, mensaje );
                }
            } );
        } catch( DataAccessException ex ) {
            log.error( "Error al ejecutar el SP desde JDBC: {}", ex.getMessage( ) );
            log.debug( "Stack trace completo del error JDBC", ex );
            return new ResultadoSpDto( "99", "Error inesperado: " + ex.getMessage( ) );
        }
    }

}
