package com.vivid.partnerships.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);
        return events;
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(Integer id) {
        Optional<Event> event = null;
        if ((event = eventRepository.findById(id)).isPresent())
            return event.get();
        else
            return null;
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

}