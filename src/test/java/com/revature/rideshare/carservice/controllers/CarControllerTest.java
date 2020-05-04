package com.revature.rideshare.carservice.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rideshare.carservice.models.Car;
import com.revature.rideshare.carservice.models.CarDTO;
import com.revature.rideshare.carservice.models.User;
import com.revature.rideshare.carservice.services.CarService;
import com.revature.rideshare.carservice.services.TripService;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CarService carService;

    @MockBean
    private TripService tripService;

    @Test
    public void testGettingCars() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());

        when(carService.getCars()).thenReturn(cars);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGettingCarById() throws Exception {
        Car car = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());

        when(carService.getCarById(1)).thenReturn(java.util.Optional.of(car));

        mockMvc.perform(get("/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carId").value(1));
    }

    @Test
    public void testGettingCarByUserId() throws Exception {
        Car car = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());

        when(carService.getCarByUserId(1)).thenReturn(car);

        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carId").value(1));
    }

    @Test
    public void testAddingCar() throws Exception {
        Car car = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());
        CarDTO dto = new CarDTO(car);

        when(carService.addCar(new Car(dto))).thenReturn(car);

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.color").value("red"));
    }

    @Test
    public void testUpdatingCar() throws Exception {
        Car car = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());
        CarDTO dto = new CarDTO(car);

        when(carService.updateCar(new Car(dto))).thenReturn(car);

        mockMvc.perform(put("/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.color").value("red"))
                .andReturn();
    }

    @Test
    public void testDeletingCar() throws Exception {
        Car car = new Car(1, "red", 4, "Honda", "Accord", 2015, new User());
        String returnedStr = "Car with id: " + car.getCarId() + " was deleted";

        when(carService.deleteCarById(1)).thenReturn(returnedStr);

        mockMvc.perform(delete("/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(returnedStr));
    }
}
