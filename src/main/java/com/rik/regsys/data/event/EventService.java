package com.rik.regsys.data.event;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    @Autowired
    private final EventRepository eventRepository;

    public List<EventEntity> findAll(){return new ArrayList<>(eventRepository.findAll());}

    public EventEntity newEvent(EventEntity event){
        return eventRepository.save(event);
    }

    public List<EventEntity> findPrevious(){
        List<EventEntity> previousEvents = new ArrayList<>();
        List<EventEntity> allEvents = eventRepository.findAll();
        for(EventEntity event : allEvents){
            if (event.getIsOver()){
                previousEvents.add(event);
            }
        }
        return previousEvents;
    }

    public List<EventEntity> findUpcoming(){
        List<EventEntity> upcomingEvents = new ArrayList<>();
        List<EventEntity> allEvents = eventRepository.findAll();
        for(EventEntity event : allEvents){
            if (!event.getIsOver()){
                upcomingEvents.add(event);
            }
        }
        return upcomingEvents;
    }
}
