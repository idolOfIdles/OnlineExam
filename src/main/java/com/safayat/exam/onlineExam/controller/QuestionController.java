package com.safayat.exam.onlineExam.controller;

import com.safayat.exam.onlineExam.dao.QuestionDAO;
import com.safayat.exam.onlineExam.model.Option;
import com.safayat.exam.onlineExam.model.Question;
import com.sun.tools.internal.ws.processor.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safayat.orm.config.ConfigManager;
import safayat.orm.crud.Crud;
import safayat.orm.dao.GeneralRepository;
import safayat.orm.query.MysqlQuery;
import safayat.orm.query.MysqlTable;
import safayat.orm.reflect.Util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by safayat on 11/22/18.
 */


@RequestMapping(value = "/question")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class QuestionController {

    @Autowired
    QuestionDAO questionDAO;


    @RequestMapping("/all")
    public List<Question> getQuestions(
            @RequestParam(required = false, defaultValue = "") String prefix
            , @RequestParam(required = false, defaultValue = "100") int limit
            , @RequestParam(required = false, defaultValue = "0") int offset

    ){
        MysqlTable mysqlTable =  MysqlQuery
                .All()
                .table(Question.class);

        if(!prefix.isEmpty()){

            return mysqlTable
                    .filter("question like",prefix + "%")
                    .limit(limit, offset)
                    .toList(Question.class);
        }

        return  mysqlTable
                .limit(limit, offset)
                .toList(Question.class);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createOrUpdate(@RequestBody Question question){
        try {
            question.setCreateDate(new Date());
            question.setUpdateDate(new Date());
            Crud.insert(question);
            return ResponseEntity.ok(question.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @RequestMapping(value = "/option/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createOrUpdateOption(@RequestBody Option option){
        try {
            Crud.insert(option);
            return ResponseEntity.ok(option.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @RequestMapping("/add/options/{question_id}")
    public ResponseEntity<Object> getQuestionsWithOptions(@RequestBody String[] descriptions
            , @PathVariable Integer question_id){

        try {
            Crud.insert(Arrays
                    .stream(descriptions)
                    .map(s -> new Option(question_id, s))
                    .collect(Collectors.toList())
            );
            return ResponseEntity.ok("Success");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/{question_id}")
    public List<Question> getQuestionsWithOptions(@PathVariable Integer question_id){

        return MysqlQuery
                .fields("*")
                .table(Question.class, "qt")
                .join(Option.class, "op")
                .on("qt.id", "op.question_id")
                .filter("qt.id =", question_id)
                .toList(Question.class);
    }


}
