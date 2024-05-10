package com.teksystem.companysearch.services;

import com.teksystem.companysearch.config.WebClientConfig;
import com.teksystem.companysearch.dto.OfficeResponseDTO;
import com.teksystem.companysearch.model.Company;
import com.teksystem.companysearch.model.Officer;
import com.teksystem.companysearch.utils.Expression;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OfficeSearchService {

    @Autowired
    private WebClientConfig webClientConfig;

    private String key ;
    private static final Logger logger = LoggerFactory.getLogger(ComapanySearchService.class);
    public void getOfficerDetail(ArrayList<Company> companyList, String key){
        logger.info("Method of OfficeSearchService :: getOfficerDetail");
        this.key = key;
        companyList.forEach(comp -> comp.setOfficer(getDetails(comp.getCompanyNumber())));
    }

    private List<Officer> getDetails(String id) {
        List<Officer> officerList = Objects.requireNonNull(webClientConfig.webClient.get()
                .uri("Officers?CompanyNumber={id}", id)
                .header(Expression.AUTH_TOKEN_HEADER_NAME, this.key)
                .retrieve()
                .bodyToMono(OfficeResponseDTO.class).block()).getItems();
        return officerList.stream().filter(officer -> officer.getResignedOn() == null)
                    .toList();
    }
}
