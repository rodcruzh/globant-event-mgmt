package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost" })
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> events = eventService.getEvents();
        LOGGER.info("Returning {} events", events.size());
        return events;
    }

    @PostMapping(value = "/events")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @GetMapping("/events/{id}")
    public Event getEvent(@PathVariable Integer id) {
        return eventService.getEventById(id);
    }

    @PutMapping(value = "/events/{id}")
    public void updateEvent(@PathVariable Integer id, @RequestBody Event event) {
        event.setId(id);
        eventService.updateEvent(event);
    }

    @GetMapping("/venues")
    public List<Venue> getVenues() {
        List<Venue> venues = eventService.getVenues();
        return venues;
    }

}
