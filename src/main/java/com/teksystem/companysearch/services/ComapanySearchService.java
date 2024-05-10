package com.teksystem.companysearch.services;
import com.teksystem.companysearch.config.WebClientConfig;
import com.teksystem.companysearch.dto.CompanyResponseDTO;
import com.teksystem.companysearch.dto.CompanySearchRequest;
import com.teksystem.companysearch.repository.CompanyRepository;
import com.teksystem.companysearch.utils.Expression;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ComapanySearchService {

    @Autowired
    private WebClientConfig webClientConfig;

    @Autowired
    private CompanyRepository companyRepository;
    private static final Logger logger = LoggerFactory.getLogger(ComapanySearchService.class);
    public CompanyResponseDTO getCompanyDetail(String apiKey, CompanySearchRequest companySearchRequest) {
        logger.info("Start of ComapanySearchService :: getCompanyDetail");
        String companyNumber = getSearchString(companySearchRequest);
        CompanyResponseDTO companyResponseDTO = webClientConfig.webClient
                .get()
                .uri("Search?Query={companyNumber}",companyNumber)
                .header(Expression.AUTH_TOKEN_HEADER_NAME , apiKey)
                .retrieve()
                .bodyToMono(CompanyResponseDTO.class)
                .block();
        logger.info("End of ComapanySearchService :: getCompanyDetail");
        return companyResponseDTO;
    }

    private String getSearchString(CompanySearchRequest companySearchRequest) {
        return Optional.ofNullable(companySearchRequest.getCompanyNumber()).
                orElse(companySearchRequest.getCompanyName());
    }

    public void saveAll(CompanyResponseDTO companyResponseDTO){
        companyRepository.saveAll(companyResponseDTO.getItems());
    }
}
