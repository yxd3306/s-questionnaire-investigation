package com.questionnaire.entity;

public class QuestionnaireContext {
    private Integer id;

    private String comtextTitle;

    private String context;

    private Integer questionnaireId;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComtextTitle() {
        return comtextTitle;
    }

    public void setComtextTitle(String comtextTitle) {
        this.comtextTitle = comtextTitle == null ? null : comtextTitle.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}