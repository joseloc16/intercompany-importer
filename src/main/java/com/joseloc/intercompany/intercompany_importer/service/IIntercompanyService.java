package com.joseloc.intercompany.intercompany_importer.service;

import com.joseloc.intercompany.intercompany_importer.model.dto.IntercompanyExcelDto;

import java.util.List;

public interface IIntercompanyService {
    List<IntercompanyExcelDto> getData();
}
