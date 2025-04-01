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
@Table( name = "MASTER_DATA_PEPELEMENT" )
public class PepElementEntity implements Serializable {

    @Id
    @Column( name = "PROJECTELEMENTUUID", length = 36, nullable = false )
    private String projectElementUUID;

    @Column( name = "PROJECTELEMENT", length = 24, nullable = false )
    private String projectElement;

    @Column( name = "PROJECTELEMENTDESCRIPTION", length = 60 )
    private String projectElementDescription;

    @Column( name = "COMPANYCODE", length = 4 )
    private String companyCode;

    @Column( name = "PROFITCENTER", length = 10 )
    private String profitCenter;

    @Column( name = "PLANNEDSTARTDATE" )
    private LocalDate plannedStartDate;

    @Column( name = "PLANNEDENDDATE" )
    private LocalDate plannedEndDate;

    @Column( name = "PROJECTELEMENTORDINALNUMBER" )
    private Integer projectElementOrdinalNumber;

    @Column( name = "PARENTOBJECTUUID", length = 36 )
    private String parentObjectUUID;

    @Column( name = "PROJECTUUID", length = 36 )
    private String projectUUID;

    @Column( name = "WBSELEMENTINTERNALID", length = 8 )
    private String wbsElementInternalID;
}
