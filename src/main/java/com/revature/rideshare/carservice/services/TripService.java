package com.revature.rideshare.carservice.services;

import com.revature.rideshare.carservice.models.Trip;
import com.revature.rideshare.carservice.models.TripDTO;

import java.util.List;
import java.util.Optional;

public interface TripService {
	List<Trip> getTrips();

	List<TripDTO> getTripsDTO();

	List<TripDTO> getTripsDTO(int offset);

	Optional<Trip> getTripById(int id);

	List<Trip> getTripsByDriverId(int driverId);

	Trip getCurrentTripByDriverId(int driverId);

	List<TripDTO> getTripsByDriverIdDTO(int driverId);

	List<TripDTO> getTripsByDriverIdDTO(int driverId, int offset);

	List<Trip> getTripsByRiderId(int riderId);

	List<TripDTO> getTripsByRiderIdDTO(int riderId);

	List<TripDTO> getTripsByRiderIdDTO(int riderId, int offset);

	List<Trip> getTripsByDriverIdAndByRiderId(int driverId, int riderId);

	List<TripDTO> getTripsByDriverIdAndByRiderIdDTO(int driverId, int riderId);

	List<TripDTO> getTripsByDriverIdAndByRiderIdDTO(int driverId, int riderId, int offset);

	Trip addTrip(Trip trip);

	Trip updateTrip(Trip trip);

	String deleteTripById(int id);
}
