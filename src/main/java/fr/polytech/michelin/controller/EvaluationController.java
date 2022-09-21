package fr.polytech.michelin.controller;

import fr.polytech.michelin.dto.EvaluationDto;
import fr.polytech.michelin.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("restaurant/{restaurantId}/evaluation")
    public @ResponseBody EvaluationDto addEvaluation(@Valid @RequestBody EvaluationDto dto, @PathVariable int restaurantId) {
        return EvaluationDto.fromEntity(this.evaluationService.addEvaluation(restaurantId, dto.getMessage()));
    }

}