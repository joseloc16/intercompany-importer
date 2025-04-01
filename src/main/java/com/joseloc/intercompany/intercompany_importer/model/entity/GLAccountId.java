package com.joseloc.intercompany.intercompany_importer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Embeddable
public class GLAccountId implements Serializable {

    @Column( name = "GLACCOUNT", nullable = false, length = 10 )
    private String glAccount;

    @Column( name = "COMPANYCODE", nullable = false, length = 4 )
    private String companyCode;

}