package com.rik.regsys.data.company;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {
    @Autowired
    private final CompanyRepository companyRepository;

    public List<CompanyEntity> findAll(){return new ArrayList<>(companyRepository.findAll());}

    public CompanyEntity newCompany(CompanyEntity company){
        return companyRepository.save(company);
    }


}
