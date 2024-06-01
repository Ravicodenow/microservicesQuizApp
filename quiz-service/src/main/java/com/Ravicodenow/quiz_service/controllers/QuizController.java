package com.Ravicodenow.quiz_service.controllers;

import com.Ravicodenow.quiz_service.model.QuestionWrapper;
import com.Ravicodenow.quiz_service.model.QuizDto;
import com.Ravicodenow.quiz_service.model.Response;
import com.Ravicodenow.quiz_service.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz-api")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> getQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("quiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitAns(@PathVariable Integer id, @RequestBody List<Response> responses){
               return quizService.calculateResult(id,responses);
    }

}
