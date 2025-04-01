package com.joseloc.intercompany.intercompany_importer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
public abstract class BaseEntity {

    @Column( name = "CREATEDAT", updatable = false )
    @CreatedDate
    protected LocalDateTime createdAt;

    @Column( name = "CREATEDBY", updatable = false )
    @CreatedBy
    protected String createdBy;

    @Column( name = "MODIFIEDAT" )
    @LastModifiedDate
    protected LocalDateTime modifiedAt;

    @Column( name = "MODIFIEDBY" )
    @LastModifiedBy
    protected String modifiedBy;
}
