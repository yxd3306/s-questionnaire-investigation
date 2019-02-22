package com.questionnaire.entity;

import java.util.List;

/**
 * @Package: com.questionnaire.entity
 * @Auther: 喻湘东
 * @Email: Jyxd1997@163.com
 * @Date: 2019-02-20 10:21:12
 * @Description:
 */
public class RestQuestionnaireObject {

    private Integer questionnaireId;
    private Integer questionnaireTypeId;

    private String questionnaireTitle;
    private String questionnaireTypeName;
    private Integer questionnaireState;


    private List<QuestionnaireContext> questionnaireContexts;
    private List<QuestionnaireContextTitle> questionnaireContextTitles;




    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getQuestionnaireTypeId() {
        return questionnaireTypeId;
    }

    public void setQuestionnaireTypeId(Integer questionnaireTypeId) {
        this.questionnaireTypeId = questionnaireTypeId;
    }

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public String getQuestionnaireTypeName() {
        return questionnaireTypeName;
    }

    public void setQuestionnaireTypeName(String questionnaireTypeName) {
        this.questionnaireTypeName = questionnaireTypeName;
    }

    public Integer getQuestionnaireState() {
        return questionnaireState;
    }

    public void setQuestionnaireState(Integer questionnaireState) {
        this.questionnaireState = questionnaireState;
    }

    public List<QuestionnaireContext> getQuestionnaireContexts() {
        return questionnaireContexts;
    }

    public void setQuestionnaireContexts(List<QuestionnaireContext> questionnaireContexts) {
        this.questionnaireContexts = questionnaireContexts;
    }

    public List<QuestionnaireContextTitle> getQuestionnaireContextTitles() {
        return questionnaireContextTitles;
    }

    public void setQuestionnaireContextTitles(List<QuestionnaireContextTitle> questionnaireContextTitles) {
        this.questionnaireContextTitles = questionnaireContextTitles;
    }
}
