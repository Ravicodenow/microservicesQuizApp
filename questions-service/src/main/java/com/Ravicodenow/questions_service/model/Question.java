package com.Ravicodenow.questions_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String category;
    private String difficulty_level;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;
    private String right_ans;

}
