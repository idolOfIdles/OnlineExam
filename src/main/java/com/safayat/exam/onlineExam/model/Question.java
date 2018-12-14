package com.safayat.exam.onlineExam.model;

import safayat.orm.annotation.OneToMany;

import java.util.Date;
import java.util.List;

public class Question{
  private Integer id;
  private String question;
  private Date createDate;
  private Date updateDate;


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

    @OneToMany(type = Option.class, name = "optionList")
    public List<Option> getOptionList() {
        return optionList;
    }

    @OneToMany(type = Option.class, name = "optionList")
    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}