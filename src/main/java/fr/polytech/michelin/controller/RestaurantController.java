package fr.polytech.michelin.controller;

import fr.polytech.michelin.dto.RestaurantDto;
import fr.polytech.michelin.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
//@RequiredArgsConstructor
@Slf4j

public class RestaurantController {
    public final RestaurantService restaurantService; //final : indiq pour dire que ça change pas plus tard (constante et pas variable)

    public RestaurantController(RestaurantService rservice) {
        this.restaurantService = rservice;
    }

    @GetMapping("/restaurant/{id}")
    public @ResponseBody RestaurantDto getRestaurantById(@PathVariable int id) {
        return RestaurantDto.fromEntity(this.restaurantService.getRestaurantById(id));
    }


    @GetMapping("/restaurant")
    public @ResponseBody List<RestaurantDto> getRestaurant() {
        System.out.println("retourne tous les restaurants");
        return this.restaurantService.getAllRestaurant().stream().map(entity -> RestaurantDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("/restaurant")
    public RestaurantDto postRestaurant(@Valid @RequestBody RestaurantDto r) {
        return RestaurantDto.fromEntity(this.restaurantService.addRestaurant(r.getNom()));
    }
}

