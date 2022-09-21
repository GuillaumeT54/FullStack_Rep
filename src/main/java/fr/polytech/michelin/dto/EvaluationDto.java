package fr.polytech.michelin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.michelin.entity.EvaluationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EvaluationDto {

    @JsonProperty("id")
    private int id;

    @NotBlank
    @JsonProperty("auteur")
    private String auteur;

    @NotBlank
    @JsonProperty("message")
    private String message;

    public static EvaluationDto fromEntity(EvaluationEntity entity) {
        return EvaluationDto.builder().id(entity.getId()).message(entity.getMessage()).build();
    }

}
