package ILearn.learning.controller;

import ILearn.global.Response.ApiResponse;
import ILearn.learning.response.LearningResponse;
import ILearn.learning.service.LearningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@Validated
@RequestMapping("/learning")
@Slf4j
@EnableSwagger2
public class LearningController {

    private final LearningService learningService;

    @Autowired
    public LearningController(LearningService learningService) {
        this.learningService = learningService;
    }

    @GetMapping
    public ResponseEntity<LearningResponse> getLearningDetails(@PathVariable Long learningId) {
        LearningResponse response = learningService.getLearningDetails(learningId);
        return ResponseEntity.ok(response);
    }
}
