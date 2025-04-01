package com.joseloc.intercompany.intercompany_importer.controller;

import com.joseloc.intercompany.intercompany_importer.model.dto.IntercompanyExcelDto;
import com.joseloc.intercompany.intercompany_importer.service.IIntercompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( value = { "/intercompany" } )
public class IntercompanyController {

    private final IIntercompanyService service;

    @GetMapping( value = "/get", headers = "Accept=application/json" )
    public List<IntercompanyExcelDto> getAllCompanies( ) {
        List<IntercompanyExcelDto> tasks = service.saveData( );
        return tasks;
    }

}
