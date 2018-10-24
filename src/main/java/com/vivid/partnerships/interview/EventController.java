package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) {
        // TODO svc
    }

    @RequestMapping("/events/{id}")
    public Event getEvent(@PathVariable Integer id) {
        return null; // TODO svc
    }


    public void updateEvent(@PathVariable Integer id, @RequestBody Event event) {
        // TODO svc
    }

}
