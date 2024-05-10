package com.teksystem.companysearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.teksystem.companysearch.model.Address.CompanyAddress;
//import com.teksystem.companysearch.model.Address.OfficerAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="officer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Officer {
    @Id
    @Column(name="officer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    @Column
    @JsonProperty
    private String name;

    @Column(name="officer_role")
    @JsonProperty("officer_role")
    private String role;

    @Column(name="appointed_on")
    @JsonProperty("appointed_on")
    private Date appointedOn;

    @Column(name="resigned_on")
    @JsonProperty("resigned_on")
    private Date resignedOn;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_officer_address")
    @JsonProperty("address")
    private Address officerAddress;

}
