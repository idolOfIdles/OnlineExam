package com.safayat.exam.onlineExam.model;

public class Option{
  private Integer id;
  private Integer question_id;
  private String description;
  public Integer getId(){
    return id;
  }
  public void setId(Integer value){
    this.id=value;
  }
  public Integer getQuestion_id(){
    return question_id;
  }
  public void setQuestion_id(Integer value){
    this.question_id=value;
  }
  public String getDescription(){
    return description;
  }
  public void setDescription(String value){
    this.description=value;
  }
}