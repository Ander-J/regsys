package com.rik.regsys.data.event;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {
    @Autowired
    private final EventRepository eventRepository;

    public List<EventEntity> findAll(){return new ArrayList<>(eventRepository.findAll());}

    public EventEntity findById(Long id){
        Optional<EventEntity> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    public void deleteById(Long id){
        eventRepository.deleteById(id);
    }

    public EventEntity newEvent(EventEntity event){
        return eventRepository.save(event);
    }

    public List<EventEntity> findPrevious(){
        List<EventEntity> previousEvents = new ArrayList<>();
        List<EventEntity> allEvents = eventRepository.findAll();
        for(EventEntity event : allEvents){
            if (event.getDate().before(new Date(System.currentTimeMillis()))){
                previousEvents.add(event);
            }
        }
        return previousEvents;
    }

    public List<EventEntity> findUpcoming(){
        List<EventEntity> upcomingEvents = new ArrayList<>();
        List<EventEntity> allEvents = eventRepository.findAll();
        for(EventEntity event : allEvents){
            if (!event.getDate().before(new Date(System.currentTimeMillis()))){
                upcomingEvents.add(event);
            }
        }
        return upcomingEvents;
    }
}
