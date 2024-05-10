package com.teksystem.companysearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="company")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Company {

    @Id
    @Column(name="company_number")
    @JsonProperty("company_number")
    private String companyNumber;

    @Column(name="company_type")
    @JsonProperty("company_type")
    private String companyType;

    @Column
    @JsonProperty
    private String title;

    @Column(name="company_status")
    @JsonProperty("company_status")
    private String companyStatus;

    @Column(name="creation_date")
    @JsonProperty("date_of_creation")
    private Date dateOfCreation;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_company_address")
    @JsonProperty("address")
    private Address companyAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_company_id")
    @JsonProperty("officers")
    private List<Officer> officer;

}
