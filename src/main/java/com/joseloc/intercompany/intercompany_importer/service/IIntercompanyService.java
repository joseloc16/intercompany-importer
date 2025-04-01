package com.joseloc.intercompany.intercompany_importer.service;

import com.joseloc.intercompany.intercompany_importer.model.IntercompanyExcelDto;

import java.util.List;

public interface IIntercompanyService {
    List<IntercompanyExcelDto> getData();
}
