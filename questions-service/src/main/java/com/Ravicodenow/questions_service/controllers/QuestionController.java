package com.Ravicodenow.questions_service.controllers;

import com.Ravicodenow.questions_service.model.Question;
import com.Ravicodenow.questions_service.model.QuestionWrapper;
import com.Ravicodenow.questions_service.model.Response;
import com.Ravicodenow.questions_service.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class use for question controller
 */
@RestController
@RequestMapping("question-api")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("questions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("questions/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
       return questionService.getAllQuestionByCategory(category);
    }

    @PostMapping("questions")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return  questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(
            @RequestParam String categoryName, @RequestParam Integer numQuestions){
        return questionService.getQuestionsForQuiz(categoryName,numQuestions);

    }

    @PostMapping("getQuestions")
    public  ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return  questionService.getScore(responses);
    }
    // generate
    // getQuestions(questionId)
    // getScore()

}
