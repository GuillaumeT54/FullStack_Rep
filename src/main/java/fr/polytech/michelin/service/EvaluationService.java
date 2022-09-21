package fr.polytech.michelin.service;

import fr.polytech.michelin.entity.EvaluationEntity;
import fr.polytech.michelin.entity.RestaurantEntity;
import fr.polytech.michelin.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluation(int restaurantId, String messageEvaluation) {
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity nouveauEvaluation = EvaluationEntity.builder().message(messageEvaluation).restaurant(restaurant).build();

        return this.evaluationRepository.save(nouveauEvaluation);
    }

}
