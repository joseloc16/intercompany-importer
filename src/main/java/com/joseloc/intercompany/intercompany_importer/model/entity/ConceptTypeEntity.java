package com.joseloc.intercompany.intercompany_importer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table( name = "INTERCOMPANY_CONCEPTTYPE" )
public class ConceptTypeEntity implements Serializable {

    @Id
    @Column( name = "CODE", length = 10, nullable = false )
    private String code;

    @Column( name = "NAME", length = 100, nullable = false )
    private String name;

    @Column( name = "DESCRIPTION", length = 250 )
    private String description;

    @Column( name = "ENABLED", nullable = false )
    private Boolean enabled;
}
