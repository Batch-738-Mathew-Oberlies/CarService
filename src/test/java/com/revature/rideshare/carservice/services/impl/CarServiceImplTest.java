package com.revature.rideshare.carservice.services.impl;

import com.revature.rideshare.carservice.models.Car;
import com.revature.rideshare.carservice.models.User;
import com.revature.rideshare.carservice.repositories.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void testGettingCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());

        when(carRepository.findAll()).thenReturn(cars);

        assertEquals(2, carService.getCars().size());
    }

    @Test
    public void testGettingCarById() {
        Car expected = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());

        when(carRepository.findById(1)).thenReturn(Optional.of(expected));

        Optional<Car> actual = carService.getCarById(1);
        if (actual.isPresent()) assertEquals(actual.get(), expected);
        else fail();
    }

    @Test
    public void testGettingCarByUserId() {
        Car expected = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());

        when(carRepository.getCarByUserId(1)).thenReturn(expected);

        Car actual = carService.getCarByUserId(1);
        assertEquals(actual, expected);
    }

    @Test
    public void testAddingCar() {
        Car expected = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());

        when(carRepository.save(expected)).thenReturn(expected);

        Car actual = carService.addCar(expected);
        assertEquals(actual, expected);
    }

    @Test
    public void testUpdatingCar() {
        Car expected = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());

        when(carRepository.save(expected)).thenReturn(expected);

        Car actual = carService.updateCar(expected);
        assertEquals(actual, expected);
    }

    @Test
    public void testDeletingCar() {
        String expected = "Car with id: 1 was deleted.";

        when(carRepository.existsById(1)).thenReturn(true);

        String actual = carService.deleteCarById(1);
        assertEquals(actual, expected);
    }
}
