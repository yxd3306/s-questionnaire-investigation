package com.questionnaire.teacher.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.teacher.service
 * @Auther: yxd
 * @Date: 2019-02-19 12:54:30
 * @Description:
 */
public interface TeacherService {
    JSONObject login(HttpServletRequest request);

    JSONObject register(HttpServletRequest request);

    JSONObject selectQuestionnaires(HttpServletRequest request);

    JSONObject addTitle(HttpServletRequest request);

    JSONObject selectQuestionnaireByKey(HttpServletRequest request);

    JSONObject addContext(HttpServletRequest request);

    JSONObject deleteQuestionnaireById(HttpServletRequest request);

    JSONObject deleteContextByTitleId(HttpServletRequest request);

    JSONObject updateContext(HttpServletRequest request);

    JSONObject releaseQuestionnaire(HttpServletRequest request);

    JSONObject selectQuestionnaireByState(HttpServletRequest request);

    JSONObject selectQuestionnaireBySearch(HttpServletRequest request);

    JSONObject backQuestionnaireById(HttpServletRequest request);

    JSONObject selectSubmitDataById(HttpServletRequest request);

    JSONObject loadSubmitData(HttpServletRequest request);

    JSONObject selectTeacherByUserName(HttpServletRequest request);

    JSONObject forgot(HttpServletRequest request);
}
