package com.teksystem.companysearch.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column
    @JsonProperty
    private String locality;

    @Column(name="postal_code")
    @JsonProperty("postal_code")
    private String postalCode;

    @Column(name="premises")
    @JsonProperty
    private String premises;

    @Column(name="address_line_1")
    @JsonProperty("address_line_1")
    private String addressLine;

    @Column
    @JsonProperty
    private String country;

}
