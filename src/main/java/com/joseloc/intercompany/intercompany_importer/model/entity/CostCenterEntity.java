package com.joseloc.intercompany.intercompany_importer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table( name = "MASTER_DATA_COSTCENTER" )
public class CostCenterEntity implements Serializable {

    @Id
    @Column( name = "COSTCENTER", length = 10, nullable = false )
    private String costCenter;

    @Column( name = "COMPANYCODE", length = 4 )
    private String companyCode;

    @Column( name = "COSTCENTERNAME", length = 100 )
    private String costCenterName;

    @Column( name = "COSTCENTERDESCRIPTION", length = 250 )
    private String costCenterDescription;

    @Column( name = "VALIDITYENDDATE" )
    private LocalDate validityEndDate;

    @Column( name = "CONTROLLINGAREA", length = 4 )
    private String controllingArea;
}
