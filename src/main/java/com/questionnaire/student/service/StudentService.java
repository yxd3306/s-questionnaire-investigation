package com.questionnaire.student.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.student.service
 * @Auther: yxd
 * @Date: 2019-02-19 12:43:05
 * @Description:
 */
public interface StudentService {
    JSONObject login(HttpServletRequest request);

    JSONObject register(HttpServletRequest request);

    JSONObject selectQuestionnaires(HttpServletRequest request);

    JSONObject selectQuestionnaireByStateForStudentId(HttpServletRequest request);

    JSONObject selectQuestionnaireById(HttpServletRequest request);

    JSONObject submitQuestionnaire(HttpServletRequest request);

    JSONObject loadSubmitData(HttpServletRequest request);
}
