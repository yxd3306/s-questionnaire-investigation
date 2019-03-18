package com.questionnaire.student.api;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.student.api
 * @Auther: yxd
 * @Date: 2019-02-19 12:31:18
 * @Description:
 */
@Component
public class StudentApi {

    @Autowired
    StudentService studentService;

    /**
     * 登录
     * @param request
     * @return
     */
    public JSONObject login(HttpServletRequest request) {

        return studentService.login(request);

    }

    /**
     * 注册
     * @param request
     * @return
     */
    public JSONObject register(HttpServletRequest request) {
        return studentService.register(request);
    }
}
