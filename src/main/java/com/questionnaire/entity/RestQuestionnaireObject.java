package com.questionnaire.entity;

import java.util.List;

/**
 * @Package: com.questionnaire.entity
 * @Auther: 喻湘东
 * @Email: Jyxd1997@163.com
 * @Date: 2019-02-20 10:21:12
 * @Description: 返回问卷对象
 */
public class RestQuestionnaireObject {

    private Integer questionnaireId;
    private Integer teacherId;
    private Integer questionnaireTypeId;

    private String questionnaireTitle;
    private String questionnaireTypeName;
    private Integer questionnaireState;

    private String questionnaireCreateTime;
    private String questionnaireReleaseTime;
    private String submitTime;


    private List<QuestionnaireContext> questionnaireContexts;
    private List<QuestionnaireContextTitle> questionnaireContextTitles;

    private List<Questionnaire> questionnaires;
    private List<TeacherQuestionnaireStudent> teacherQuestionnaireStudents;
    private List<RestSubmitContext> submitContexts;

    private Integer submitQuestionnaireState;


    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public String getQuestionnaireCreateTime() {
        return questionnaireCreateTime;
    }

    public void setQuestionnaireCreateTime(String questionnaireCreateTime) {
        this.questionnaireCreateTime = questionnaireCreateTime;
    }

    public String getQuestionnaireReleaseTime() {
        return questionnaireReleaseTime;
    }

    public void setQuestionnaireReleaseTime(String questionnaireReleaseTime) {
        this.questionnaireReleaseTime = questionnaireReleaseTime;
    }

    public List<QuestionnaireContextTitle> getQuestionnaireContextTitles() {
        return questionnaireContextTitles;
    }

    public void setQuestionnaireContextTitles(List<QuestionnaireContextTitle> questionnaireContextTitles) {
        this.questionnaireContextTitles = questionnaireContextTitles;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<TeacherQuestionnaireStudent> getTeacherQuestionnaireStudents() {
        return teacherQuestionnaireStudents;
    }

    public void setTeacherQuestionnaireStudents(List<TeacherQuestionnaireStudent> teacherQuestionnaireStudents) {
        this.teacherQuestionnaireStudents = teacherQuestionnaireStudents;
    }

    public List<RestSubmitContext> getSubmitContexts() {
        return submitContexts;
    }

    public void setSubmitContexts(List<RestSubmitContext> submitContexts) {
        this.submitContexts = submitContexts;
    }

    public Integer getSubmitQuestionnaireState() {
        return submitQuestionnaireState;
    }

    public void setSubmitQuestionnaireState(Integer submitQuestionnaireState) {
        this.submitQuestionnaireState = submitQuestionnaireState;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }
}
