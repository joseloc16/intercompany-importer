package com.joseloc.intercompany.intercompany_importer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "MASTER_DATA_GLACCOUNT" )
public class GLAccountEntity implements Serializable {

    @EmbeddedId
    private GLAccountId id;

    @Column( name = "CHARTOFACCOUNTS", length = 4 )
    private String chartOfAccounts;

    @Column( name = "GLACCOUNTGROUP", length = 4 )
    private String glAccountGroup;

    @Column( name = "CORPORATEGROUPACCOUNT", length = 10 )
    private String corporateGroupAccount;

    @Column( name = "ACCOUNTISBLOCKEDFORPOSTING" )
    private Boolean accountIsBlockedForPosting;

    @Column( name = "ACCOUNTISBLOCKEDFORPLANNING" )
    private Boolean accountIsBlockedForPlanning;

    @Column( name = "ACCOUNTISBLOCKEDFORCREATION" )
    private Boolean accountIsBlockedForCreation;

    @Column( name = "ISBALANCESHEETACCOUNT" )
    private Boolean isBalanceSheetAccount;

    @Column( name = "ACCOUNTISMARKEDFORDELETION" )
    private Boolean accountIsMarkedForDeletion;

    @Column( name = "PARTNERCOMPANY", length = 6 )
    private String partnerCompany;

    @Column( name = "FUNCTIONALAREA", length = 16 )
    private String functionalArea;

    @Column( name = "SAMPLEGLACCOUNT", length = 10 )
    private String sampleGlAccount;

    @Column( name = "ISPROFITLOSSACCOUNT" )
    private Boolean isProfitLossAccount;

    @Column( name = "GLACCOUNTTYPE", length = 1 )
    private String glAccountType;

    @Column( name = "PROFITLOSSACCOUNTTYPE", length = 2 )
    private String profitLossAccountType;

    @Column( name = "RECONCILIATIONACCOUNTTYPE", length = 1 )
    private String reconciliationAccountType;

    @Column( name = "LINEITEMDISPLAYISENABLED" )
    private Boolean lineItemDisplayIsEnabled;

    @Column( name = "ISOPENITEMMANAGED" )
    private Boolean isOpenItemManaged;

    @Column( name = "ALTERNATIVEGLACCOUNT", length = 10 )
    private String alternativeGlAccount;

    @Column( name = "ACCTGDOCITMDISPLAYSEQUENCERULE", length = 3 )
    private String acctgDocItmDisplaySequenceRule;

    @Column( name = "GLACCOUNTEXTERNAL", length = 10 )
    private String glAccountExternal;

    @Column( name = "COUNTRYCHARTOFACCOUNTS", length = 4 )
    private String countryChartOfAccounts;

    @Column( name = "AUTHORIZATIONGROUP", length = 4 )
    private String authorizationGroup;

    @Column( name = "TAXCATEGORY", length = 2 )
    private String taxCategory;

    @Column( name = "ISAUTOMATICALLYPOSTED" )
    private Boolean isAutomaticallyPosted;

    @Column( name = "COMPANYCODENAME", length = 25 )
    private String companyCodeName;

}
