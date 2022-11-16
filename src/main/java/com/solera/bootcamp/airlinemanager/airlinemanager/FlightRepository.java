package com.solera.bootcamp.airlinemanager.airlinemanager;

import java.util.Date;
import java.util.List;

public interface FlightRepository {
    List<Flight> getFlightData(Date date);
}

