package com.questionnaire.entity;

/**
 * @Package: com.questionnaire.entity
 * @Auther: 喻湘东
 * @Email: Jyxd1997@163.com
 * @Date: 2019-02-27 09:31:09
 * @Description:
 */
public class RestSubmitQuestionnaire {
    private Integer submitState;
    private Integer studentId;
    private Integer questionnaireId;

    private String studentName;
    private String submitTime;

    public Integer getSubmitState() {
        return submitState;
    }

    public void setSubmitState(Integer submitState) {
        this.submitState = submitState;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}
