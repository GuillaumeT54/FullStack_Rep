package fr.polytech.michelin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.michelin.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.security.cert.CertPathBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nom")
    @Size(max = 90)
    private String nom;

    @JsonProperty("adresse")
    @Size(max = 255)
    private Void adresse;

    @JsonProperty("evaluation")
    private List<EvaluationDto> evaluation;

    public static RestaurantDto fromEntity(RestaurantEntity restaurantEntity) {
        return RestaurantDto.builder().
                id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .evaluation(restaurantEntity.getEvaluation().stream().map(evaluation -> EvaluationDto.fromEntity(evaluation)).collect(Collectors.toList()))
                .build();
    }

}

