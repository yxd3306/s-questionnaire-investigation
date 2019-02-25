package com.questionnaire.student.api;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @RequestMapping("/selectQuestionnaires")
    @ResponseBody
    public JSONObject selectQuestionnaires(HttpServletRequest request){
        return studentService.selectQuestionnaires(request);
    }
    @RequestMapping("/selectQuestionnaireByStateForStudentId")
    @ResponseBody
    public JSONObject selectQuestionnaireByStateForStudentId(HttpServletRequest request){
        return studentService.selectQuestionnaireByStateForStudentId(request);
    }
    @RequestMapping("/selectQuestionnaireById")
    @ResponseBody
    public JSONObject selectQuestionnaireById(HttpServletRequest request){
        return studentService.selectQuestionnaireById(request);
    }



}
