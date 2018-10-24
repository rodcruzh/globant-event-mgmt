package com.vivid.partnerships.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Event> getEvents() {
         return jdbcTemplate.query("SELECT * FROM events", new EventRowMapper());
    }

    public void addEvent(Event event) {
        String sql = "INSERT INTO events (id, name, date, id_venue) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, event.getId(), event.getName(), event.getDate(), event.getVenue().getId());
    }

    public Event getEventById(Integer id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        RowMapper<Event> rowMapper = new BeanPropertyRowMapper<>(Event.class);
        Event event = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return event;
    }

    public void updateEvent(Event event) {
        String sql = "UPDATE events SET name = ?, date = ?, id_venue = ? WHERE id = ?";
        jdbcTemplate.update(sql, event.getName(), event.getDate(), event.getVenue().getId(), event.getId());
    }

    public List<Venue> getVenues() {
        return jdbcTemplate.query("SELECT * FROM venue", new VenueRowMapper());
    }

}