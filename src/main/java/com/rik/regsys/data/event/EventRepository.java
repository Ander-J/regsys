package com.rik.regsys.data.event;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
    List<EventEntity> findAll();
}
