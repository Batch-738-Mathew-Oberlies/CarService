package com.revature.rideshare.carservice.models;

import com.revature.rideshare.carservice.exceptions.IllegalNullArgumentException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CarTripDTO {

	@NotNull
	@Valid
	private CarDTO car;
	@NotNull
	@Valid
	private TripDTO currentTrip;

	public CarTripDTO(Car car, Trip currentTrip) {
		super();
		if (car == null) {
			throw new IllegalNullArgumentException("CarTripDTO requires a car to construct.");
		} else if (currentTrip == null) {
			throw new IllegalNullArgumentException("CarTripDTO requires a trip to construct.");
		}
		this.car = new CarDTO(car);
		this.currentTrip = new TripDTO(currentTrip);
	}
	public CarTripDTO(CarDTO carDto, TripDTO tripDto) {
		super();
		if (carDto == null) {
			throw new IllegalNullArgumentException("CarTripDTO requires a carDto to construct.");
		} else if (tripDto == null) {
			throw new IllegalNullArgumentException("CarTripDTO requires a tripDto to construct.");
		}
		this.car = carDto;
		this.currentTrip = tripDto;
	}
	
	
}
