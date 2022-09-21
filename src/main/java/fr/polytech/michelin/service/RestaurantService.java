package fr.polytech.michelin.service;

import fr.polytech.michelin.entity.RestaurantEntity;
import fr.polytech.michelin.exception.InvalidValueException;
import fr.polytech.michelin.exception.ResourceDoesntExistException;
import fr.polytech.michelin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantEntity getRestaurantById(int id) {
        return this.restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesntExistException("restaurant with id " + id + " doesn't exists"));
    }

    public List<RestaurantEntity> getAllRestaurant() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity addRestaurant(final String nom) {
        final RestaurantEntity nouveauRestaurant = RestaurantEntity.builder().nom(nom).build();
        return this.restaurantRepository.save(nouveauRestaurant);
    }

    public RestaurantEntity updateRestaurant(int id, String nouveauNom) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }
        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceDoesntExistException("le restaurant d'id " + id + " n'existe pas"));
        restaurantToUpdate.setNom(nouveauNom);
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }


}
