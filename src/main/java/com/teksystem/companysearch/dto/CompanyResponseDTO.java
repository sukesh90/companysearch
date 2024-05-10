package com.teksystem.companysearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teksystem.companysearch.model.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponseDTO {
    @JsonProperty("page_number")
    private float pageNumber;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("total_results")
    private float totalResults;

    @JsonProperty("items")
    List<Company> items = new ArrayList <> ();
}
