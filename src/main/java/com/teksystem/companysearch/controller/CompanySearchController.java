package com.teksystem.companysearch.controller;

import com.teksystem.companysearch.dto.CompanyResponseDTO;
import com.teksystem.companysearch.dto.CompanySearchRequest;
import com.teksystem.companysearch.model.Company;
import com.teksystem.companysearch.services.ComapanySearchService;
import com.teksystem.companysearch.services.OfficeSearchService;
import com.teksystem.companysearch.utils.Expression;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class CompanySearchController {
    private static final Logger logger = LoggerFactory.getLogger(CompanySearchController.class);

    @Autowired
    private ComapanySearchService comapanySearchService;

    @Autowired
    private OfficeSearchService officeSearchService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CompanyResponseDTO> companySearch(@RequestHeader(name= Expression.AUTH_TOKEN_HEADER_NAME, required = false) String apiKey,
                                                @RequestBody CompanySearchRequest companySearchRequest) throws Exception {
        logger.info("Start of CompanySearchController :: companySearch");
        CompanyResponseDTO companyResponseDTO;
        companyResponseDTO = comapanySearchService.getCompanyDetail(apiKey, companySearchRequest);
        officeSearchService.getOfficerDetail((ArrayList<Company>) companyResponseDTO.getItems(),apiKey);
        if(companySearchRequest.getCompanyNumber() != null){
            comapanySearchService.saveAll(companyResponseDTO);
        }
        ResponseEntity<CompanyResponseDTO> entity = new ResponseEntity<>(companyResponseDTO,HttpStatus.ACCEPTED);
        logger.info("End of CompanySearchController");
        return entity;
    }
}
