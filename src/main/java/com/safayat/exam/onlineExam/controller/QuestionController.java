package com.safayat.exam.onlineExam.controller;

import com.safayat.exam.onlineExam.dao.QuestionDAO;
import com.safayat.exam.onlineExam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import safayat.orm.dao.GeneralRepository;
import safayat.orm.reflect.Util;

import java.util.List;
import java.util.Queue;

/**
 * Created by safayat on 11/22/18.
 */

@RestController
public class QuestionController {

    @Autowired
    QuestionDAO questionDAO;


    @RequestMapping("/questions")
    public List<Question> getQuestions(){
        List<Question> questions =  questionDAO.getAll(Question.class, 10);
        return questions;
    }

    @RequestMapping("/questionsWithOptions")
    public List<Question> getQuestionsWithOptions(){
        List<Question> questions =  questionDAO.getAll(Question.class,
                "Select * from question qt left join online_exam.option op on qt.id = op.question_id"
        );
        return questions;
    }


}
