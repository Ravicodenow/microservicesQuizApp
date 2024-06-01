package com.Ravicodenow.quiz_service.feign;

import com.Ravicodenow.quiz_service.model.QuestionWrapper;
import com.Ravicodenow.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "QUESTIONS-SERVICE")
public interface QuizInterface {
    @GetMapping("question-api/generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions);

    @PostMapping("question-api/getQuestions")
    public  ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question-api/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
