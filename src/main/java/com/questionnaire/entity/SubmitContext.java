package com.questionnaire.entity;

public class SubmitContext {
    private Integer id;

    private Integer questionnaireId;

    private Integer studentId;

    private Integer questionnaireTitleId;

    private Integer questionnaireContextId;

    private Integer submitState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getQuestionnaireTitleId() {
        return questionnaireTitleId;
    }

    public void setQuestionnaireTitleId(Integer questionnaireTitleId) {
        this.questionnaireTitleId = questionnaireTitleId;
    }

    public Integer getQuestionnaireContextId() {
        return questionnaireContextId;
    }

    public void setQuestionnaireContextId(Integer questionnaireContextId) {
        this.questionnaireContextId = questionnaireContextId;
    }

    public Integer getSubmitState() {
        return submitState;
    }

    public void setSubmitState(Integer submitState) {
        this.submitState = submitState;
    }
}