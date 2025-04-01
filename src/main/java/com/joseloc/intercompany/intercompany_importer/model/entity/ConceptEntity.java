package com.joseloc.intercompany.intercompany_importer.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table( name = "INTERCOMPANY_CONCEPT" )
public class ConceptEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String id;

    @Column( name = "MARKUP", precision = 5, scale = 2 )
    private BigDecimal markup;

    @Column( name = "ENABLED" )
    private Boolean enabled;

    @Column( name = "TO_TYPE_CODE", length = 10, nullable = false )
    private String typeCode;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "TO_TYPE_CODE", referencedColumnName = "CODE", insertable = false, updatable = false )
    private RecordTypeEntity type;

    @Column( name = "TO_GLACCOUNT_GLACCOUNT", length = 10, nullable = false )
    private String glAccount;

    @Column( name = "TO_GLACCOUNT_COMPANYCODE", length = 4, nullable = false )
    private String companyCode;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumns( {
            @JoinColumn( name = "TO_GLACCOUNT_GLACCOUNT", referencedColumnName = "GLACCOUNT", insertable = false, updatable = false ),
            @JoinColumn( name = "TO_GLACCOUNT_COMPANYCODE", referencedColumnName = "COMPANYCODE", insertable = false, updatable = false )
    } )
    private GLAccountEntity glAccountEntity;

    @Column( name = "TO_COSTCENTER_COSTCENTER", length = 10 )
    private String costCenter;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "TO_COSTCENTER_COSTCENTER", referencedColumnName = "COSTCENTER", insertable = false, updatable = false )
    private CostCenterEntity costCenterEntity;

    @Column( name = "TO_PEPELEMENT_PROJECTELEMENTUUID", length = 36 )
    private String projectElementUUID;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "TO_PEPELEMENT_PROJECTELEMENTUUID", referencedColumnName = "PROJECTELEMENTUUID", insertable = false, updatable = false )
    private PepElementEntity pepElementEntity;

    @Column( name = "TO_CONCEPTTYPE_CODE", length = 10, nullable = false )
    private String conceptTypeCode;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "TO_CONCEPTTYPE_CODE", referencedColumnName = "CODE", insertable = false, updatable = false )
    private ConceptTypeEntity conceptType;

    @Column( name = "TO_PURCHASEORDERITEM_PURCHASEORDER", length = 10, nullable = false )
    private String purchaseOrder;

    @Column( name = "TO_PURCHASEORDERITEM_PURCHASEORDERITEM", length = 5, nullable = false )
    private String purchaseOrderItem;

}
