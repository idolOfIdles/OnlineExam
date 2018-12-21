package com.safayat.exam.onlineExam.controller;

import com.safayat.exam.onlineExam.dao.QuestionDAO;
import com.safayat.exam.onlineExam.model.Answer;
import com.safayat.exam.onlineExam.model.Option;
import com.safayat.exam.onlineExam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safayat.orm.crud.Crud;
import safayat.orm.query.MysqlQuery;
import safayat.orm.query.MysqlTable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by safayat on 11/22/18.
 */


@RequestMapping(value = "/exam")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ExamController {



}
