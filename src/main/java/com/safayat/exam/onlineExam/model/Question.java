package com.safayat.exam.onlineExam.model;

import safayat.orm.annotation.OneToMany;

import java.util.Date;
import java.util.List;

public class Question{
  private Integer id;
  private String question;
  private Date createDate;
  private Date updateDate;


    @OneToMany(type = Option.class
            , name = "answerList"
            , nativeColumnName = "id"
            , matchingColumnName = "question_id")
    List<Option> answerList;

    @OneToMany(type = Option.class
            , name = "optionList"
            , nativeColumnName = "id"
            , matchingColumnName = "question_id")
    List<Option> optionList;

  public Integer getId(){
    return id;
  }
  public void setId(Integer value){
    this.id=value;
  }
  public String getQuestion(){
    return question;
  }
  public void setQuestion(String value){
    this.question=value;
  }
  public Date getCreateDate(){
    return createDate;
  }
  public void setCreateDate(Date value){
    this.createDate=value;
  }
  public Date getUpdateDate(){
    return updateDate;
  }
  public void setUpdateDate(Date value){
    this.updateDate=value;
  }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public List<Option> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Option> answerList) {
        this.answerList = answerList;
    }
}