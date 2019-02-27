package com.questionnaire.student.api;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.student.api
 * @Auther: 喻湘东
 * @Email: Jyxd1997@163.com
 * @Date: 2019-02-25 10:36:15
 * @Description:
 */
@Controller
@RequestMapping("/student")
public class StudentDBApi {


    @Autowired
    StudentService studentService;


    @RequestMapping(value ="/selectQuestionnaires",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaires(HttpServletRequest request){
        return studentService.selectQuestionnaires(request);
    }
    @RequestMapping(value ="/selectQuestionnaireByStateForStudentId",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireByStateForStudentId(HttpServletRequest request){
        return studentService.selectQuestionnaireByStateForStudentId(request);
    }
    @RequestMapping(value ="/selectQuestionnaireById",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireById(HttpServletRequest request){
        return studentService.selectQuestionnaireById(request);
    }
    @RequestMapping(value ="/submitQuestionnaire",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject submitQuestionnaire(HttpServletRequest request){
        return studentService.submitQuestionnaire(request);
    }
    @RequestMapping(value = "/loadSubmitData",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject loadSubmitData(HttpServletRequest request){
        return studentService.loadSubmitData(request);
    }
    @RequestMapping(value = "/selectTeacherByUserName",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectTeacherByUserName(HttpServletRequest request){
        return studentService.selectTeacherByUserName(request);
    }
    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject forgot(HttpServletRequest request){
        return studentService.forgot(request);
    }



}
