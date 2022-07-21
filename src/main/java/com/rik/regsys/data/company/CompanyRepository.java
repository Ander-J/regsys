package com.rik.regsys.data.company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
    List<CompanyEntity> findAll();
}
