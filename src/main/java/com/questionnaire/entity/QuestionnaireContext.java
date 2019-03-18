package com.questionnaire.entity;

/**
 * 问卷内容对象
 */
public class QuestionnaireContext {
    private Integer id;

    private String context;

    private Integer questionnaireId;

    private Integer questionnaireContextTitleId;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getQuestionnaireContextTitleId() {
        return questionnaireContextTitleId;
    }

    public void setQuestionnaireContextTitleId(Integer questionnaireContextTitleId) {
        this.questionnaireContextTitleId = questionnaireContextTitleId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}