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
 * @Description: 学生操作数据库api
 */
@Controller
@RequestMapping("/student")
public class StudentDBApi {


    @Autowired
    StudentService studentService;


    /**
     * 学生端 查询全部问卷
     * @param request
     * @return
     */
    @RequestMapping(value ="/selectQuestionnaires",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaires(HttpServletRequest request){
        return studentService.selectQuestionnaires(request);
    }

    /**
     * 学生端 根据问卷状态查询问卷
     * @param request
     * @return
     */
    @RequestMapping(value ="/selectQuestionnaireByStateForStudentId",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireByStateForStudentId(HttpServletRequest request){
        return studentService.selectQuestionnaireByStateForStudentId(request);
    }

    /**
     * 学生端 根据问卷id查询问卷
     * @param request
     * @return
     */
    @RequestMapping(value ="/selectQuestionnaireById",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireById(HttpServletRequest request){
        return studentService.selectQuestionnaireById(request);
    }

    /**
     * 提交问卷
     * @param request
     * @return
     */
    @RequestMapping(value ="/submitQuestionnaire",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject submitQuestionnaire(HttpServletRequest request){
        return studentService.submitQuestionnaire(request);
    }

    /**
     * 查询已提交的问卷详情
     * @param request
     * @return
     */
    @RequestMapping(value = "/loadSubmitData",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject loadSubmitData(HttpServletRequest request){
        return studentService.loadSubmitData(request);
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectTeacherByUserName",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectTeacherByUserName(HttpServletRequest request){
        return studentService.selectTeacherByUserName(request);
    }

    /**
     * 找回密码
     * @param request
     * @return
     */
    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject forgot(HttpServletRequest request){
        return studentService.forgot(request);
    }



}
