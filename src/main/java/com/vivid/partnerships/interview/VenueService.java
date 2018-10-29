package com.vivid.partnerships.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public List<Venue> getVenues() {
        List<Venue> venues = new ArrayList<>();
        venueRepository.findAll().forEach(venues::add);
        return venues;
    }

    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }

}
