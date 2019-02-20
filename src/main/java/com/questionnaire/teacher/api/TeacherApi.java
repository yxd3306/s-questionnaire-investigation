package com.questionnaire.teacher.api;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.teacher.api
 * @Auther: yxd
 * @Date: 2019-02-19 12:36:48
 * @Description:
 */
@Component
public class TeacherApi {


    @Autowired
    TeacherService teacherService;

    public JSONObject login(HttpServletRequest request) {
        return teacherService.login(request);
    }

    public JSONObject register(HttpServletRequest request) {
        return teacherService.register(request);
    }
}
