package com.sabina.registry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type_of_ownership")
    private String typeOfOwnership;

    @Column(name = "legal_form")
    private String legalForm;

    public Company() { }

    public Company(String typeOfOwnership, String legalForm) {
        this.typeOfOwnership = typeOfOwnership;
        this.legalForm = legalForm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfOwnership() {
        return typeOfOwnership;
    }

    public void setTypeOfOwnership(String typeOfOwnership) {
        this.typeOfOwnership = typeOfOwnership;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }
}