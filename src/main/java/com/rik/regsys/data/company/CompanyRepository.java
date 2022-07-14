package com.rik.regsys.data.company;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
    List<CompanyEntity> findAll();
}
