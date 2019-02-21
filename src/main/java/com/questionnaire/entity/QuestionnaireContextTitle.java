package com.questionnaire.entity;

public class QuestionnaireContextTitle {
    private Integer id;

    private String questionnaireTitle;

    private Integer questionnaireContextId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle == null ? null : questionnaireTitle.trim();
    }

    public Integer getQuestionnaireContextId() {
        return questionnaireContextId;
    }

    public void setQuestionnaireContextId(Integer questionnaireContextId) {
        this.questionnaireContextId = questionnaireContextId;
    }
}