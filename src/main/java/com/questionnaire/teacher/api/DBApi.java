package com.questionnaire.teacher.api;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.teacher.api
 * @Auther: 喻湘东
 * @Email: Jyxd1997@163.com
 * @Date: 2019-02-20 09:44:52
 * @Description:
 */


@Controller
public class DBApi {


    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/teacher/selectQuestionnaires",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaires(HttpServletRequest request){
        return teacherService.selectQuestionnaires(request);
    }

    @RequestMapping(value = "/teacher/addTitle",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addTitle(HttpServletRequest request){
        return teacherService.addTitle(request);
    }

    @RequestMapping(value = "/teacher/selectQuestionnaireByKey",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireByKey(HttpServletRequest request){
        return teacherService.selectQuestionnaireByKey(request);
    }

    @RequestMapping(value = "/teacher/addContext",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addContext(HttpServletRequest request){
        return teacherService.addContext(request);
    }
    @RequestMapping(value = "/teacher/deleteQuestionnaireById",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteQuestionnaireById(HttpServletRequest request){
        return teacherService.deleteQuestionnaireById(request);
    }





}
