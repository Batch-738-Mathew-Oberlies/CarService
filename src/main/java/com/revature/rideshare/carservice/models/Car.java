package com.revature.rideshare.carservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Car class that represents a user's car. All cars have an id, color, seats, make, model, year
 * and the corresponding user.
 *
 * @author Adonis Cabreja
 *
 */

@Component
@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int carId;
	private String color;
	private int seats;
	private String make;
	private String model;
	@Column(name = "car_year")
	private int year;

	@OneToOne
	@JoinColumn(name = "user_id", unique = true)
	private User user;

	public Car(CarDTO carDTO) {
		super();
		if (carDTO != null) {
			this.carId = carDTO.getCarId();
			this.color = carDTO.getColor();
			this.seats = carDTO.getSeats();
			this.make = carDTO.getMake();
			this.model = carDTO.getModel();
			this.year = carDTO.getYear();
			this.user = new User(carDTO.getUser());
		}
	}
}
