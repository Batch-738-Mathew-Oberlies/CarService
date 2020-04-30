package com.revature.rideshare.carservice.models;

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
		this.car = new CarDTO(car);
		this.currentTrip = new TripDTO(currentTrip);
	}

	public CarTripDTO(CarDTO carDto, TripDTO tripDto) {
		super();
		this.car = carDto;
		this.currentTrip = tripDto;
	}
}
