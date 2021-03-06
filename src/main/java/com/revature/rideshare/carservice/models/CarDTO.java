package com.revature.rideshare.carservice.models;

import com.revature.rideshare.carservice.exceptions.IllegalNullArgumentException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class CarDTO {

	private int carId;

	@Pattern(regexp = "[a-zA-Z ]+", message = "Colors may only contain letters and spaces.")
	private String color;

	@Positive(message = "Number of seats must be a positive number.")
	private int seats;

	@NotBlank(message = "Car make cannot be blank.")
	@Pattern(regexp = "[a-zA-Z0-9 -]+", message = "A car's make may only contain letters, numbers, hyphens and spaces.")
	private String make;

	@NotBlank(message = "Car model cannot be blank.")
	@Pattern(regexp = "[a-zA-Z0-9 -]+", message = "A car's model may only contain letters, numbers, hyphens and spaces.")
	private String model;

	@Positive(message = "Car year must be a positive number.")
	private int year;

	@NotNull(message = "Cars must have an owner.")
	private UserDTO user;

	public CarDTO(Car car) {
		super();
		if (car == null) {
			throw new IllegalNullArgumentException("Car DTO requires a car parameter");
		}
		this.carId = car.getCarId();
		this.color = car.getColor();
		this.seats = car.getSeats();
		this.make = car.getMake();
		this.model = car.getModel();
		this.year = car.getYear();
		this.user = new UserDTO(car.getUser());
	}


}
