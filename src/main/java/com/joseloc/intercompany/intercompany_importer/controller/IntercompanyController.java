package com.joseloc.intercompany.intercompany_importer.controller;

import com.joseloc.intercompany.intercompany_importer.model.dto.IntercompanyExcelDto;
import com.joseloc.intercompany.intercompany_importer.service.IIntercompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( value = { "/intercompany" } )
public class IntercompanyController {

    private final IIntercompanyService service;

    @PostMapping( value = "/import", headers = "Accept=application/json" )
    public ResponseEntity<String> importIntercompanyData( ) {
        List<IntercompanyExcelDto> importedData = service.saveData( );
        return ResponseEntity.ok( "Se importaron " + importedData.size( ) + " registros correctamente." );
    }

}
