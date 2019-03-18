package com.questionnaire.entity;

/**
 * @Package: com.questionnaire.entity
 * @Auther: 喻湘东
 * @Email: Jyxd1997@163.com
 * @Date: 2019-02-26 16:48:29
 * @Description: 然会提交内容对象
 */
public class RestSubmitContext {

    private Integer contextId;
    private String context;
    private Integer questionnaireId;
    private Integer questionnaireContextTitleId;
    private Integer contextState;
    private Integer submitState;
    private Integer studentId;

    public Integer getContextId() {
        return contextId;
    }

    public void setContextId(Integer contextId) {
        this.contextId = contextId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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

    public Integer getContextState() {
        return contextState;
    }

    public void setContextState(Integer contextState) {
        this.contextState = contextState;
    }

    public Integer getSubmitState() {
        return submitState;
    }

    public void setSubmitState(Integer submitState) {
        this.submitState = submitState;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
