package com.rik.regsys.data.person;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    List<PersonEntity> findAll();
}
