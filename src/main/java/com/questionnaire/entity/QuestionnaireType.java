package com.questionnaire.entity;

public class QuestionnaireType {
    private Integer id;

    private String typeName;

    private Integer questionnarieId;

    private Integer questionnarieContexId;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getQuestionnarieId() {
        return questionnarieId;
    }

    public void setQuestionnarieId(Integer questionnarieId) {
        this.questionnarieId = questionnarieId;
    }

    public Integer getQuestionnarieContexId() {
        return questionnarieContexId;
    }

    public void setQuestionnarieContexId(Integer questionnarieContexId) {
        this.questionnarieContexId = questionnarieContexId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}