package com.teksystem.companysearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teksystem.companysearch.model.Company;
import com.teksystem.companysearch.model.Officer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficeResponseDTO {
    @JsonProperty("items_per_page")
    private String itemsPerPage;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("etag")
    private String eTag;

    @JsonProperty("items")
    ArrayList<Officer> items = new ArrayList <> ();
}
