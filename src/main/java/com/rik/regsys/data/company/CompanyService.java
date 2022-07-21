package com.rik.regsys.data.company;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {
    @Autowired
    private final CompanyRepository companyRepository;

    public List<CompanyEntity> findAll(){return new ArrayList<>(companyRepository.findAll());}

    public CompanyEntity newCompany(CompanyEntity company){
        return companyRepository.save(company);
    }

    public CompanyEntity findById(Long id) {
        Optional<CompanyEntity> companyEntity = companyRepository.findById(id);
        return companyEntity.orElse(null);
    }

    public CompanyEntity save(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
